/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.usco.uvscannerservidor.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author Luis Solarte
 */
public class TrackDTO {

   private Integer id;
     private Integer idUsuario;
     private String nombreUsuario;
     private String estado;
     private Date fechaServidor;
     private Date fechaMovil;
     private Date fechaCapturaGps;
     private Boolean ubicacion;
     private Double frecuencia;
    private Double latitudPosicion;
    private Double longitudPosicion;
    private String lectura;
    
    
    
    
    

    public TrackDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ",timezone = "GMT-5",locale = "GMT-5")
    public Date getFechaServidor() {
        return fechaServidor;
    }

    /**
     * @param fechaServidor the fechaServidor to set
     */
    public void setFechaServidor(Date fechaServidor) {
        this.fechaServidor = fechaServidor;
    }

    /**
     * @return the fechaMovil
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    public Date getFechaMovil() {
        return fechaMovil;
    }

    /**
     * @param fechaMovil the fechaMovil to set
     */
    public void setFechaMovil(Date fechaMovil) {
        this.fechaMovil = fechaMovil;
    }

    /**
     * @return the fechaCapturaGps
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = JsonFormat.DEFAULT_TIMEZONE)
    public Date getFechaCapturaGps() {
        return fechaCapturaGps;
    }

    /**
     * @param fechaCapturaGps the fechaCapturaGps to set
     */
    public void setFechaCapturaGps(Date fechaCapturaGps) {
        this.fechaCapturaGps = fechaCapturaGps;
    }

    /**
     * @return the latitudPosicion
     */
    public Double getLatitudPosicion() {
        return latitudPosicion;
    }

    /**
     * @param latitudPosicion the latitudPosicion to set
     */
    public void setLatitudPosicion(Double latitudPosicion) {
        this.latitudPosicion = latitudPosicion;
    }

    /**
     * @return the longitudPosicion
     */
    public Double getLongitudPosicion() {
        return longitudPosicion;
    }

    /**
     * @param longitudPosicion the longitudPosicion to set
     */
    public void setLongitudPosicion(Double longitudPosicion) {
        this.longitudPosicion = longitudPosicion;
    }

    
    /**
     * @return the ubicacion
     */
    public Boolean getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Boolean ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the frecuencia
     */
    public Double getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(Double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setLectura(String lectura) {
        this.lectura=lectura;
    }

    public String getLectura() {
        return this.lectura;
    }
}
