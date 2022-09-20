package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.api.dtos.ConsultaDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.repository.IConsultaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    IConsultaRepository consultaRepository;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    DentistaService dentistaService;

    ConsultaDTO consultaDTO;
    ObjectMapper objectMapper;


    @Transactional
    public ConsultaDTO criarConsulta(Consulta consulta){
        boolean consultaJaExistente = consultaRepository.findBydataHoraConsulta(consulta.getDataHoraConsulta())
                .stream().anyMatch(consultaExistente ->
                        !consultaExistente.getDataHoraConsulta().equals(consulta.getDataHoraConsulta()));
        if(consultaJaExistente){
            throw new ExceptionClinicaOdontologica("Já existe uma consulta agendada neste dia e horário!");
        }

        consulta.setPaciente(pacienteService.buscarPacienteById(consulta.getPaciente().getIdPaciente()));
        consulta.setDentista(dentistaService.buscarDentistaById(consulta.getDentista().getIdDentista()));
        Consulta consultaSalva = consultaRepository.save(consulta);
        consultaDTO= new ConsultaDTO();
        return consultaDTO.toConsultaDTO(consultaSalva);
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
