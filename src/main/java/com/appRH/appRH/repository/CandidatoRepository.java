package com.appRH.appRH.repository;

import java.util.List;

//import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.appRH.appRH.models.Candidato;
import com.appRH.appRH.models.Vaga;

public interface CandidatoRepository extends CrudRepository<Candidato, String> {

	Iterable<Candidato>findByVaga(Vaga vaga);
	
	Candidato findByRg(String rg);
	
	Candidato findById(long id);
	
	List<Candidato>findByNomeCandidato(String nomeCandidato);

	
	
}
