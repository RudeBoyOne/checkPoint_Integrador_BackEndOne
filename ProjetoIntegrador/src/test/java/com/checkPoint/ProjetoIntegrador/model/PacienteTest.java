package com.checkPoint.ProjetoIntegrador.model;

import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PacienteTest {
    Paciente paciente;
    EnderecoPaciente enderecoPaciente;
    @BeforeEach
    public void iniciaPaciente(){
        enderecoPaciente = new EnderecoPaciente("Rua Anne Frank", 3050, "84567-211", "Laguna", "Santa Catarina");

        paciente = new Paciente("Josivaldo", "Souza", "68945644", enderecoPaciente);
    }

    @Test
    public void verificaEstanciacaoPaciente(){
        assertEquals("Josivaldo", paciente.getNome());
        assertEquals("Souza", paciente.getSobrenome());
        assertEquals("68945644", paciente.getRg());
        assertEquals("Rua Anne Frank", paciente.getEnderecoPaciente().getRua());
        assertEquals("84567-211", paciente.getEnderecoPaciente().getCep());
    }
}
