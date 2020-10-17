package com.api.viacep.dto;

import com.api.viacep.model.Cep;


public class CepResponseDTO {

	private long cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    
    public CepResponseDTO() {
    }

    public CepResponseDTO(Cep cep){
        this.cep = cep.getCep();
        this.localidade = cep.getLocalidade();
        this.complemento = cep.getComplemento();
        this.bairro = cep.getBairro();
        this.logradouro = cep.getLogradouro();
        this.uf = cep.getUf();
        this.unidade = cep.getUnidade();
    }
}
