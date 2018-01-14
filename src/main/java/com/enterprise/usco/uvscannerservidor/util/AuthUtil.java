
package com.enterprise.usco.uvscannerservidor.util;


import com.enterprise.usco.uvscannerservidor.data.Usuario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuthUtil {

    /**
     * Variable para manejo de logs (mensajes, errores, entre otros) dentro de
     * la clase
     */
    private static final Log log = LogFactory.getLog(AuthUtil.class);

    /**
     * Método para recuperar los datos de autenticación en el sistema, estos
     * datos son el rol de autenticación, fecha de caducidad, entre otros.
     *
     * @return Objeto de autenticación con parametros de la autenticación
     * inicial, sino se puede recuperar el objeto se retorna null.
     */
    public static Authentication getCurrentAuth() {
        Authentication auth;
        try {
            auth = SecurityContextHolder.getContext().getAuthentication();
            log.info("Exito obteniendo datos de autenticacion, return resp= "+auth.isAuthenticated());
        } catch (Exception e) {
            auth = null;
            log.error("Error al obtener datos de autenticacion. No se puede obtener datos de autenticacion (rol de autenticacion, fecha de caducidad, entre otros), return null;", e);
        }
        return auth;
    }

    /**
     * Método para recuperar los datos del usuario autenticado en el sistema,
     * estos datos son los definidos en la entidad del usuario.
     *
     * @return Objeto usuario autenticado inicial, sino se puede recuperar el
     * objeto se retorna null.
     */
    public static Usuario getCurrentUser() {
        Usuario user;
        try {
            user = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //log.info("Exito obteniendo datos de usuario autenticado " + user.getNombres());
        } catch (Exception e) {
            user = null;
            log.error("Error al obtener datos del usuario autenticado. No se puede obtener datos del usuario autenticado (nombre, rol_usuario, entre otros); return null.\nPeticion desde formularios de registro de usuario");
        }
        return user;
    }
}
