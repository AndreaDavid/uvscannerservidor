package com.enterprise.usco.uvscannerservidor.auth;

import com.enterprise.usco.uvscannerservidor.data.Usuario;
import com.enterprise.usco.uvscannerservidor.util.AuthUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;


@Service
public class SecurityServiceImpl implements SecurityService {

   
    private static final Log log = LogFactory.getLog(SecurityServiceImpl.class);

    @Override
    public void login(Usuario usuario, Boolean remember) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        Usuario user = usuario;
        Date tokenExpiration = new Date();
        if (remember) {
            /* Se fija un máximo de 48 horas para la sesión recordada (con el estado duradero de la sesión) */
            tokenExpiration.setTime(tokenExpiration.getTime() + 3600000 * 48);
        } else {
            /* Se fija un máximo de 4 horas para la sesión sin recordar (con el estado corto de la sesión) */
            tokenExpiration.setTime(tokenExpiration.getTime() + 3600000 * 4);
        }
        log.info("Fecha de Expiracion token: " + tokenExpiration);
        ExpiringUsernameAuthenticationToken token = new ExpiringUsernameAuthenticationToken(tokenExpiration, user, user.getPassword(), grantedAuthorities);
        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            log.info("User autenticado correctamente");
        }
    }

    /**
     * Método abstracto para el manejo de cierre de sesión de (web, móvil)
     *
     * @param request Petición HTTP servlet con cabecera de cierre de sesión
     * @param response Respuesta HTTP servlet con resultado de petición
     * @return Estado o bandera de finalización de sesión (true o false)
     */
    @Override
    public Boolean logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = AuthUtil.getCurrentAuth();
        if (auth != null) {
            try {
                new SecurityContextLogoutHandler().logout(request, response, auth);
                log.info("Exito al finalizar la sesion, return true;");
                return Boolean.TRUE;
            } catch (Exception e) {
                log.error("Error al ejecutar logout. No se puede finalizar la sesion, return false;", e);
                return Boolean.FALSE;
            }
        } else {
            log.info("User sin autenticacion, return false;");
            return Boolean.FALSE;
        }
    }

}
