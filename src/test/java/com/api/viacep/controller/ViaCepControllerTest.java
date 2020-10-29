package com.api.viacep.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class ViaCepControllerTest {

	@Autowired
	private ViaCepController viaCepController;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.viaCepController);
	}
	
	@Test
	public void deveRetornarSucesso() {
		when(this.viaCepController.getCep("35590000"));
	}
}
