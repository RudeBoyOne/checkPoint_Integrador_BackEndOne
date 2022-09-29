package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import com.checkPoint.ProjetoIntegrador.domain.service.ConsultaService;
import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsultaServiceTest {
    @Autowired
    ConsultaService consultaService;
    @Autowired
    DentistaService dentistaService;
    @Autowired
    PacienteService pacienteService;

    EnderecoPaciente enderecoPaciente;
    Dentista dentista;
    Paciente paciente;
    Consulta consulta;


    @BeforeAll
    public void criarObjetos(){
        enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        dentista = new Dentista("gabriel", "medeiros", "25263727");
        paciente = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        dentistaService.criarDentista(dentista);
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 4, 25,14,30));

    }

    @Test
    public void criarConsultaTest(){
        consulta = consultaService.criarConsulta(consulta);
        Assertions.assertEquals("Daniel",consulta.getPaciente().getNome());
        Assertions.assertEquals("gabriel",consulta.getDentista().getNome());
    }

    @Test
    public void buscarConsultaByIdTest(){
        consultaService.criarConsulta(consulta);
        consulta = consultaService.buscarCosultaById(consulta.getIdConsulta());
        Assertions.assertEquals("Daniel",consulta.getPaciente().getNome());
        Assertions.assertEquals("gabriel",consulta.getDentista().getNome());
    }

    @Test
    public void listarTodasConsultasTest(){
        dentista = new Dentista("Lucas", "Adrian", "CRO-782364");
        enderecoPaciente = new EnderecoPaciente("Av São Miguel", 1985,
                "63957259", "São Paulo", "São Paulo");
        paciente = new Paciente("Lucas", "Adrian", "6370753417", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        dentistaService.criarDentista(dentista);
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 4, 26,14,30));
        consultaService.criarConsulta(consulta);
        dentista = new Dentista("José", "Arruda", "CRO-023495");
        enderecoPaciente = new EnderecoPaciente("Av Celso Garcia", 3456,
                "63953459", "São Paulo", "São Paulo");
        paciente = new Paciente("André", "Souza", "9355870247", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        dentistaService.criarDentista(dentista);
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 4, 27,14,30));
        consultaService.criarConsulta(consulta);
        Assertions.assertEquals(3, consultaService.listarTodasConsultas().size());

    }

    @Test
    public void deletarConsultaByIdTest(){
        consultaService.criarConsulta(consulta);
        consultaService.deletarConsultaById(consulta.getIdConsulta());
        Assertions.assertFalse(consultaService.existeConsultaById(consulta.getIdConsulta()));
    }

}
