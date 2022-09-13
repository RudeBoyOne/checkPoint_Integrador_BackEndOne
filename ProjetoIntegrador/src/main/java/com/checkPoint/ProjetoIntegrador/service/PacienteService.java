package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.dto.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.model.Paciente;
import com.checkPoint.ProjetoIntegrador.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    IPacienteRepository pacienteRepository;

    ObjectMapper objectMapper = new ObjectMapper();
    PacienteDTO pacienteDTO;

    public PacienteDTO criarPaciente(Paciente paciente)  {
        if(paciente == null){
            throw new ExceptionClinicaOdontologica("Dados não informados, ou faltantes, tente novamente!");
        }
        paciente = pacienteRepository.save(paciente);
        //objectMapper.findAndRegisterModules(); Chama os módulos reponsáveis de interpretar o LocalDate para o jackson
        pacienteDTO =  objectMapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    public PacienteDTO buscarPacienteById(Integer idPaciente){
        pacienteDTO = objectMapper.convertValue(pacienteRepository.findById(idPaciente).orElseThrow(
                ()-> new ExceptionClinicaOdontologica("Paciente não encontrado!")), PacienteDTO.class);
        return pacienteDTO;
    }

    public boolean existePacienteById(Integer idPaciente){
        return pacienteRepository.existsById(idPaciente);
    }

    public void deletarPacienteById(Integer idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }


}
