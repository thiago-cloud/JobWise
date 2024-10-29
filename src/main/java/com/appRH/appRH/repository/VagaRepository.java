package com.appRH.appRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.appRH.appRH.models.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, String>{

	/*Pesquisar a vaga através do codigo*/
	Vaga findByCodigo(long codigo);
	List<Vaga> findByNome(String nome);
}
