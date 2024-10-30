package com.appRH.appRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appRH.appRH.models.Funcionario;


public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
	
	Funcionario findById(long id);
	
	
	//Busca
	Funcionario findByNome(String nome);

}
