package com.checkPoint.ProjetoIntegrador.repository;

import com.checkPoint.ProjetoIntegrador.model.Consulta;
import com.checkPoint.ProjetoIntegrador.model.Dentista;
import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@DataJpaTest
public class ConsultaTest {
    @Autowired
    private IConsultaRepository iConsultaRepository;
    private Consulta consulta;
    private Consulta consultaSalvo;

    @Test
    public void criarConsulta(){
        EnderecoPaciente enderecoPaciente = new EnderecoPaciente("Rua embaixador valadares", 3456, "23456-211", "Rio de Janeiro", "Rio de janeiro");
        Paciente paciente1 = new Paciente("João", "Sousa","255635271", enderecoPaciente);
        Dentista dentista = new Dentista ("Ewerton", "Lopes", "CRO-125987");
        this.consulta = new Consulta(paciente1, dentista, LocalDateTime.of(2020, 06,23,14,30));
        consultaSalvo = iConsultaRepository.save(consulta);

        Assertions.assertNotNull(this.consultaSalvo.getIdConsulta());
        Assertions.assertEquals(this.consulta.getDentista().getNome(), this.consultaSalvo.getDentista().getNome());
        Assertions.assertEquals(this.consulta.getDentista().getMatriculaCadastro(), this.consultaSalvo.getDentista().getMatriculaCadastro());
        Assertions.assertEquals(this.consulta.getDentista().getSobrenome(), this.consultaSalvo.getDentista().getSobrenome());

        Assertions.assertEquals(this.consulta.getPaciente().getNome(), this.consultaSalvo.getPaciente().getNome());
        Assertions.assertEquals(this.consulta.getPaciente().getSobrenome(), this.consultaSalvo.getPaciente().getSobrenome());
        Assertions.assertEquals(this.consulta.getPaciente().getRg(), this.consultaSalvo.getPaciente().getRg());
        Assertions.assertEquals(this.consulta.getPaciente().getDataAlta(), this.consultaSalvo.getPaciente().getDataAlta());
        Assertions.assertEquals(this.consulta.getPaciente().getEnderecoPaciente(), this.consultaSalvo.getPaciente().getEnderecoPaciente());


    }
    @Test
    public void buscarConsulta(){
        EnderecoPaciente enderecoPaciente = new EnderecoPaciente("Rua embaixador valadares", 3456, "23456-211", "Rio de Janeiro", "Rio de janeiro");
        Paciente paciente1 = new Paciente("João", "Sousa","255635271", enderecoPaciente);
        Dentista dentista = new Dentista ("Ewerton", "Lopes", "CRO-125987");
        this.consulta = new Consulta(paciente1, dentista, LocalDateTime.of(2020, 06,23,14,30));

        consultaSalvo = iConsultaRepository.save(consulta);

        Assertions.assertTrue(this.iConsultaRepository.findById(this.consultaSalvo.getIdConsulta()).isPresent());
    }

    @Test
    public void atualizarConsulta(){
        EnderecoPaciente enderecoPaciente = new EnderecoPaciente("Rua embaixador valadares", 3456, "23456-211", "Rio de Janeiro", "Rio de janeiro");
        Paciente paciente1 = new Paciente("João", "Sousa","255635271", enderecoPaciente);
        Dentista dentista = new Dentista ("Ewerton", "Lopes", "CRO-125987");
        this.consulta = new Consulta(paciente1, dentista, LocalDateTime.of(2020, 06,23,14,30));

        consultaSalvo = iConsultaRepository.save(consulta);
        this.consultaSalvo.setDataHoraConsulta(LocalDateTime.of(2020,03,24, 14, 35));
        this.consultaSalvo = this.iConsultaRepository.save(consultaSalvo);
        Assertions.assertEquals(LocalDateTime.of(2020,03,24, 14, 35), this.consultaSalvo.getDataHoraConsulta());
    }

    @Test
    public void deletarConsulta(){
        EnderecoPaciente enderecoPaciente = new EnderecoPaciente("Rua embaixador valadares", 3456, "23456-211", "Rio de Janeiro", "Rio de janeiro");
        Paciente paciente1 = new Paciente("João", "Sousa","255635271", enderecoPaciente);
        Dentista dentista = new Dentista ("Ewerton", "Lopes", "CRO-125987");
        this.consulta = new Consulta(paciente1, dentista, LocalDateTime.of(2020, 06,23,14,30));
        consultaSalvo = iConsultaRepository.save(consulta);

        this.iConsultaRepository.deleteById(this.consultaSalvo.getIdConsulta());
        Assertions.assertFalse(this.iConsultaRepository.findById(this.consulta.getIdConsulta()).isPresent());
    }
}
