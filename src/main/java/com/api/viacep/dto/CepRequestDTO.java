	package com.api.viacep.dto;

	import javax.persistence.Entity;

	import com.api.viacep.model.Cep;

	@Entity
	public class CepRequestDTO {

		    private long cep;
		    private String logradouro;
		    private String complemento;
		    private String bairro;
		    private String localidade;
		    private String uf;
		    private String unidade;
		    private String ibge;
		    
		    public CepRequestDTO() {
		    }
		    
		    public Cep build(){
		        Cep cep = new Cep()
		                .setCep(this.cep)
		                .setLocalidade(this.localidade)
		                .setLogradouro(this.logradouro)
		                .setComplemento(this.complemento)
		                .setBairro(this.bairro)
		                .setUf(this.uf)
		                .setIbge(this.ibge)
		                .setUnidade(this.unidade);
		        return cep;
		    }
		    
		    
		  
	}

}
