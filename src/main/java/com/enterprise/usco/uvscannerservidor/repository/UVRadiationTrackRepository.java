package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.Track;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UVRadiationTrackRepository extends CrudRepository<Track, Integer> {
    
   //HQL lenguaje Hibernate, con la ventaja de cambiar motor de busqueda
   @Query(value = "SELECT r FROM Track r WHERE r.fechaServidor >= :fechaInferior AND r.fechaServidor<=:fechaSuperior ")//trae todos los trak que esten entre unas fechas
    public List<Track> findTracksReadDateRange(@Param("fechaInferior") Date fechaInferior,@Param("fechaSuperior") Date fechaSuperior);

   @Query(value = "SELECT t FROM Track t WHERE t.id = (SELECT MAX (r.id) FROM Track r WHERE r.lectura IS NULL)")//primero hace la consulta del max id, y luego solo trae el track de la consulta
    public Track findLastTrackDataUvi();
   //para hacer con sql puro
   @Query(value = "SELECT * FROM track t WHERE t.id = (SELECT MAX (r.id) FROM track r WHERE r.uvi IS NULL)",nativeQuery = true)//primero hace la consulta del max id, y luego solo trae el track de la consulta
    public Track findLastTrackDataLectura();

    
}
