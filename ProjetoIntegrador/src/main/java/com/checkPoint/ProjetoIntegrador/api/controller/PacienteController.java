package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.assembler.PacienteAssembler;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
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
    private PacienteAssembler pacienteAssembler;

    @PostMapping
    public ResponseEntity<PacienteDTOOutput> criar(@Valid @RequestBody PacienteDTOInput paciente){
        return ResponseEntity.status(201).body(pacienteAssembler
                .toDTOOutput(pacienteService.criarPaciente(pacienteAssembler.toEntity(paciente))));
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTOOutput> atualizar(@Valid @PathVariable Integer idPaciente, @RequestBody PacienteDTOInput paciente){
        if(!pacienteService.existePacienteById(idPaciente)){
            return ResponseEntity.notFound().build();
        }
        Paciente pacienteEntity = pacienteAssembler.toEntity(paciente);
        pacienteEntity.setIdPaciente(idPaciente);
        return ResponseEntity.ok(pacienteAssembler.toDTOOutput(pacienteService.criarPaciente(pacienteEntity)));
    }

    @GetMapping
    public List<PacienteDTOOutput> listar(){
        return pacienteAssembler.toCollectionDTOOutput(pacienteService.listarTodosPacientes());
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTOOutput> buscarById(@PathVariable Integer idPaciente){
        return ResponseEntity.ok(pacienteAssembler.toDTOOutput(pacienteService.buscarPacienteById(idPaciente)));
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
