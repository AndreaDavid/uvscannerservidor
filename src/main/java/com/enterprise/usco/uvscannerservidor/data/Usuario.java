package com.enterprise.usco.uvscannerservidor.data;
// Generated 18/08/2017 11:37:09 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String user; 
     private String nombreUsuario;
     private String password;
     private String correo;
     
     
    public Usuario() {
    }


    public Usuario(String nombreUsuario, String password, String correo, String user) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.user = user; 
      
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

    @Column(name="nombre_usuario", length=150)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    @Column(name = "password",length=100)
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String contraseña){
        this.password = contraseña; 
    }
    
    @Column(name="correo", length=150)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Column(name="user", length=20)
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
}


