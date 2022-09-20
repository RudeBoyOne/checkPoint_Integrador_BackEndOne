package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import com.checkPoint.ProjetoIntegrador.api.dtos.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;
    EnderecoPaciente  enderecoPaciente;
    Paciente paciente;
    PacienteDTO pacienteDTO;

    @BeforeEach
    public void instanciaObjetosParaTestes(){
        enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        paciente = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);
    }

    @Test
    public void criarPacienteServiceTest(){
        pacienteDTO =  pacienteService.criarPaciente(paciente);
        Assertions.assertEquals("Daniel", pacienteDTO.getNome());
        Assertions.assertEquals("Martins", pacienteDTO.getSobrenome());
    }

    @Test
    public void buscarPacienteByIdTest(){
        pacienteService.criarPaciente(paciente);
        pacienteDTO = pacienteService.buscarPacienteById(paciente.getIdPaciente());
        Assertions.assertNotNull(pacienteDTO);
        Assertions.assertEquals("Daniel", pacienteDTO.getNome());
        Assertions.assertEquals("Martins", pacienteDTO.getSobrenome());
    }

    @Test
    public void listarTodosPacientesTest(){
        pacienteService.criarPaciente(paciente);
        enderecoPaciente = new EnderecoPaciente("Av São Miguel", 1985,
                "63957259", "São Paulo", "São Paulo");
        paciente = new Paciente("Lucas", "Adrian", "7364859362", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        enderecoPaciente = new EnderecoPaciente("Barão de Iguape", 985,
                "39364785", "São Paulo", "São Paulo");
        paciente = new Paciente("Joelson", "Arruda", "9473905738", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        enderecoPaciente = new EnderecoPaciente("Lavapés", 245,
                "94639572", "Santos", "São Paulo");
        paciente = new Paciente("Milena", "Souza", "9473628946", enderecoPaciente);
        pacienteService.criarPaciente(paciente);
        enderecoPaciente = new EnderecoPaciente("Arraial de Santa", 756,
                "74950735", "São Paulo", "São Paulo");
        paciente = new Paciente("Maria", "José", "2937572173", enderecoPaciente);
        pacienteService.criarPaciente(paciente);

        Assertions.assertEquals(6, pacienteService.listarTodosPacientes().size());
    }

    @Test
    public void deletarPacienteByIdTest(){
        pacienteService.criarPaciente(paciente);
        pacienteService.deletarPacienteById(paciente.getIdPaciente());
        Assertions.assertFalse(pacienteService.existePacienteById(paciente.getIdPaciente()));
    }

}
