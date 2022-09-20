package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.DentistaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private DentistaService dentistaService;

    @PostMapping
    public ResponseEntity<DentistaDTOOutput> criar(@Valid @RequestBody Dentista dentista){
        return ResponseEntity.status(201).body(dentistaService.criarDentista(dentista));
    }

    @PutMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> atualizar(@Valid @PathVariable Integer idDentista, @RequestBody Dentista dentista){
        if(!dentistaService.existeDentistaById(idDentista)){
            return ResponseEntity.notFound().build();
        }
        dentista.setIdDentista(idDentista);
        return ResponseEntity.ok(dentistaService.criarDentista(dentista));
    }

    @GetMapping
    public List<DentistaDTOOutput> listar() {
        return  dentistaService.buscarTodos();
    }

    @GetMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> buscarById(@PathVariable Integer idDentista){
        DentistaDTOOutput dentistaDTOOutput = dentistaService.buscarDentistaById(idDentista);
        if (dentistaDTOOutput == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dentistaDTOOutput);
    }

    @DeleteMapping("{idDentista}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idDentista){
        if(!dentistaService.existeDentistaById(idDentista)){
            return ResponseEntity.notFound().build();
        }
        dentistaService.deletarDentistaById(idDentista);
        return ResponseEntity.noContent().build();
    }
}
