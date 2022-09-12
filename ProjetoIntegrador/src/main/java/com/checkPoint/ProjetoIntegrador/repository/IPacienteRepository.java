package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
