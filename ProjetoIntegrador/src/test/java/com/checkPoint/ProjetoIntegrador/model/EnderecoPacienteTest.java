package com.checkPoint.ProjetoIntegrador.model;

import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EnderecoPacienteTest {
    EnderecoPaciente enderecoPaciente;

    @BeforeEach
    public void iniciaEnderecoPaciente(){
        enderecoPaciente = new EnderecoPaciente("Rua soldado sebatião", 3568, "24567-211", "Rio de janeiro", "Rio de janeiro");
    }

    @Test
    public void verificaEstanciacaoEnderecoPaciente(){
        assertEquals("Rua soldado sebatião", enderecoPaciente.getRua());
        assertEquals(3568, enderecoPaciente.getNumero());
        assertEquals("24567-211", enderecoPaciente.getCep());
        assertEquals("Rio de janeiro", enderecoPaciente.getCidade());
        assertEquals("Rio de janeiro", enderecoPaciente.getEstado());
    }
}
