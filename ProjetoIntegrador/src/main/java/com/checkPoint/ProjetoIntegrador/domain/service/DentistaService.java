package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.exception.ClinicaOdontologicaException;
import com.checkPoint.ProjetoIntegrador.domain.exception.RecursoNaoEncontradoException;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.repository.IDentistaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DentistaService {

    private IDentistaRepository dentistaRepository;

    @Transactional
    public Dentista criarDentista(Dentista dentista) {
        boolean matriculaJaExiste = dentistaRepository.findByMatriculaCadastro(dentista.getMatriculaCadastro())
                .stream().anyMatch(dentistaExistente -> !dentistaExistente.equals(dentista));
        if(matriculaJaExiste){
            throw new ClinicaOdontologicaException("Já existe um Dentista cadastrado com este CFO");
        }
        return dentistaRepository.save(dentista);
    }

    public Dentista buscarDentistaById(Integer idDentista) {
        return dentistaRepository.findById(idDentista).orElseThrow(
                () -> new RecursoNaoEncontradoException("Dentista não encontrado!"));
    }

    public List<Dentista> buscarTodos() {
        return dentistaRepository.findAll();
    }

    @Transactional
    public void deletarDentistaById(Integer idDentista) {
        dentistaRepository.deleteById(idDentista);
    }

    public boolean existeDentistaById(Integer idDentista){
        return dentistaRepository.existsById(idDentista);
    }

}
