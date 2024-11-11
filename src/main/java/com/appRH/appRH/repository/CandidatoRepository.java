package com.appRH.appRH.repository;

import java.util.List;

//import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.appRH.appRH.models.Candidato;
import com.appRH.appRH.models.Funcionario;
import com.appRH.appRH.models.Vaga;

//esse crud repository se trata da classe candidato referenciado a chave primaria do tipo long
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {

	Iterable<Candidato>findByVaga(Vaga vaga);
	
	Candidato findByRg(String rg);
	
	Candidato findById(long id);
	
	//List<Candidato>findByNomeCandidato(String nomeCandidato);

	//Para a busca
	@Query(value = "select u from Candidato u where u.nomeCandidato like %?1%")
	List<Candidato>findByNomesCandidatos(String nomeCandidato);
	
}
