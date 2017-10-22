package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.Track;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UVRadiationTrackRepository extends CrudRepository<Track, Integer> {
     
   @Query(value = "SELECT r FROM Track r WHERE r.fechaServidor >= :fechaInferior AND r.fechaServidor<=:fechaSuperior ")
    public List<Track> findTracksReadDateRange(@Param("fechaInferior") Date fechaInferior,@Param("fechaSuperior") Date fechaSuperior);
}