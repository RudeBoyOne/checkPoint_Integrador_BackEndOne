package com.checkPoint.ProjetoIntegrador.testsDeIntegracao;

import com.checkPoint.ProjetoIntegrador.api.assembler.ConsultaAssembler;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.ConsultaDTOInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultaIntegracao {

    //Para executar este teste corretamente por favor executar a classe SuiteDeTestes
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ConsultaAssembler consultaAssembler;

    @Test
    public void aCriarUmaConsultaTest() throws Exception {
        ConsultaDTOInput consultaDTOInput = new ConsultaDTOInput(2, 2, LocalDateTime.now());

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .writer();

        String payloadJson = writer.writeValueAsString(consultaDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void bAtualizaUmaConsultaTest() throws Exception {
        ConsultaDTOInput consultaDTOInput = new ConsultaDTOInput(2, 2, LocalDateTime.of(2022, 10, 28, 14, 30));

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .writer();

        String payloadJson = writer.writeValueAsString(consultaDTOInput);

        mockMvc.perform(MockMvcRequestBuilders.put("/consultas/{idConsulta}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void cBuscarTodasConsultasTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dentistas")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void dBuscarConsultaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consultas/{idConsulta}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void eDeletarConsultaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/consultas/{idConsulta}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
