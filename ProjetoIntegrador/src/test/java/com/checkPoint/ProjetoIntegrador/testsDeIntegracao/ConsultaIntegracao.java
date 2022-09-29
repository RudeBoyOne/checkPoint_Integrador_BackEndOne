package com.checkPoint.ProjetoIntegrador.testsDeIntegracao;

import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.ConsultaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.EnderecoPacienteDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
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
@Suite.SuiteClasses({PacienteIntegracao.class, DentistaIntegracao.class})
public class ConsultaIntegracao {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void criarUmaConsultaTest() throws Exception {
        ConsultaDTOInput consultaDTOInput = new ConsultaDTOInput(2, 1, LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.findAndRegisterModules();

        consultaDTOInput = objectMapper.convertValue(consultaDTOInput, ConsultaDTOInput.class);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
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
    public void atualizaUmaConsultaTest() throws Exception {
        ConsultaDTOInput consultaDTOInput = new ConsultaDTOInput(2, 1, LocalDateTime.of(2022, 10, 28, 14, 30));

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.findAndRegisterModules();

        consultaDTOInput = objectMapper.convertValue(consultaDTOInput, ConsultaDTOInput.class);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
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
    public void buscarTodasConsultasTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dentistas")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void buscarConsultaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/consultas/{idConsulta}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deletarConsultaByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/consultas/{idConsulta}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
