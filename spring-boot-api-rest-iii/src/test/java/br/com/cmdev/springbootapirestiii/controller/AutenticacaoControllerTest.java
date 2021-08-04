package br.com.cmdev.springbootapirestiii.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws Exception {
		URI uri = new  URI("/auth");
		String json = "{\"email\":\"ivalido@email.com\",\"senha\":\"123\"}\"";
		mockMvc
			.perform(MockMvcRequestBuilders
			.post(uri)
			.content(json)
			.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(HttpStatus.BAD_REQUEST.value()));
	}
	
	@Test
	public void deveriaDevolver200CasoDadosDeAutenticacaoEstejamCorretos() throws Exception {
		URI uri = new  URI("/auth");
		String json = "{\"email\":\"moderador@email.com\",\"senha\":\"123456\"}\"";
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(HttpStatus.OK.value()));
	}

}
