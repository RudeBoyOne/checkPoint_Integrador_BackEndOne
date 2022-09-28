package com.checkPoint.ProjetoIntegrador.repository;


import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.repository.IDentistaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DentistaRepositoryTest {

    @Autowired
    private IDentistaRepository dentistaRepository;
    private Dentista dentista;
    private Dentista dentistaSalvo;

    @BeforeEach
    public void instaciaObjetosParaTestes(){
        this.dentista = new Dentista("Ewerton", "Lopes", "CRO-125987");
    }

    @Test
    public void criarDentistaTest() {
        dentistaSalvo = dentistaRepository.save(dentista);
        Assertions.assertNotNull(this.dentistaSalvo.getIdDentista());
        Assertions.assertEquals(this.dentista.getNome(), this.dentistaSalvo.getNome());
        Assertions.assertEquals(this.dentista.getSobrenome(), this.dentistaSalvo.getSobrenome());
        Assertions.assertEquals(this.dentista.getMatriculaCadastro(), this.dentistaSalvo.getMatriculaCadastro());
    }

    @Test
    public void buscarDentistaTest() {
        dentistaSalvo = dentistaRepository.save(dentista);
        Assertions.assertTrue(this.dentistaRepository.findById(this.dentistaSalvo.getIdDentista()).isPresent());
    }

    @Test
    public void buscaDentistaByMatriculaCadastroTest(){
        dentistaSalvo = dentistaRepository.save(dentista);
        Assertions.assertTrue(this.dentistaRepository.findByMatriculaCadastro(dentistaSalvo.getMatriculaCadastro()).isPresent());
    }

    @Test
    public void atualizarDentistaTest() {
        dentistaSalvo = dentistaRepository.save(dentista);
        this.dentistaSalvo.setNome("David");
        this.dentistaSalvo.setSobrenome("Coverdale");
        this.dentistaSalvo.setMatriculaCadastro("CRO-123789");
        this.dentistaRepository.save(this.dentistaSalvo);
        this.dentistaSalvo = this.dentistaRepository.findById(this.dentistaSalvo.getIdDentista()).get();
        Assertions.assertEquals("David", this.dentistaSalvo.getNome());
        Assertions.assertEquals("Coverdale", this.dentistaSalvo.getSobrenome());
        Assertions.assertEquals("CRO-123789", this.dentistaSalvo.getMatriculaCadastro());
    }

    @Test
    public void deletarDentistaTest() {
        dentistaSalvo = dentistaRepository.save(dentista);
        this.dentistaRepository.deleteById(this.dentistaSalvo.getIdDentista());
        Assertions.assertFalse(this.dentistaRepository.findById(this.dentistaSalvo.getIdDentista()).isPresent());
    }
}
