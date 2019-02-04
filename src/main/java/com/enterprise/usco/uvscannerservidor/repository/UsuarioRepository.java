package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
     
    @Query(value = "SELECT v FROM Usuario v WHERE v.correo = :correo")
    public List<Usuario> findUserByCorreo(@Param("correo") String nombreUsuario);
 
    @Query(value = "SELECT v FROM Usuario v WHERE v.correo = :correo AND v.password =:password")
    public List<Usuario> findUserByPasswordAndCorreo(@Param("correo") String correo, @Param("password") String password);
 
}