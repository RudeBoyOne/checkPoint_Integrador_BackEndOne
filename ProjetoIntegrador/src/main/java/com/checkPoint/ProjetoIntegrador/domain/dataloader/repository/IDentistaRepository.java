package com.checkPoint.ProjetoIntegrador.domain.dataloader.repository;

import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDentistaRepository extends JpaRepository<Dentista, Integer> {
    Optional<Dentista> findByMatriculaCadastro(String matriculaCadastro);
}
