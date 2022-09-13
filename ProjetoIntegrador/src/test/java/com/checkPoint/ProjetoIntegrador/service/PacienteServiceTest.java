package com.checkPoint.ProjetoIntegrador.service;

import com.checkPoint.ProjetoIntegrador.dto.PacienteDTO;
import com.checkPoint.ProjetoIntegrador.model.EnderecoPaciente;
import com.checkPoint.ProjetoIntegrador.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    @Test
    public void criarPacienteServiceTest(){
        EnderecoPaciente  enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        Paciente paciente = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);;
        Assertions.assertEquals("Daniel", pacienteService.criarPaciente(paciente).getNome());
        Assertions.assertEquals("Martins", pacienteService.criarPaciente(paciente).getSobrenome());
    }

    @Test
    public void buscarPacienteById(){
        EnderecoPaciente  enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        Paciente pacienteModel = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);
        pacienteService.criarPaciente(pacienteModel);
        PacienteDTO pacienteDTO = pacienteService.buscarPacienteById(1);
        Assertions.assertNotNull(pacienteDTO);
    }

    @Test
    public void deletarPacienteById(){
        EnderecoPaciente  enderecoPaciente = new EnderecoPaciente("Benjamin Constant", 243,
                "11040140", "Santos", "São Paulo");
        Paciente pacienteModel = new Paciente("Daniel", "Martins", "44444444", enderecoPaciente);
        pacienteService.criarPaciente(pacienteModel);
        pacienteService.deletarPacienteById(pacienteModel.getIdPaciente());
        pacienteService.buscarPacienteById(pacienteModel.getIdPaciente());
    }

}
