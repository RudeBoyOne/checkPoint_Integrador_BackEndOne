package com.checkPoint.ProjetoIntegrador.service;


import com.checkPoint.ProjetoIntegrador.Exception.ExceptionClinicaOdontologica;
import com.checkPoint.ProjetoIntegrador.dto.DentistaDTO;
import com.checkPoint.ProjetoIntegrador.model.Dentista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DentistaServiceTest {

    @Autowired
    DentistaService dentistaService;



    @Test
    public void criarDentistaServiceTest() {
        Dentista dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
        dentistaService.criarDentista(dentista);
        Assertions.assertEquals("Ewerton", dentistaService.criarDentista(dentista).getNome());
        Assertions.assertEquals("Lopes", dentistaService.criarDentista(dentista).getSobrenome());
        Assertions.assertEquals("CRO-125987", dentistaService.criarDentista(dentista).getMatriculaCadastro());
    }

    @Test
    public void buscarDentistaById() {
        Dentista dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
        dentistaService.criarDentista(dentista);
        DentistaDTO dentistaDTO = dentistaService.buscarDentistaById(1);
        Assertions.assertNotNull(dentistaDTO);
    }

    @Test
    public void buscarTodos() {
        dentistaService.criarDentista(new Dentista("Ewerton", "Lopes", "CRO-125987"));
        dentistaService.criarDentista(new Dentista("Lucas", "Adrian", "CRO-127963"));
        dentistaService.criarDentista(new Dentista("Everton", "Silverio", "CRO-129854"));
        dentistaService.criarDentista(new Dentista("Joao", "Souza", "CRO-123456"));
        dentistaService.criarDentista(new Dentista("Daniel", "Martins", "CRO-129854"));
        dentistaService.criarDentista(new Dentista("Lucas", "Ferreira", "CRO-122547"));
        dentistaService.criarDentista(new Dentista("Matheus", "Barreto", "CRO-125698"));
        List<Dentista>  listaDentista = dentistaService.buscarTodos();
        Assertions.assertEquals(7, listaDentista.size());
    }

    @Test
    public void deletarDentistaById() {
        Dentista dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
        dentistaService.criarDentista(dentista);
        Assertions.assertEquals( "Dentista excluído.", dentistaService.deletarDentistaById(dentista.getIdDentista()));;

    }
}
