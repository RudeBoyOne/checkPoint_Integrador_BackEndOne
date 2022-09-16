package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.dto.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.model.Paciente;
import com.checkPoint.ProjetoIntegrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody Paciente paciente){
        PacienteDTO pacienteDTO;
        if(paciente != null){
            pacienteDTO = pacienteService.criarPaciente(paciente);
            return ResponseEntity.status(201).body(pacienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<PacienteDTO> atualizar(@PathVariable Integer idPaciente, @RequestBody Paciente paciente){
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
        PacienteDTO pacienteDTO;
        pacienteDTO = pacienteService.buscarPacienteById(idPaciente);
        return ResponseEntity.ok(pacienteDTO);
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
