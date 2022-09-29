package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.domain.service.PacienteService;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.PacienteDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;
    EnderecoPaciente  enderecoPaciente;
    Paciente paciente;

    @BeforeAll
    public void instanciaObjetosParaTests(){
        enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        paciente = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);
        paciente =  pacienteService.criarPaciente(paciente);
    }

    @Test
    public void createPatientServiceTest(){
        Assertions.assertEquals("Daniel", paciente.getNome());
        Assertions.assertEquals("Martins", paciente.getSobrenome());
    }

    @Test
    public void searchForPatientByIdTest(){
        Paciente pacienteBuscado = pacienteService.buscarPacienteById(paciente.getIdPaciente());
        Assertions.assertNotNull(pacienteBuscado);
        Assertions.assertEquals("Daniel", pacienteBuscado.getNome());
        Assertions.assertEquals("Martins", pacienteBuscado.getSobrenome());
    }

    @Test
    public void listAllTestPatientsTest(){
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

        Assertions.assertEquals(5, pacienteService.listarTodosPacientes().size());
    }

    @Test
    public void deletePatientByIdTest(){
        pacienteService.criarPaciente(paciente);
        pacienteService.deletarPacienteById(paciente.getIdPaciente());
        Assertions.assertFalse(pacienteService.existePacienteById(paciente.getIdPaciente()));
    }

}
