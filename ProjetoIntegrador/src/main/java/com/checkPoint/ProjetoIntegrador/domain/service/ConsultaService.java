package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.exception.ClinicaOdontologicaException;
import com.checkPoint.ProjetoIntegrador.domain.exception.RecursoNaoEncontradoException;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.repository.IConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ConsultaService {
    private IConsultaRepository consultaRepository;

    @Transactional
    public Consulta criarConsulta(Consulta consulta){
        boolean consultaJaExistente = consultaRepository.findBydataHoraConsulta(consulta.getDataHoraConsulta())
                .stream().anyMatch(consultaExistente ->
                        !consultaExistente.equals(consulta));
        if(consultaJaExistente){
            throw new ClinicaOdontologicaException("Já existe uma consulta agendada neste dia e horário!");
        }
        return consultaRepository.save(consulta);
    }

    public Consulta buscarCosultaById(Integer idConsulta){
        return consultaRepository.findById(idConsulta).orElseThrow(
                () -> new RecursoNaoEncontradoException("Consulta não encontrada!"));
    }

    public List<Consulta> listarTodasConsultas(){
        return consultaRepository.findAll();
    }

    public boolean existeConsultaById(Integer idConsulta){
        return consultaRepository.existsById(idConsulta);
    }

    @Transactional
    public void deletarConsultaById(Integer idConsulta){
        consultaRepository.deleteById(idConsulta);
    }

}
