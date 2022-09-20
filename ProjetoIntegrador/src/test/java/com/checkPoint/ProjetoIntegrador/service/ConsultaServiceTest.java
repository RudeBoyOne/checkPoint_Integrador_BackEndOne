package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.domain.service.ConsultaService;
import com.checkPoint.ProjetoIntegrador.domain.service.DentistaService;
import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import com.checkPoint.ProjetoIntegrador.api.dtos.ConsultaDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
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
    ConsultaDTO consultaSalvo;


    @BeforeEach
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
        consultaSalvo = consultaService.criarConsulta(consulta);
        Assertions.assertEquals("Daniel Martins",consultaSalvo.getNomeCompletoPaciente());
        Assertions.assertEquals("gabriel medeiros",consultaSalvo.getNomeCompletoDentista());
    }

    @Test
    public void buscarConsultaByIdTest(){
        consultaService.criarConsulta(consulta);
        consultaSalvo = consultaService.buscarCosultaById(consulta.getIdConsulta());
        Assertions.assertEquals("Daniel Martins",consultaSalvo.getNomeCompletoPaciente());
        Assertions.assertEquals("gabriel medeiros",consultaSalvo.getNomeCompletoDentista());
    }

    @Test
    public void listarTodasConsultasTest(){
        dentista = new Dentista("Lucas", "Adrian", "CRO-127963");
        enderecoPaciente = new EnderecoPaciente("Av São Miguel", 1985,
                "63957259", "São Paulo", "São Paulo");
        paciente = new Paciente("Lucas", "Adrian", "7364859362", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        dentistaService.criarDentista(dentista);
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 4, 25,14,30));
        consultaService.criarConsulta(consulta);
        dentista = new Dentista("José", "Arruda", "CRO-127963");
        enderecoPaciente = new EnderecoPaciente("Av Celso Garcia", 3456,
                "63953459", "São Paulo", "São Paulo");
        paciente = new Paciente("André", "Souza", "7290484673", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        dentistaService.criarDentista(dentista);
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 4, 25,14,30));
        consultaService.criarConsulta(consulta);
        Assertions.assertEquals(4, consultaService.listarTodasConsultas().size());

    }

    @Test
    public void deletarConsultaByIdTest(){
        consultaService.criarConsulta(consulta);
        consultaService.deletarConsultaById(consulta.getIdConsulta());
        Assertions.assertFalse(consultaService.existeConsultaById(consulta.getIdConsulta()));
    }

}
