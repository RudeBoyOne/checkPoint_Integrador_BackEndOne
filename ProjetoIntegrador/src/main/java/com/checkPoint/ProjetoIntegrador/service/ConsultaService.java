package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.dto.ConsultaDTO;
import com.checkPoint.ProjetoIntegrador.model.Consulta;
import com.checkPoint.ProjetoIntegrador.repository.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    IConsultaRepository consultaRepository;

    ConsultaDTO consultaDTO;

    public ConsultaDTO criarConsulta(Consulta consulta){
        if (consulta== null){
            throw new ExceptionClinicaOdontologica("Dados não informados, ou faltantes, tente novamente!");
        }
        consulta = consultaRepository.save(consulta);
        consultaDTO = new ConsultaDTO();
        return consultaDTO.toConsultaDTO(consulta);
    }

    public ConsultaDTO buscarCosultaById(Integer idConsulta){
        consultaDTO = new ConsultaDTO();
        Consulta consulta = new Consulta();
        consulta = consultaRepository.findById(idConsulta).orElseThrow(
                ()-> new ExceptionClinicaOdontologica("consulta não encontrada"));
        return consultaDTO.toConsultaDTO(consulta);
    }

    public List<ConsultaDTO> listarTodasConsultas(){
        List<ConsultaDTO> consultaDTOList = new ArrayList<>();
        for(Consulta consulta : consultaRepository.findAll()){
            consultaDTOList.add(consultaDTO.toConsultaDTO(consulta));
        }
        return consultaDTOList;
    }

    public boolean existeConsultaById(Integer idConsulta){
        return consultaRepository.existsById(idConsulta);
    }

    public void deletarConsultaById(Integer idConsulta){
        consultaRepository.deleteById(idConsulta);
    }

}
