package com.checkPoint.ProjetoIntegrador.domain.repository;

import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {
    Optional<Consulta> findBydataHoraConsulta(LocalDateTime dataHoraConsulta);
}
