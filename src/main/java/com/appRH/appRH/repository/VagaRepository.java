package com.appRH.appRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appRH.appRH.models.Funcionario;
import com.appRH.appRH.models.Vaga;


public interface VagaRepository extends CrudRepository<Vaga, Long>{

	/*Pesquisar a vaga através do codigo*/
	Vaga findByCodigo(long codigo);
	List<Vaga> findByNome(String nome);
	
	//Para a busca
	@Query(value = "select u from Vaga u where u.nome like %?1%")
	List<Vaga>findByNomesVaga(String nome);
	
	
	
}
