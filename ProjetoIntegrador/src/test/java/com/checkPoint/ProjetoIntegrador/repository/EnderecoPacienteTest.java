package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EnderecoPacienteTest {

    @Autowired
    private IEnderecoPacienteRepository enderecoPacienteRepository;

    EnderecoPaciente enderecoPaciente;
    EnderecoPaciente enderecoPacienteSalvo;

    @BeforeEach
    public void iniciaObjetoEnderecoPaciente(){
        this.enderecoPaciente = new EnderecoPaciente();
        this.enderecoPaciente.setRua("Barão de Iguape");
        this.enderecoPaciente.setNumero(985);
        this.enderecoPaciente.setCep("01507000");
        this.enderecoPaciente.setCidade("São Paulo");
        this.enderecoPaciente.setEstado("São Paulo");
        this.enderecoPacienteSalvo = new EnderecoPaciente();
    }

    @Test
    public void criaEnderecoPaciente(){
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.save(this.enderecoPaciente);
        Assertions.assertEquals(this.enderecoPaciente.getRua(), this.enderecoPacienteSalvo.getRua());
        Assertions.assertEquals(this.enderecoPaciente.getNumero(), this.enderecoPacienteSalvo.getNumero());
        Assertions.assertEquals(this.enderecoPaciente.getCep(), this.enderecoPacienteSalvo.getCep());
        Assertions.assertEquals(this.enderecoPaciente.getCidade(), this.enderecoPacienteSalvo.getCidade());
        Assertions.assertEquals(this.enderecoPaciente.getEstado(), this.enderecoPacienteSalvo.getEstado());

    }

}
