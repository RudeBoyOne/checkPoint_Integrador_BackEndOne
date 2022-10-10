package com.checkPoint.ProjetoIntegrador.testsDeIntegracao;


import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
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
public class DentistaIntegracao {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void aCriarUmDentistaTest() throws Exception {
        DentistaDTOInput dentistaDTOInput = new DentistaDTOInput("Lucas", "Ferreira", "JGH-29384");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(dentistaDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.post("/dentistas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void bAtualizaUmDentistaTest() throws Exception {
        DentistaDTOInput dentistaDTOInput = new DentistaDTOInput("Marcelo", "de Nobrega", "JGH-29384");


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(dentistaDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.put("/dentistas/{idDentista}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void cBuscarTodosPacientesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dentistas")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void dBuscarDentistaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dentistas/{idDentista}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void eDeletarDentistaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/dentistas/{idDentista}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void fCriaDentistaParaConsulta() throws Exception{
        this.aCriarUmDentistaTest();
    }
}
