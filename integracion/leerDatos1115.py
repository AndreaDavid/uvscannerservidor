import time
import Adafruit_ADS1x15
import requests
import veml6070
import gpsController
import math

 
def outData(lectura,uvi,latitude,longitude,altitude):
    vol=lectura*0.0001875057222
    reqUrl = "http://192.168.0.102:8784/uvradiation/raspberrycontroller/insertarTracksUvi"; #direccion servidor
    try:
        r=requests.post(
         reqUrl,
          json=[{
                    "id":None,
                    "idUsuario":1,
                    "nombreUsuario":"Paola y su cerveza",
                    "estado":"activo",
                    "fechaServidor":None,
                    "fechaMovil":None,
                    "fechaCapturaGps":None,
                    "ubicacion":None,
                    "frecuencia":"1000",
                    "uvi":uvi,
                    "latitudPosicion":latitude,
                    "longitudPosicion":longitude,
                    "altitud":altitude,
                    "lectura":vol
                    }
                   ]
          ,timeout = 10)
        print r.json()
        print(lectura)
    except requests.exceptions.ConnectTimeout:
        print "El servidor NO se encuentra disponible"
    except:
        print "Error de valor"

adc = Adafruit_ADS1x15.ADS1115()
gpsCont = gpsController.GpsController()
gpsCont.start()
veml = veml6070.Veml6070()
GAIN = 2/3
adc.start_adc(0, gain=GAIN)
print('Reading ADS1x15 channel 0-3 for 3 seconds...')
start = time.time() 
print("Inicio"+str(start))
while (time.time() - start) <= 10:
    if not math.isnan(gpsCont.fix.altitude):
        # Read the last ADC conversion value and print it out.
        values = [0]*4
        for i in range(4):
            # Read the specified ADC channel using the previously set gain value.
            values[i] = adc.read_adc(i, gain=GAIN)
        #print('| {0:>6} | {1:>6} | {2:>6} | {3:>6} |'.format(*values))
        lectura = values[0]
        print('Obtenido dato de lectura')
        uviRes=0
        for i in [veml6070.INTEGRATIONTIME_1_2T,
                veml6070.INTEGRATIONTIME_1T,
                veml6070.INTEGRATIONTIME_2T,
                veml6070.INTEGRATIONTIME_4T]:
            veml.set_integration_time(i)
            uv_raw = veml.get_uva_light_intensity_raw()
            uviRes=uv_raw
            uv = veml.get_uva_light_intensity()
            print "Integration Time setting %d: %f W/(m*m) from raw value %d" % (i, uv, uv_raw)
        
        print("Obtenido dato de UVI")
        outData(values[0],uviRes,gpsCont.fix.latitude,gpsCont.fix.longitude,gpsCont.fix.altitude)
        time.sleep(1)

# Stop continuous conversion.  After this point you can't get data from get_last_result!
print('Deteniendo ADC')
gpsCont.stopController()
#wait for the tread to finish
gpsCont.join()
adc.stop_adc()
print('Finish')
exit()

