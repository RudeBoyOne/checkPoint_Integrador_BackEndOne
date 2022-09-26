package com.checkPoint.ProjetoIntegrador;

import com.checkPoint.ProjetoIntegrador.api.controller.PacienteController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PacienteController.class)
@RunWith(SpringRunner.class)
class ProjetoIntegradorApplicationTests {

	@Autowired
	private PacienteController pacienteController;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void buscarTodosPacientesApi() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pacientes")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
