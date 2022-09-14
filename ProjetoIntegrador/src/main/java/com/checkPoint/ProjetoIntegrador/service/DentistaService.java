package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.dto.DentistaDTO;
import com.checkPoint.ProjetoIntegrador.dto.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.model.Dentista;
import com.checkPoint.ProjetoIntegrador.repository.IDentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    @Autowired
    IDentistaRepository dentistaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    DentistaDTO dentistaDTO;

    public DentistaDTO criarDentista(Dentista dentista) {
        if(dentista == null) {
            throw new ExceptionClinicaOdontologica("Dados não informados, ou faltantes, tente novamente!");
        }
        dentista = dentistaRepository.save(dentista);
        dentistaDTO = objectMapper.convertValue(dentista, DentistaDTO.class);
        return dentistaDTO;
    }

    public DentistaDTO buscarDentistaById(Integer idDentista) {
        dentistaDTO = objectMapper.convertValue(dentistaRepository.findById(idDentista).orElseThrow(
                ()-> new ExceptionClinicaOdontologica("Dentista não encontrado!")), DentistaDTO.class);
        return dentistaDTO;
    }

    public List<Dentista> buscarTodos() {
        return dentistaRepository.findAll();
    }

    public String deletarDentistaById(Integer idDentista) {
        dentistaRepository.deleteById(idDentista);
        return "Dentista excluído.";
    }

}
