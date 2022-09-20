package com.checkPoint.ProjetoIntegrador.service;


import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import com.checkPoint.ProjetoIntegrador.api.dtos.DentistaDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DentistaServiceTest {

    @Autowired
    DentistaService dentistaService;

    Dentista dentista;

    @BeforeEach
    public void instanciaObjetosParaTestes(){
        dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
    }

    @Test
    public void criarDentistaServiceTest() {
        dentistaService.criarDentista(dentista);
        Assertions.assertEquals("Ewerton", dentistaService.criarDentista(dentista).getNome());
        Assertions.assertEquals("Lopes", dentistaService.criarDentista(dentista).getSobrenome());
        Assertions.assertEquals("CRO-125987", dentistaService.criarDentista(dentista).getMatriculaCadastro());
    }

    @Test
    public void buscarDentistaById() {
        dentistaService.criarDentista(dentista);
        DentistaDTO dentistaDTO = dentistaService.buscarDentistaById(dentista.getIdDentista());
        Assertions.assertNotNull(dentistaDTO);
    }

    @Test
    public void buscarTodos() {
        dentistaService.criarDentista(new Dentista("Lucas", "Adrian", "CRO-127963"));
        dentistaService.criarDentista(new Dentista("Everton", "Silverio", "CRO-129854"));
        dentistaService.criarDentista(new Dentista("Joao", "Souza", "CRO-123456"));
        dentistaService.criarDentista(new Dentista("Daniel", "Martins", "CRO-129854"));
        dentistaService.criarDentista(new Dentista("Lucas", "Ferreira", "CRO-122547"));
        dentistaService.criarDentista(new Dentista("Matheus", "Barreto", "CRO-125698"));
        List<Dentista>  listaDentista = dentistaService.buscarTodos();
        Assertions.assertEquals(8, listaDentista.size());
    }

    @Test
    public void deletarDentistaById() {
        dentistaService.criarDentista(dentista);
        dentistaService.deletarDentistaById(dentista.getIdDentista());
        Assertions.assertFalse(dentistaService.existeDentistaById(dentista.getIdDentista()));
    }
}
