package com.enterprise.usco.uvscannerservidor;



import com.enterprise.usco.uvscannerservidor.auth.WebSecurityConfig;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import(WebSecurityConfig.class)
public class UvScannerServidorAplicacion 
       extends SpringBootServletInitializer {

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
return builder.sources(new Class[]{UvScannerServidorAplicacion.class}); //To change body of generated methods, choose Tools | Templates.
}
    
    public static void main(String[] args) {
        SpringApplication.run(UvScannerServidorAplicacion.class, args);
    }
    
    @Bean  
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
         return hemf.getSessionFactory();  
    } 
}