package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.repository.IConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ConsultaService {
    IConsultaRepository consultaRepository;
    PacienteService pacienteService;
    DentistaService dentistaService;


    @Transactional
    public Consulta criarConsulta(Consulta consulta){
        boolean consultaJaExistente = consultaRepository.findBydataHoraConsulta(consulta.getDataHoraConsulta())
                .stream().anyMatch(consultaExistente ->
                        !consultaExistente.getDataHoraConsulta().equals(consulta.getDataHoraConsulta()));
        if(consultaJaExistente){
            throw new ExceptionClinicaOdontologica("Já existe uma consulta agendada neste dia e horário!");
        }

        consulta.setPaciente(pacienteService.buscarPacienteById(consulta.getPaciente().getIdPaciente()));
        consulta.setDentista(dentistaService.buscarDentistaById(consulta.getDentista().getIdDentista()));
        return consultaRepository.save(consulta);
    }

    public Consulta buscarCosultaById(Integer idConsulta){
        return consultaRepository.findById(idConsulta).orElse(null);
    }

    public List<Consulta> listarTodasConsultas(){
        return consultaRepository.findAll();
    }

    public boolean existeConsultaById(Integer idConsulta){
        return consultaRepository.existsById(idConsulta);
    }

    public void deletarConsultaById(Integer idConsulta){
        consultaRepository.deleteById(idConsulta);
    }

}
