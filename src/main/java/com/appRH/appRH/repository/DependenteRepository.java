package com.appRH.appRH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appRH.appRH.models.Dependente;
import com.appRH.appRH.models.Funcionario;
public interface DependenteRepository extends CrudRepository<Dependente, String>{
	
	//Procura pelo funcionario
	Iterable<Dependente> findByFuncionario(Funcionario funcionario);
	
	//Procura pelo CPF, será associado ao método delete
	Dependente findByCpf(String cpf);
	Dependente findById(long id);
	
	//Criado para implementar
	List<Dependente> findByNome(String nome);
	
	//Para a busca
	@Query(value = "select u from Dependente u where u.nome like %?1%")
	List<Dependente>findByNomesDependentes(String nome);

}
