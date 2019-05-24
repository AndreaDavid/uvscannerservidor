/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.DataUV;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Julián Andrés Bolaños Ortega
 */
public interface NativeQueryRepository {
    public List<DataUV> findLastTrack(@Param("fechaInferior") Date fechaInferior,@Param("fechaSuperior") Date fechaSuperior); 
}
