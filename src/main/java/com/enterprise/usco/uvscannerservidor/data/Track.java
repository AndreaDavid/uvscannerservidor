package com.enterprise.usco.uvscannerservidor.data;
// Generated 18/08/2017 11:37:09 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonFormat;
import com.vividsolutions.jts.geom.Point;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 * Track generated by hbm2java
 */
@Entity
@Table(name="track")
public class Track  implements java.io.Serializable {


     private Integer id;
     private Integer idUsuario;
     private String nombreUsuario;
     private String estado;
     private Date fechaServidor;
     private Date fechaMovil;
     private Date fechaCapturaGps;
     private Point posicion;
     private Boolean ubicacion;
     private Double frecuencia;
     private String lectura;
     private Float uvi;
     private Float altitud;
     private Float uviVelm;
     
    public Track() {
    }

   
    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="id_usuario")
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="nombre_usuario", length=150)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

     
    @Column(name="estado", length=100)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name="fecha_servidor", nullable=false, length=19)
    public Date getFechaServidor() {
        return this.fechaServidor!=null?mapearTimeZone(fechaServidor):null;        
    }
    public Date mapearTimeZone(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Long tiempo = fecha.getTime() + Calendar.getInstance().get(Calendar.ZONE_OFFSET);
        Date fechaSalida = new Date(tiempo);
        return fechaSalida;
    }
    
    public void setFechaServidor(Date fechaServidor) {
        this.fechaServidor = fechaServidor;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name="fecha_movil", length=19)
    public Date getFechaMovil() {
        return this.fechaMovil;
    }
    
    public void setFechaMovil(Date fechaMovil) {
        this.fechaMovil = fechaMovil;
    }

    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name="fecha_captura_gps", length=19)
    public Date getFechaCapturaGps() {
        return this.fechaCapturaGps;
    }
    
    public void setFechaCapturaGps(Date fechaCapturaGps) {
        this.fechaCapturaGps = fechaCapturaGps;
    }

    
    @Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name="posicion")
    public Point getPosicion() {
        return this.posicion;
    }
    
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    
      
    @Column(name="ubicacion")
    public Boolean getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Boolean ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    @Column(name="frecuencia", precision=22, scale=0)
    public Double getFrecuencia() {
        return this.frecuencia;
    }
    
    public void setFrecuencia(Double frecuencia) {
        this.frecuencia = frecuencia;
    }   
    
    
    @Column(name="lectura", length=100)
    public String getLectura() {
        return this.lectura;
    }
    
    public void setLectura(String lectura) {
       this.lectura = lectura;
    }
    
    @Column(name="uvi")
    public Float getUvi() {
        return uvi;
    }

    public void setUvi(Float uvi) {
        this.uvi = uvi;
    }
     @Column(name="uvi_velm")
    public Float getUviVelm() {
        return uviVelm;
    }

    public void setUviVelm(Float uviVelm) {
        this.uviVelm = uviVelm;
    }
    
    @Column(name="altitud")
    public Float getAltitud() {
        return altitud;
    }

    public void setAltitud(Float altitud) {
        this.altitud = altitud;
    }
    
}


