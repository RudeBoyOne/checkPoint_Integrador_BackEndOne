package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.dtos.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> criar(@Valid @RequestBody Paciente paciente){
        PacienteDTO pacienteDTO;
        if(paciente != null){
            pacienteDTO = pacienteService.criarPaciente(paciente);
            return ResponseEntity.status(201).body(pacienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTO> atualizar(@Valid @PathVariable Integer idPaciente, @RequestBody Paciente paciente){
        PacienteDTO pacienteDTO;
        if(!pacienteService.existePacienteById(idPaciente)){
            return ResponseEntity.notFound().build();
        }
        paciente.setIdPaciente(idPaciente);
        pacienteDTO = pacienteService.criarPaciente(paciente);
        return ResponseEntity.ok(pacienteDTO);
    }

    @GetMapping
    public List<PacienteDTO> listar(){
        return pacienteService.listarTodosPacientes();
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTO> buscarById(@PathVariable Integer idPaciente){
        PacienteDTO pacienteDTO = pacienteService.buscarPacienteById(idPaciente);
        if(pacienteDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pacienteDTO);
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Void> deletarById(@PathVariable Integer idPaciente) {
        if(!pacienteService.existePacienteById(idPaciente)){
            return ResponseEntity.notFound().build();
        }
        pacienteService.deletarPacienteById(idPaciente);
        return ResponseEntity.noContent().build();
    }



}
