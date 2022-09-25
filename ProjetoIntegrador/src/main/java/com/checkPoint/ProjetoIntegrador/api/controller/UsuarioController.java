package com.checkPoint.ProjetoIntegrador.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    @GetMapping("/")
    public String home(){
        logger.info("Realizado Login");
        return "<h1> Seja bem vindo </h1>";
    }

    @GetMapping("/user")
    public String user(){
        logger.info("Realizado Login USER");
        return "<h1> Seja bem vindo Usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        logger.info("Realizado login ADMIN");
        return "<h1> Seja bem vindo Admin</h1>";
    }
}
