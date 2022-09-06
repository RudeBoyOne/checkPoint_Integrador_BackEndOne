package com.checkPoint.ProjetoIntegrador.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
        dentista = new Dentista(1, "Lorivaldo", "Silva", "D-SP: 3907");
        enderecoPaciente = new EnderecoPaciente(1, "Rua Anne Frank", 3050, "84567-211", "Laguna", "Santa Catarina");
        paciente = new Paciente(1, "Josivaldo", "Souza", enderecoPaciente, "68945644", LocalDate.now());
        consulta = new Consulta(1, paciente, dentista, LocalDateTime.now());
    }

    @Test
    public void verificaEstanciacaoConsulta(){
        assertEquals("Lorivaldo", consulta.getDentista().getNome());
        assertEquals("Josivaldo", consulta.getPaciente().getNome());
        assertEquals(1, consulta.getIdConsulta());

    }
}
