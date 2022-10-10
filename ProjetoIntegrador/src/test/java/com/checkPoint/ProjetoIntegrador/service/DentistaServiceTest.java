package com.checkPoint.ProjetoIntegrador.service;


import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.DentistaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DentistaServiceTest {

    @Autowired
    DentistaService dentistaService;

    Dentista dentista;

    @BeforeAll
    public void instanciaObjetosParaTestes(){
        dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
        dentista =  dentistaService.criarDentista(dentista);
    }

    @Test
    public void criarDentistaServiceTest() {
        Assertions.assertEquals("Ewerton", dentista.getNome());
        Assertions.assertEquals("Lopes", dentista.getSobrenome());
        Assertions.assertEquals("CRO-125987", dentista.getMatriculaCadastro());
    }

    @Test
    public void buscarDentistaByIdTest() {
        Dentista dentistaBuscado = dentistaService.buscarDentistaById(dentista.getIdDentista());
        Assertions.assertNotNull(dentistaBuscado);
    }

    @Test
    public void buscarTodosTest() {
        dentistaService.criarDentista(new Dentista("Lucas", "Adrian", "CRO-123456"));
        dentistaService.criarDentista(new Dentista("Everton", "Silverio", "CRO-234567"));
        dentistaService.criarDentista(new Dentista("Joao", "Souza", "CRO-345678"));
        dentistaService.criarDentista(new Dentista("Daniel", "Martins", "CRO-456789"));
        dentistaService.criarDentista(new Dentista("Lucas", "Ferreira", "CRO-567890"));
        dentistaService.criarDentista(new Dentista("Matheus", "Barreto", "CRO-678901"));
        List<Dentista>  listaDentista = dentistaService.buscarTodos();
        Assertions.assertEquals(9, listaDentista.size());
    }

    @Test
    public void deletarDentistaByIdTest() {
        dentistaService.deletarDentistaById(dentista.getIdDentista());
        Assertions.assertFalse(dentistaService.existeDentistaById(dentista.getIdDentista()));
    }
}
