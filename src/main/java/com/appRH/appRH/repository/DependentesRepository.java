package com.appRH.appRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appRH.appRH.models.Dependentes;
import com.appRH.appRH.models.Funcionario;
public interface DependentesRepository extends CrudRepository<Dependentes, String>{
	
	//Procura pelo funcionario
	Iterable<Dependentes> findByFuncionario(Funcionario funcionario);
	
	//Procura pelo CPF, será associado ao método delete
	Dependentes findByCpf(String cpf);
	Dependentes findById(long id);
	
	//Criado para implementar
	List<Dependentes> findByNome(String nome);
	
	

}
