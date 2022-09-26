package com.checkPoint.ProjetoIntegrador.api.controller;

import com.checkPoint.ProjetoIntegrador.api.assembler.DentistaAssembler;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.DentistaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DentistaController.class);

    @PostMapping
    public ResponseEntity<DentistaDTOOutput> criar(@Valid @RequestBody DentistaDTOInput dentista){
        logger.info("POST Dentista - Realizado com sucesso");
        return ResponseEntity.status(201).body(dentistaAssembler
                .toDentistaDTOOutput(dentistaService.criarDentista(dentistaAssembler.toEntity(dentista))));
    }

    @PutMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> atualizar(@Valid @PathVariable Integer idDentista, @RequestBody DentistaDTOInput dentista){
        if(!dentistaService.existeDentistaById(idDentista)){
            logger.info("PUT Dentista - Dentista nao encontrado");
            return ResponseEntity.notFound().build();
        }
        Dentista dentistaEntity = dentistaAssembler.toEntity(dentista);
        dentistaEntity.setIdDentista(idDentista);
        logger.info("PUT Dentista - Alterado com sucesso");
        return ResponseEntity.ok(dentistaAssembler.toDentistaDTOOutput(dentistaService.criarDentista(dentistaEntity)));
    }

    @GetMapping
    public List<DentistaDTOOutput> listar() {
        logger.info("GET Dentista - Lista de Dentistas");
        return dentistaAssembler.toCollectionOutput(dentistaService.buscarTodos());
    }

    @GetMapping("{idDentista}")
    public ResponseEntity<DentistaDTOOutput> buscarById(@PathVariable Integer idDentista){
        logger.info("GET Dentista - Busca de dentista por ID " + idDentista);
        return ResponseEntity.ok(dentistaAssembler.toDentistaDTOOutput(dentistaService.buscarDentistaById(idDentista)));
    }

    @DeleteMapping("{idDentista}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idDentista){
        if(!dentistaService.existeDentistaById(idDentista)){
            logger.info("DELETE Dentista - ID nao encontrado " + idDentista);
            return ResponseEntity.notFound().build();
        }
        logger.info("DELETE Dentista - Realizado com sucesso para ID " + idDentista);
        dentistaService.deletarDentistaById(idDentista);
        return ResponseEntity.noContent().build();
    }
}
