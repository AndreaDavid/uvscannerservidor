
package com.enterprise.usco.uvscannerservidor.auth;


import com.enterprise.usco.uvscannerservidor.data.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SecurityService {

    /**
     * Interfaz para abrir conexión y manejo de seguridad (Spring Security) de
     * módulos (web, mmóvil)
     *
     * @param usuario Objeto usuario para creación de token (cookie)
     * @param remember Estado de manejo de sesión, (recordado o no)
     */
    void login(Usuario usuario, Boolean remember);

    /**
     * Interfaz para cerrar conexión y manejo de seguridad (Spring Security) de
     * módulos (web, móvil)
     *
     * @param request Petición HTTP servlet con cabecera de cierre de sesión
     * @param response Respuesta HTTP servlet con resultado de petición
     * @return Estado o bandera de finalización de sesión (true o false)
     */
    Boolean logout(HttpServletRequest request, HttpServletResponse response);


}
