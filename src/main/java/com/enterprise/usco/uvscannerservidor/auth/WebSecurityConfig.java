
package com.enterprise.usco.uvscannerservidor.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Método de configuración principal de clase WebSecurity
     *
     * @param web Objeto Web de seguridad
     * @throws java.lang.Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    /**
     * Método de configuración de accesos a controladores, recursos, entre
     * otros; del proyecto principal. Este permite crear accesos a controladores
     * personalizados o que se les quiere dar acceso desde otros proyectos.
     *
     * @param http Petición HTTP que llega de la clase que consume
     * @throws java.lang.Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/accesscontroller/verificarSesion*").permitAll()
                .antMatchers("/accesscontroller/register*").permitAll()
                .antMatchers("/accesscontroller/login*").permitAll()
                .antMatchers("/").permitAll()
                //.anyRequest().anonymous()
                .and()
                .formLogin()
                .loginPage("/")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/");

        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

}
