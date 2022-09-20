package com.checkPoint.ProjetoIntegrador.domain.repository;

import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByRg(String rg);
}
