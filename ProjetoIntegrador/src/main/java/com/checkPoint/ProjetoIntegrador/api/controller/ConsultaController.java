package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.assembler.ConsultaAssembler;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.ConsultaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.ConsultaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.service.ConsultaService;
import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    ConsultaService consultaService;
    ConsultaAssembler consultaAssembler;
    PacienteService pacienteService;
    DentistaService dentistaService;

    private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @PostMapping
    public ResponseEntity<ConsultaDTOOutput> criar(@RequestBody ConsultaDTOInput consulta){
        Paciente paciente = pacienteService.buscarPacienteById(consulta.getPaciente());
        Dentista dentista = dentistaService.buscarDentistaById(consulta.getDentista());
        Consulta consultaEntity = consultaAssembler.toEntity(consulta);
        consultaEntity.setPaciente(paciente);
        consultaEntity.setDentista(dentista);

        logger.info("POST Consulta - Realizado com sucesso");
        return ResponseEntity.status(201).body(consultaAssembler
                .toConsultaDTOOutput(consultaService.criarConsulta(consultaEntity)));
    }

    @PutMapping("/{idConsulta}")
    public ResponseEntity<ConsultaDTOOutput> atualizar(@PathVariable Integer idConsulta,
                                                 @RequestBody ConsultaDTOInput consulta){
        if(!consultaService.existeConsultaById(idConsulta)){
            logger.info("PUT Consulta - Consulta nao encontrada " + idConsulta);
            return ResponseEntity.notFound().build();
        }
        Paciente paciente = pacienteService.buscarPacienteById(consulta.getPaciente());
        Dentista dentista = dentistaService.buscarDentistaById(consulta.getDentista());
        Consulta consultaEntity = consultaAssembler.toEntity(consulta);
        consultaEntity.setIdConsulta(idConsulta);
        consultaEntity.setPaciente(paciente);
        consultaEntity.setDentista(dentista);
        logger.info("PUT Consulta - Alteracao realizada com sucesso ID " + idConsulta);
        return ResponseEntity.ok(consultaAssembler
                .toConsultaDTOOutput(consultaService.criarConsulta(consultaEntity)));
    }

    @GetMapping
    public List<ConsultaDTOOutput> listar(){
        logger.info("GET Consulta - Lista de consultas realizada");
        return consultaAssembler.toCollectionOutput(consultaService.listarTodasConsultas());
    }

    @GetMapping("/{idConsulta}")
    public ResponseEntity<ConsultaDTOOutput> buscarById(@PathVariable Integer idConsulta){
        logger.info("GET Consulta - Busca comsulta por ID " + idConsulta);
        return ResponseEntity.ok(consultaAssembler
                .toConsultaDTOOutput(consultaService.buscarCosultaById(idConsulta)));
    }

    @DeleteMapping("/{idConsulta}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer idConsulta){
        if(!consultaService.existeConsultaById(idConsulta)){
            logger.info("DELETE Consulta - Registro não encontrado ID " + idConsulta);
            return ResponseEntity.notFound().build();
        }
        consultaService.deletarConsultaById(idConsulta);
        logger.info("DELETE Consulta - Realizado com sucesso para ID " + idConsulta);
        return ResponseEntity.noContent().build();
    }


}
