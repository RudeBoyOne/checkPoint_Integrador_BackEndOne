package com.checkPoint.ProjetoIntegrador.domain.dataloader.repository;

import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoPacienteRepository extends JpaRepository<EnderecoPaciente, Integer> {
}
