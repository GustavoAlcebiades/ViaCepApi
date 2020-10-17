package com.api.viacep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.viacep.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

	public Cep getByCep(Cep cep);
}
