package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoPacienteRepository extends JpaRepository<EnderecoPaciente, Integer> {
}
