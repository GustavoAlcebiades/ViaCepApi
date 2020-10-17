package com.api.viacep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.viacep.dto.CepResponseDTO;
import com.api.viacep.model.Cep;
import com.api.viacep.repository.CepRepository;

@Service
public class CepService {

	@Autowired
	CepRepository cepRepository;
	
	
	public ResponseEntity<Object> getCep(@PathVariable Cep cep){
		Cep cepObject = cepRepository.getByCep(cep);
		
        if(cepObject != null) {
            return new ResponseEntity<>(new CepResponseDTO(cepObject), HttpStatus.OK);
        }else{
            String url = "https://viacep.com.br/ws/"+ cep +"/json/";
            RestTemplate restTemplate = new RestTemplate();
            try {
                Cep cepResponse = restTemplate.getForObject(url, Cep.class);
                this.cepRepository.save(cepResponse);
                return new ResponseEntity<>(new CepResponseDTO(cepResponse), HttpStatus.OK);
            }catch (HttpClientErrorException httpClientErrorException) {
                return new ResponseEntity<>((httpClientErrorException.getMessage()),
                        httpClientErrorException.getStatusCode());
            }
        }
	}
}
