package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.api.dtos.DentistaDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.repository.IDentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaService {

    @Autowired
    IDentistaRepository dentistaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public DentistaDTO criarDentista(Dentista dentista) {
        boolean matriculaJaExiste = dentistaRepository.findByMatriculaCadastro(dentista.getMatriculaCadastro())
                .stream().anyMatch(dentistaExistente -> !dentistaExistente.equals(dentista));
        if(matriculaJaExiste){
            throw new ExceptionClinicaOdontologica("Já existe um Dentista cadastrado com este CFO");
        }
        return objectMapper.convertValue(dentistaRepository.save(dentista), DentistaDTO.class);
    }

    public DentistaDTO buscarDentistaById(Integer idDentista) {
        return dentistaRepository.findById(idDentista).map(
                dentista -> objectMapper.convertValue(dentista, DentistaDTO.class)).orElse(null);
    }

    public List<DentistaDTO> buscarTodos() {
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();
        dentistaRepository.findAll().stream().forEach(
                dentista -> dentistaDTOS.add(objectMapper.convertValue(dentista, DentistaDTO.class)));
        return dentistaDTOS;
    }

    @Transactional
    public void deletarDentistaById(Integer idDentista) {
        dentistaRepository.deleteById(idDentista);
    }

    public boolean existeDentistaById(Integer idDentista){
        return dentistaRepository.existsById(idDentista);
    }

}
