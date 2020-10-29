package com.api.viacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.viacep.dto.CepResponseDTO;
import com.api.viacep.service.CepService;

@RestController
@RequestMapping("/api/cep")
public class ViaCepController {

	@Autowired
	private CepService cepService;

	@GetMapping("{cep}")
	public ResponseEntity<CepResponseDTO> getCep(@PathVariable(value = "cep") String cep) {

		return ResponseEntity.ok(cepService.getCep(cep));
				 
	}
	
	@PostMapping()
	public ResponseEntity<CepResponseDTO> saveCep(@RequestBody CepResponseDTO cepResponseDTO){
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
