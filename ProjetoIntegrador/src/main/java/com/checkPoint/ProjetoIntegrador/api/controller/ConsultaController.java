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



    @PostMapping
    public ResponseEntity<ConsultaDTOOutput> criar(@RequestBody ConsultaDTOInput consulta){
        Paciente paciente = pacienteService.buscarPacienteById(consulta.getPaciente());
        Dentista dentista = dentistaService.buscarDentistaById(consulta.getDentista());
        Consulta consultaEntity = consultaAssembler.toEntity(consulta);
        consultaEntity.setPaciente(paciente);
        consultaEntity.setDentista(dentista);
        return ResponseEntity.status(201).body(consultaAssembler
                .toConsultaDTOOutput(consultaService.criarConsulta(consultaEntity)));
    }

    @PutMapping("/{idConsulta}")
    public ResponseEntity<ConsultaDTOOutput> atualizar(@PathVariable Integer idConsulta,
                                                 @RequestBody ConsultaDTOInput consulta){
        if(!consultaService.existeConsultaById(idConsulta)){
            return ResponseEntity.notFound().build();
        }
        Paciente paciente = pacienteService.buscarPacienteById(consulta.getPaciente());
        Dentista dentista = dentistaService.buscarDentistaById(consulta.getDentista());
        Consulta consultaEntity = consultaAssembler.toEntity(consulta);
        consultaEntity.setIdConsulta(idConsulta);
        consultaEntity.setPaciente(paciente);
        consultaEntity.setDentista(dentista);
        return ResponseEntity.ok(consultaAssembler
                .toConsultaDTOOutput(consultaService.criarConsulta(consultaEntity)));
    }

    @GetMapping
    public List<ConsultaDTOOutput> listar(){
        return consultaAssembler.toCollectionOutput(consultaService.listarTodasConsultas());
    }

    @GetMapping("/{idConsulta}")
    public ResponseEntity<ConsultaDTOOutput> buscarById(@PathVariable Integer idConsulta){
        return ResponseEntity.ok(consultaAssembler
                .toConsultaDTOOutput(consultaService.buscarCosultaById(idConsulta)));
    }

    @DeleteMapping("/{idConsulta}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer idConsulta){
        if(!consultaService.existeConsultaById(idConsulta)){
            return ResponseEntity.notFound().build();
        }
        consultaService.deletarConsultaById(idConsulta);
        return ResponseEntity.noContent().build();
    }


}
