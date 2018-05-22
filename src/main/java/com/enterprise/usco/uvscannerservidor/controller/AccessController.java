/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.usco.uvscannerservidor.controller;

import com.enterprise.usco.uvscannerservidor.auth.SecurityService;
import com.enterprise.usco.uvscannerservidor.data.Usuario;
import org.springframework.web.servlet.ModelAndView;
import com.enterprise.usco.uvscannerservidor.data.util.ExtJSReturnUtil;
import com.enterprise.usco.uvscannerservidor.data.util.JsonRequestMappingUtil;
import com.enterprise.usco.uvscannerservidor.repository.UsuarioRepository;
import com.enterprise.usco.uvscannerservidor.util.AuthUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Configuration
@EnableAsync
@EnableScheduling
@JsonRequestMappingUtil("/accesscontroller")
public class AccessController {

    private static final Log log = LogFactory.getLog(AccessController.class);

    @Autowired//anotacion que permino no inicializar el repository
    private UsuarioRepository usuarioRepository;

    @Autowired
    protected SecurityService securityService;

    @JsonRequestMappingUtil(value = "/login", method = RequestMethod.POST)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar
    public @ResponseBody
    Map<String, Object> login(@RequestParam(value = "correo", required = true) String correo,
            @RequestParam(value = "password", required = true) String password) {//se comunica extjs (vista)
        List<Usuario> correos = usuarioRepository.findUserByPasswordAndCorreo(correo, password);
        if (correos.size() > 0) {
            securityService.login(correos.stream().findFirst().orElse(null), Boolean.TRUE);
            return ExtJSReturnUtil.mapOK(correos);
        } else {
            return ExtJSReturnUtil.mapError("usuarioNoRegistrado");
        }
    }
    @JsonRequestMappingUtil(value = "/logout", method = RequestMethod.GET)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar
    public @ResponseBody
    ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {//se comunica extjs (vista)
       securityService.logout(request, response);
       return new ModelAndView("redirect:/");
    }

    @JsonRequestMappingUtil(value = "/register", method = RequestMethod.POST)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar

    public @ResponseBody
    Map<String, Object> register(//parametros que deben estar presente, no puede ser nulos
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "correo", required = true) String correo,
            @RequestParam(value = "nombre", required = true) String nombre) {//se comunica extjs (vista)

        List<Usuario> usuarios = usuarioRepository.findUserByCorreo(correo);//trae todos los usuarios que tengan el mismo nombre ingersado
        if (usuarios.size() > 0) {

            return ExtJSReturnUtil.mapError("usuarioExistente");//
        }
        Usuario usuario = new Usuario(nombre, password, correo, correo);

//usuario.setCorreo(correo);
        //usuario.setPassword(password);
        //usuario.setNombreUsuario(nombre);
        log.info(correo + password);
        usuarioRepository.save(usuario);
        return ExtJSReturnUtil.mapOk(correo);

    }

    private static class Correo {

        public Correo() {
        }
    }

    @JsonRequestMappingUtil(value = "/verificarSesion", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> verificarSesion() {
        Authentication auth = AuthUtil.getCurrentAuth();
        if (auth != null) {
            Usuario user = AuthUtil.getCurrentUser();
            //Usuario userDB = usuarioServicio.findUsuarioByEmail(user.getCorreo());
            if (user != null) {
                return ExtJSReturnUtil.mapOK(user);

            } else {
                return ExtJSReturnUtil.mapError("noSesion");
            }

        } else {
            return ExtJSReturnUtil.mapError("noSesion");
        }
    }
}
