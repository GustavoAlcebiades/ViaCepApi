package com.api.viacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.viacep.model.Cep;
import com.api.viacep.repository.CepRepository;
import com.api.viacep.service.CepService;

@RestController
@RequestMapping("/api/cep")
public class ViaCepController {

	@Autowired
	private CepRepository cepRepository;
	
	@Autowired	
	private CepService cepService;
	
	@GetMapping("{cep}")
	public ResponseEntity<Object> getCep(@PathVariable(value = "cep") Cep cep){
		
		return cepService.getCep(cep);
	}
	
}
