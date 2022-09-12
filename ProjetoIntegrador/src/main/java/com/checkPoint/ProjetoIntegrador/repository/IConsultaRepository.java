package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {

}
