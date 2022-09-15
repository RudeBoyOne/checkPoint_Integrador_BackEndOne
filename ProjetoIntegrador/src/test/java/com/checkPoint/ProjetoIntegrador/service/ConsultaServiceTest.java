package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.dto.ConsultaDTO;
import com.checkPoint.ProjetoIntegrador.model.Consulta;
import com.checkPoint.ProjetoIntegrador.model.Dentista;
import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.model.Paciente;
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
        consulta = new Consulta(paciente, dentista, LocalDateTime.of(2018, 04, 25,14,30));

    }

    @Test
    public void criarConsultatest(){
        consultaSalvo = consultaService.criarConsulta(consulta);
        Assertions.assertEquals("Daniel Martins",consultaSalvo.getNomeCompletoPaciente());
        Assertions.assertEquals("gabriel medeiros",consultaSalvo.getNomeCompletoDentista());
    }

    @Test
    public void buscarConsultaById(){
        consultaService.criarConsulta(consulta);
        consultaSalvo = consultaService.buscarCosultaById(1);
        Assertions.assertEquals("Daniel Martins",consultaSalvo.getNomeCompletoPaciente());
        Assertions.assertEquals("gabriel medeiros",consultaSalvo.getNomeCompletoDentista());
    }

}
