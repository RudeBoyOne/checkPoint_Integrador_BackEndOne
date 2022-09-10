package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
