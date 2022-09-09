package com.checkPoint.ProjetoIntegrador.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DentistaTest {
    Dentista dentista;

    @BeforeEach
    public void iniciaDentista(){
        dentista = new Dentista("Lorivaldo", "Silva", "D-SP: 3907");
    }

    @Test
    public void verificaEstanciacaoDentista(){
        assertEquals(1, dentista.getIdDentista());
        assertEquals("Lorivaldo", dentista.getNome());
        assertEquals("Silva", dentista.getSobrenome());
        assertEquals("D-SP: 3907", dentista.getMatriculaCadastro());
    }
}
