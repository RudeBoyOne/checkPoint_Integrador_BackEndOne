package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.assembler.DentistaAssembler;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
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
    private DentistaAssembler dentistaAssembler;

    @PostMapping
    public ResponseEntity<DentistaDTOOutput> criar(@Valid @RequestBody DentistaDTOInput dentista){
        return ResponseEntity.status(201).body(dentistaAssembler
                .toDentistaDTOOutput(dentistaService.criarDentista(dentistaAssembler.toEntity(dentista))));
    }

    @PutMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> atualizar(@Valid @PathVariable Integer idDentista, @RequestBody DentistaDTOInput dentista){
        if(!dentistaService.existeDentistaById(idDentista)){
            return ResponseEntity.notFound().build();
        }
        Dentista dentistaEntity = dentistaAssembler.toEntity(dentista);
        dentistaEntity.setIdDentista(idDentista);
        return ResponseEntity.ok(dentistaAssembler.toDentistaDTOOutput(dentistaService.criarDentista(dentistaEntity)));
    }

    @GetMapping
    public List<DentistaDTOOutput> listar() {
        return dentistaAssembler.toCollectionOutput(dentistaService.buscarTodos());
    }

    @GetMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> buscarById(@PathVariable Integer idDentista){
        return ResponseEntity.ok(dentistaAssembler.toDentistaDTOOutput(dentistaService.buscarDentistaById(idDentista)));
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
