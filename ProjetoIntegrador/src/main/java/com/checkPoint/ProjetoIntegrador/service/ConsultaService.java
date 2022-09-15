package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.dto.ConsultaDTO;
import com.checkPoint.ProjetoIntegrador.model.Consulta;
import com.checkPoint.ProjetoIntegrador.repository.IConsultaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    IConsultaRepository consultaRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    ConsultaDTO consultaDTO;

    public ConsultaDTO criarConsulta(Consulta consulta){
        if (consulta== null){
            throw new ExceptionClinicaOdontologica("Dados não informados, ou faltantes, tente novamente!");
        }
        consulta = consultaRepository.save(consulta);
        consultaDTO = new ConsultaDTO();
        //objectMapper.findAndRegisterModules();
        //consultaDTO = objectMapper.convertValue(consulta, ConsultaDTO.class);
        return consultaDTO.toConsultaDTO(consulta);
    }

    public ConsultaDTO buscarCosultaById(Integer idConsulta){
        consultaDTO = new ConsultaDTO();
        Consulta consulta = new Consulta();
        consulta = consultaRepository.findById(idConsulta).orElseThrow(
                ()-> new ExceptionClinicaOdontologica("consulta não encontrada"));

        return consultaDTO.toConsultaDTO(consulta);
    }


}
