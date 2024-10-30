package com.appRH.appRH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appRH.appRH.models.Dependentes;
import com.appRH.appRH.models.Funcionario;
import com.appRH.appRH.repository.DependentesRepository;
import com.appRH.appRH.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@Autowired
	private DependentesRepository dr;
	
	//Mostrar o form de funcionário
	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.GET)
	public String form() {
		return "funcionario/formFuncionario";
		}
	
	//Cadastrar funcionário
	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
	public String form(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarFuncionario";
		}
	
		fr.save(funcionario);//para o save funcinar e necessário fazer a implementação no repository
		attributes.addFlashAttribute("mensagem", "Funcionario cadastrado com sucesso!");
		return "redirect:/cadastrarFuncionario";
	}
	
	//Listar Funcionário
	@RequestMapping("/funcionarios")
	public ModelAndView listarFuncionarios() {
		ModelAndView mv = new ModelAndView("funcionario/listarFuncinario");//Instanciando o model view
		Iterable<Funcionario> funcionarios = fr.findAll();//Pegando a lista com todos os funcionarios para inserir dentro do objeto e assim enviar para mv que e a view
		mv.addObject("funcionarios", funcionarios);//inserindo a lista funcionarios em um objeto
		return mv; //Retronando view mv com o objeto funcionarios e assim mostrando no template a lista
	
	}
	
	//Listar Dependentes
	@RequestMapping(value = "/dependentes/{id}", method = RequestMethod.GET)
	public ModelAndView listarDependetes(@PathVariable("id") long id) {
		Funcionario funcionario = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/dependentes");
		mv.addObject("funcionario", funcionario);
		
		//Lista de dependentes baseada no funcionario
		Iterable<Dependentes> dependentes = dr.findByFuncionario(funcionario);
		mv.addObject("dependentes", dependentes);
		
		return mv;
	
	}
	
	//Adicionar Dependentes
	//O attributes servirá para fazer as validações dos campos ao efetuar a requisição POST.
	@RequestMapping(value = "/dependentes/{id}", method = RequestMethod.POST)
	public String dependentesPost(@PathVariable("id") long id, Dependentes dependentes, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/dependentes/{id}";
		}
		
		if(dr.findByCpf(dependentes.getCpf()) != null) {
			attributes.addFlashAttribute("mensagem_erro", "CPF duplicado");
			return "redirect:/dependentes/{id}";
		}
		
		//Salvando dependente no banco de dados após todos os dados terem sidos válidados.
		Funcionario funcionario = fr.findById(id);
		dependentes.setFuncionario(funcionario);
		dr.save(dependentes);
		attributes.addFlashAttribute("mensagem", "Dependentes adicionando com sucesso");
		return "redirect:/dependentes/{id}";
		
	}
	
	//Deleta Funcionário
	@RequestMapping("/deletarFuncinario")
	public String deletaFuncionario(long id) {
		Funcionario funcionario = fr.findById(id);
		fr.delete(funcionario);
		return "redirect:/funcionario";
	}

	//Métodos que atualiza funcionário
	//Formulário
	@RequestMapping(value = "/editar-funcionario", method = RequestMethod.GET)
	public ModelAndView editarFuncionario(long id) {
		Funcionario funcionario = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/update-funcionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	//Update funcionário
	@RequestMapping(value = "/editar-funcionario", method = RequestMethod.POST)
	public String updateFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
		
		fr.save(funcionario);
		attributes.addFlashAttribute("success", "Funcionário alterado com sucesso!");
		
		long idLong = funcionario.getId();
		String id = "" + idLong;
		return "redirect:/dependentes/"+ id;
	}

	//Método deletar de dependente 
	@RequestMapping("/deletaDependente")
	public String deletarDependete(String cpf) {
		Dependentes dependente = dr.findByCpf(cpf);
		
		Funcionario funcionario = dependente.getFuncionario();
		String codigo = "" + funcionario.getId();
		
		return "redirect:/dependentes/" + codigo;
	}
	
}
	
