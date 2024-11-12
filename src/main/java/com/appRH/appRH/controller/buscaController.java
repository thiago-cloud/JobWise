package com.appRH.appRH.controller;

//import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.appRH.appRH.models.Candidato;
import com.appRH.appRH.models.Dependente;
import com.appRH.appRH.models.Funcionario;
import com.appRH.appRH.models.Vaga;

import com.appRH.appRH.repository.FuncionarioRepository;
import com.appRH.appRH.repository.VagaRepository;
//import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.appRH.appRH.repository.DependenteRepository;
import com.appRH.appRH.repository.CandidatoRepository;

@RestController
public class buscaController {

	@Autowired
	private FuncionarioRepository fr;
	
	@Autowired
	private VagaRepository vr;
	
	@Autowired
	private DependenteRepository dr;
	
	@Autowired
	private CandidatoRepository cr;
	
	//GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da busca por " + buscar;
		
		if(nome.equals("nomefuncionario")) {
			mv.addObject("funcionarios", fr.findByNomes(buscar));
		}else if(nome.equals("nomedependente")) {
			mv.addObject("dependentes", dr.findByNomesDependentes(buscar));
		}else if(nome.equals("nomecandidato")) {
			mv.addObject("candidatos", cr.findByNomesCandidatos(buscar));
		}else if(nome.equals("titulovaga")) {
			mv.addObject("vagas", vr.findByNomesVaga(buscar));
		}else {
			mv.addObject("funcionarios", fr.findByNomes(buscar));
			mv.addObject("dependentes", dr.findByNomesDependentes(buscar));
			mv.addObject("candidatos", cr.findByNomesCandidatos(buscar));
			mv.addObject("vagas", vr.findByNomesVaga(buscar));
		}
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}
	
}
