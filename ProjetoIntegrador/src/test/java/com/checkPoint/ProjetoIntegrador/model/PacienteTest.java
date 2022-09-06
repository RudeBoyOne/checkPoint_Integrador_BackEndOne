package com.checkPoint.ProjetoIntegrador.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PacienteTest {
    Paciente paciente;
    EnderecoPaciente enderecoPaciente;
    @BeforeEach
    public void iniciaPaciente(){
        enderecoPaciente = new EnderecoPaciente(1, "Rua Anne Frank", 3050, "84567-211", "Laguna", "Santa Catarina");

        paciente = new Paciente(1, "Josivaldo", "Souza", enderecoPaciente, "68945644", LocalDate.now());
    }

    @Test
    public void verificaEstanciacaoPaciente(){
        assertEquals(1, paciente.getIdPaciente());
        assertEquals("Josivaldo", paciente.getNome());
        assertEquals("Souza", paciente.getSobrenome());
        assertEquals(1, enderecoPaciente.getIdEndereco());
        assertEquals("68945644", paciente.getRg());
        assertEquals(LocalDate.now(),paciente.getDataAlta() );
    }
}
