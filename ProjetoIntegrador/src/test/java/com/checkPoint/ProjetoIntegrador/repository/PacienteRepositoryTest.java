package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.dataloader.repository.IEnderecoPacienteRepository;
import com.checkPoint.ProjetoIntegrador.domain.dataloader.repository.IPacienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PacienteRepositoryTest {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private IEnderecoPacienteRepository iEnderecoPacienteRepository;
    private Paciente paciente;
    private Paciente pacienteSalvo;
    private EnderecoPaciente enderecoPaciente;
    private EnderecoPaciente enderecoPacienteSalvo;

    @Test
    public void criarPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243, "11040140", "Santos", "São Paulo");
        enderecoPacienteSalvo = this.iEnderecoPacienteRepository.save(enderecoPaciente);
        this.paciente = new Paciente("Daniel", "Martins", "44444444", iEnderecoPacienteRepository.findById(enderecoPacienteSalvo.getIdEndereco()).get());
        pacienteSalvo = pacienteRepository.save(paciente);
        Assertions.assertNotNull(this.pacienteSalvo.getIdPaciente());
        Assertions.assertEquals(this.paciente.getNome(),this.pacienteSalvo.getNome());
        Assertions.assertEquals(this.paciente.getSobrenome(), this.pacienteSalvo.getSobrenome());
        Assertions.assertEquals(this.paciente.getRg(), this.pacienteSalvo.getRg());
        Assertions.assertEquals(this.paciente.getDataAlta(), this.pacienteSalvo.getDataAlta());
        Assertions.assertEquals(this.paciente.getEnderecoPaciente(), this.pacienteSalvo.getEnderecoPaciente());
    }

    @Test
    public void buscaPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243, "11040140", "Santos", "São Paulo");
        enderecoPacienteSalvo = this.iEnderecoPacienteRepository.save(enderecoPaciente);
        this.paciente = new Paciente("Daniel", "Martins", "44444444", iEnderecoPacienteRepository.findById(enderecoPacienteSalvo.getIdEndereco()).get());
        pacienteSalvo = pacienteRepository.save(paciente);
        Assertions.assertTrue(this.pacienteRepository.findById(this.pacienteSalvo.getIdPaciente()).isPresent());
    }

    @Test
    public void atualizaPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243, "11040140", "Santos", "São Paulo");
        enderecoPacienteSalvo = this.iEnderecoPacienteRepository.save(enderecoPaciente);
        this.paciente = new Paciente("Daniel", "Martins", "44444444", iEnderecoPacienteRepository.findById(enderecoPacienteSalvo.getIdEndereco()).get());
        pacienteSalvo = pacienteRepository.save(paciente);
        this.pacienteSalvo.setNome("Lucas");
        this.pacienteSalvo.setRg("55555555");
        this.pacienteRepository.save(this.pacienteSalvo);
        this.pacienteSalvo = this.pacienteRepository.findById(this.pacienteSalvo.getIdPaciente()).get();
        Assertions.assertEquals("Lucas", this.pacienteSalvo.getNome());
        Assertions.assertEquals("55555555", this.pacienteSalvo.getRg());
    }

    @Test
    public void deletaPaciente(){
        this.enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243, "11040140", "Santos", "São Paulo");
        enderecoPacienteSalvo = this.iEnderecoPacienteRepository.save(enderecoPaciente);
        this.paciente = new Paciente("Daniel", "Martins", "44444444", iEnderecoPacienteRepository.findById(enderecoPacienteSalvo.getIdEndereco()).get());
        pacienteSalvo = pacienteRepository.save(paciente);
        this.pacienteRepository.deleteById(this.pacienteSalvo.getIdPaciente());
        Assertions.assertFalse(this.pacienteRepository.findById(this.pacienteSalvo.getIdPaciente()).isPresent());
    }
}
