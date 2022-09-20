package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.PacienteDTOOutput;
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
    public ResponseEntity<PacienteDTOOutput> criar(@Valid @RequestBody Paciente paciente){
        PacienteDTOOutput pacienteDTOOutput;
        if(paciente != null){
            pacienteDTOOutput = pacienteService.criarPaciente(paciente);
            return ResponseEntity.status(201).body(pacienteDTOOutput);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTOOutput> atualizar(@Valid @PathVariable Integer idPaciente, @RequestBody Paciente paciente){
        PacienteDTOOutput pacienteDTOOutput;
        if(!pacienteService.existePacienteById(idPaciente)){
            return ResponseEntity.notFound().build();
        }
        paciente.setIdPaciente(idPaciente);
        pacienteDTOOutput = pacienteService.criarPaciente(paciente);
        return ResponseEntity.ok(pacienteDTOOutput);
    }

    @GetMapping
    public List<PacienteDTOOutput> listar(){
        return pacienteService.listarTodosPacientes();
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTOOutput> buscarById(@PathVariable Integer idPaciente){
        PacienteDTOOutput pacienteDTOOutput = pacienteService.buscarPacienteById(idPaciente);
        if(pacienteDTOOutput == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pacienteDTOOutput);
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
