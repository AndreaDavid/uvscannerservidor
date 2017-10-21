/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.usco.uvscannerservidor.controller;

import com.enterprise.usco.uvscannerservidor.data.Track;
import com.enterprise.usco.uvscannerservidor.data.dto.TrackDTO;
import com.enterprise.usco.uvscannerservidor.data.util.ExtJSReturnUtil;
import com.enterprise.usco.uvscannerservidor.data.util.JsonRequestMappingUtil;
import com.enterprise.usco.uvscannerservidor.repository.UVRadiationTrackRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@Configuration
@EnableAsync
@EnableScheduling
@JsonRequestMappingUtil("/raspberrycontroller")
public class UVRadiationRaspberryController {

    private static final Log log = LogFactory.getLog(UVRadiationRaspberryController.class);
/*
    @Autowired
    private SimpMessagingTemplate template;*/

    @Autowired//anotacion que permino no inicializar el repository
    private UVRadiationTrackRepository uvRadiationTrackRepository;
    

    @JsonRequestMappingUtil(value = "/insertarTracks", method = RequestMethod.POST)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar
    public @ResponseBody
    Map<String, Object> insertarTracks(@RequestBody List<TrackDTO> tracks) {//se comunica extjs (vista)
        //
        try {
            List<TrackDTO> insertados = new ArrayList<>();//se declara lista insertados

            for (TrackDTO track : tracks) {//for extendido recorre lista tracks 
                Track insertar = this.mapearTrack(track);//mapear trackdto a track
                insertar.setFechaCapturaGps(new Date());
                insertar.setFechaMovil(new Date());
                Track insertado = uvRadiationTrackRepository.save(insertar);//guardar en la base de datos el dato.
                
                insertados.add(mapearTrackDTO(insertado));//el que se insertó lo mapea a DTO y lo inserta 
            }
           // this.template.convertAndSend("/topic/actrecord", retornos);
            return ExtJSReturnUtil.mapOK(insertados);
        } catch (NumberFormatException l) {
          log.error("Error de parseo",l);
          return ExtJSReturnUtil.mapError("Error en insertarTracks");
        }
        
        catch (Exception e) {
            log.error("insertarTracks", e);
            return ExtJSReturnUtil.mapError("Error en insertarTracks");
        }
        
    }
    
    @JsonRequestMappingUtil(value = "/obtenerAllTracks", method = RequestMethod.GET)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar
    public @ResponseBody
    Map<String, Object> obtenerAllTracks() {//se comunica extjs (vista)
        //
        try {
            Iterable<Track> resultado = uvRadiationTrackRepository.findAll();
            List<TrackDTO> retorno=new ArrayList<>();
            for (Track track : resultado) {
                retorno.add(mapearTrackDTO(track));
            }
            return ExtJSReturnUtil.mapOK(retorno);
        }catch (Exception e) {
            log.error("insertarTracks", e);
            return ExtJSReturnUtil.mapError("Error en insertarTracks");
        }
        
    }
    

    private TrackDTO mapearTrackDTO(Track t) {
        TrackDTO newTrack = new TrackDTO();
      
        newTrack.setId(t.getId());
        newTrack.setIdUsuario(t.getIdUsuario());
        
        //fechamovil
        newTrack.setFechaMovil(t.getFechaMovil());
        
        //frecuencia
        newTrack.setFrecuencia(t.getFrecuencia());

        //estado
        newTrack.setEstado(t.getEstado());
        
        //fecha servidor
        newTrack.setFechaServidor(t.getFechaServidor());

        //usuario
        newTrack.setNombreUsuario(t.getNombreUsuario());
        
        //lectura
        newTrack.setLectura(t.getLectura());   
        

        if (t.getPosicion() != null) {
            newTrack.setLatitudPosicion(t.getPosicion().getX());
            newTrack.setLongitudPosicion(t.getPosicion().getY());
        }

        return newTrack;
    }

    private Track mapearTrack(TrackDTO t) {
        Track newTrack = new Track();

        newTrack.setId(t.getId());
        newTrack.setIdUsuario(t.getIdUsuario());

        //fechaMovil
        newTrack.setFechaMovil(t.getFechaMovil());
        
        //frecuencia
        newTrack.setFrecuencia(t.getFrecuencia());

        //Aplicacion
        newTrack.setEstado(t.getEstado());
        
        //fechaServidor
        newTrack.setFechaServidor(new Date());

        //usuario
        newTrack.setNombreUsuario(t.getNombreUsuario());
        
        //lectura
        newTrack.setLectura(t.getLectura());   

        if (t.getUbicacion() != null) {
            newTrack.setUbicacion(t.getUbicacion());
        } else {
            newTrack.setUbicacion(false);
        }

        //ubicacion
        newTrack.setFechaCapturaGps(t.getFechaCapturaGps());
        GeometryFactory gf = new GeometryFactory();
        if (t.getLatitudPosicion() != null && t.getLongitudPosicion() != null) {
            Point p = gf.createPoint(new Coordinate(t.getLatitudPosicion(), t.getLongitudPosicion()));
            newTrack.setPosicion(p);
        }

        return newTrack;
    }

}
