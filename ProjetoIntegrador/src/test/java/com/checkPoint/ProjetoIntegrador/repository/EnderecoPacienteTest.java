package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EnderecoPacienteTest {

    @Autowired
    private IEnderecoPacienteRepository enderecoPacienteRepository;

    private EnderecoPaciente enderecoPaciente;
    private EnderecoPaciente enderecoPacienteSalvo;

    @Test
    public void criaEnderecoPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Barão de Iguape", 985, "01507000", "São Paulo", "São Paulo");
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.save(this.enderecoPaciente);
        Assertions.assertNotNull(this.enderecoPacienteSalvo.getIdEndereco());
        /*Assertions.assertEquals(1,this.enderecoPacienteSalvo.getIdEndereco());*/
        Assertions.assertEquals(this.enderecoPaciente.getRua(), this.enderecoPacienteSalvo.getRua());
        Assertions.assertEquals(this.enderecoPaciente.getNumero(), this.enderecoPacienteSalvo.getNumero());
        Assertions.assertEquals(this.enderecoPaciente.getCep(), this.enderecoPacienteSalvo.getCep());
        Assertions.assertEquals(this.enderecoPaciente.getCidade(), this.enderecoPacienteSalvo.getCidade());
        Assertions.assertEquals(this.enderecoPaciente.getEstado(), this.enderecoPacienteSalvo.getEstado());
    }

    @Test
    public void buscaUmEnderecoPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Barão de Iguape", 985, "01507000", "São Paulo", "São Paulo");
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.save(this.enderecoPaciente);
        Assertions.assertTrue(this.enderecoPacienteRepository.findById(this.enderecoPacienteSalvo.getIdEndereco()).isPresent());
    }

    @Test
    public void atualizaUmEnderecoPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Barão de Iguape", 985, "01507000", "São Paulo", "São Paulo");
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.save(this.enderecoPaciente);
        this.enderecoPacienteSalvo.setRua("Lavapés");
        this.enderecoPacienteSalvo.setCep("01519000");
        this.enderecoPacienteRepository.save(this.enderecoPacienteSalvo);
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.findById(this.enderecoPacienteSalvo.getIdEndereco()).get();
        Assertions.assertEquals("Lavapés", this.enderecoPacienteSalvo.getRua());
        Assertions.assertEquals("01519000", this.enderecoPacienteSalvo.getCep());
    }

    @Test
    public void deletaUmEnderecoPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Barão de Iguape", 985, "01507000", "São Paulo", "São Paulo");
        this.enderecoPacienteSalvo = this.enderecoPacienteRepository.save(this.enderecoPaciente);
        this.enderecoPacienteRepository.deleteById(this.enderecoPacienteSalvo.getIdEndereco());
        Assertions.assertFalse(this.enderecoPacienteRepository.findById(this.enderecoPacienteSalvo.getIdEndereco()).isPresent());
    }

}
