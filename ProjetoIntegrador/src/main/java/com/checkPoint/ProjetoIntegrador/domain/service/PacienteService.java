package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.exception.ClinicaOdontologicaException;
import com.checkPoint.ProjetoIntegrador.domain.exception.RecursoNaoEncontradoException;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.repository.IPacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    IPacienteRepository pacienteRepository;

    @Transactional
    public Paciente criarPaciente(Paciente paciente)  {
        boolean rgJaExiste = pacienteRepository.findByRg(paciente.getRg()).stream()
                .anyMatch(pacienteExistente -> !pacienteExistente.equals(paciente));
        if (rgJaExiste){
            throw new ClinicaOdontologicaException("Já existe um Paciente cadastrado com este RG");
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacienteById(Integer idPaciente){
        return pacienteRepository.findById(idPaciente).orElseThrow(
                () -> new RecursoNaoEncontradoException("Paciente não encontrado!"));
    }

    public List<Paciente> listarTodosPacientes(){
        return pacienteRepository.findAll();
    }

    @Transactional
    public void deletarPacienteById(Integer idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }


    public boolean existePacienteById(Integer idPaciente){
        return pacienteRepository.existsById(idPaciente);
    }

}
