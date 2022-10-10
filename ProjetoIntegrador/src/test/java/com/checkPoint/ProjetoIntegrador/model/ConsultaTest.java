package com.checkPoint.ProjetoIntegrador.model;

import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ConsultaTest {
    Dentista dentista;
    Paciente paciente;
    EnderecoPaciente enderecoPaciente;
    Consulta consulta;

    @BeforeEach
    public void iniciaConsulta(){
        dentista = new Dentista("Lorivaldo", "Silva", "D-SP: 3907");
        enderecoPaciente = new EnderecoPaciente("Rua Anne Frank", 3050, "84567-211", "Laguna", "Santa Catarina");
        paciente = new Paciente("Josivaldo", "Souza", "68945644", enderecoPaciente);
        consulta = new Consulta(paciente, dentista, LocalDateTime.now());
    }

    @Test
    public void verificaEstanciacaoConsulta(){
        assertEquals("Lorivaldo", consulta.getDentista().getNome());
        assertEquals("Josivaldo", consulta.getPaciente().getNome());
    }
}
