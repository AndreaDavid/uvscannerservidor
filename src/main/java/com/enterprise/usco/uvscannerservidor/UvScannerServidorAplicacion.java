package com.enterprise.usco.uvscannerservidor;



import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class UvScannerServidorAplicacion {

    public static void main(String[] args) {
        SpringApplication.run(UvScannerServidorAplicacion.class, args);
    }
    
    @Bean  
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
         return hemf.getSessionFactory();  
    } 
}