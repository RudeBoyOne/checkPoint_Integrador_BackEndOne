package com.checkPoint.ProjetoIntegrador.testsDeIntegracao;

import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.EnderecoPacienteDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PacienteIntegracao {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void aCriarUmPacienteTest() throws Exception {
        EnderecoPacienteDTOInput enderecoPacienteDTOInput = new EnderecoPacienteDTOInput("Barão de Iguape",
                985, "01507001", "São Paulo", "São Paulo");
        PacienteDTOInput pacienteDTOInput = new PacienteDTOInput("Josisvaldo",
                "Arruda", "893457348", enderecoPacienteDTOInput);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(pacienteDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void bAtualizaUmPacienteTest() throws Exception {
        EnderecoPacienteDTOInput enderecoPacienteDTOInput = new EnderecoPacienteDTOInput("Barão de Iguape",
                985, "01507001", "São Paulo", "São Paulo");
        PacienteDTOInput pacienteDTOInput = new PacienteDTOInput("Mauricio",
                "Arruda", "893457348", enderecoPacienteDTOInput);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(pacienteDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.put("/pacientes/{idPaciente}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void cBuscarTodosPacientesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void dBuscarPacienteByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{idPaciente}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void eDeletarPacienteByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/{idPaciente}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void fCriaPacienteParaConsulta() throws Exception {
        this.aCriarUmPacienteTest();
    }
}
