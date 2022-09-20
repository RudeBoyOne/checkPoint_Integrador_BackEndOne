package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.ConsultaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTOOutput> criar(@RequestBody Consulta consulta){
        return ResponseEntity.status(201).body(consultaService.criarConsulta(consulta));
    }

    @GetMapping
    public List<ConsultaDTOOutput> listar(){
        return consultaService.listarTodasConsultas();
    }
}
