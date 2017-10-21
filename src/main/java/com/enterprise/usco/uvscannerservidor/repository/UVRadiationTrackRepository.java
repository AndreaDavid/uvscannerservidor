package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.Track;
import org.springframework.data.repository.CrudRepository;


public interface UVRadiationTrackRepository extends CrudRepository<Track, Integer> {
     
    
}