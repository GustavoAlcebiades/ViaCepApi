package com.api.viacep.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.viacep.dto.CepResponseDTO;

@Service
public class CepService {

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
}
