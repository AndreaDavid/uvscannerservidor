/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.usco.uvscannerservidor.controller;

import com.enterprise.usco.uvscannerservidor.data.util.ExtJSReturnUtil;
import com.enterprise.usco.uvscannerservidor.data.util.JsonRequestMappingUtil;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
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
    
    @JsonRequestMappingUtil(value = "/login", method = RequestMethod.POST)//declara la direccion del metodo y cuales es el tipo de peticion que se debe usar
    public @ResponseBody
    Map<String, Object> obtenerAllTracksForRange(@RequestParam(value = "user", required = true) String user,
                                                @RequestParam(value = "password", required = true) String password) {//se comunica extjs (vista)
        log.info(user+password);
        return ExtJSReturnUtil.mapOk(user);

    }
}
