package com.appRH.appRH.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(unique = true)
	private String cpf;
	
	private String nome;
	
	@Column(name = "data_nascimento_string")
	private LocalDate dataNascimentoString;
	
	@ManyToOne// Muitos dependentes para um
	private Funcionario funcionario;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimentoString() {
		return dataNascimentoString;
	}

	public void setDataNascimentoString(LocalDate dataNascimentoString) {
		this.dataNascimentoString = dataNascimentoString;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	};

	
}
