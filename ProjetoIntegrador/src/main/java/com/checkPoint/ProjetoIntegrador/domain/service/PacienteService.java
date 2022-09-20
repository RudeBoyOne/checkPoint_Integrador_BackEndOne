package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.api.dtos.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    IPacienteRepository pacienteRepository;

    ObjectMapper objectMapper = new ObjectMapper();
    PacienteDTO pacienteDTO;

    public PacienteDTO criarPaciente(Paciente paciente)  {
        boolean rgJaExiste = pacienteRepository.findByRg(paciente.getRg()).stream()
                .anyMatch(pacienteExistente -> !pacienteExistente.equals(paciente));
        if (rgJaExiste){
            throw new ExceptionClinicaOdontologica("Já existe um Paciente cadastrado com este RG");
        }
        return objectMapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);
    }

    public PacienteDTO buscarPacienteById(Integer idPaciente){
        return pacienteRepository.findById(idPaciente).map(
                paciente-> objectMapper.convertValue(paciente, PacienteDTO.class)).orElse(null);
    }

    public List<PacienteDTO> listarTodosPacientes(){
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();
        for(Paciente paciente : pacienteRepository.findAll()){
            pacienteDTOS.add(objectMapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }

    public void deletarPacienteById(Integer idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }


    public boolean existePacienteById(Integer idPaciente){
        return pacienteRepository.existsById(idPaciente);
    }

}
