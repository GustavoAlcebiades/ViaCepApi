package com.api.viacep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.viacep.dto.CepResponseDTO;
import com.api.viacep.repository.CepRepository;

@Service
public class CepService {

	@Autowired
	CepRepository cepRepository;

	public CepResponseDTO getCep(String cep) {

		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CepResponseDTO> cepResponseDTO = restTemplate.getForEntity(url, CepResponseDTO.class);
			return cepResponseDTO.getBody();

		} catch (HttpClientErrorException httpClientErrorException) {
			return null;

		}
	}

	public ResponseEntity<CepResponseDTO> saveCepp(@RequestBody CepResponseDTO cepResponseDTO) {

		if(cepResponseDTO.getCep() == "" || cepResponseDTO.getCep() == null) {
			return new ResponseEntity<CepResponseDTO>(HttpStatus.BAD_REQUEST);
		}else {
			cepRepository.save(cepResponseDTO);
			return new ResponseEntity<CepResponseDTO>(cepResponseDTO, HttpStatus.CREATED);
		}
		
		
	}
}
