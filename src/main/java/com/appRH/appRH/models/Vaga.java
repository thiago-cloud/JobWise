package com.appRH.appRH.models;

/*Transforma os objetos em binarios para poder manipular*/
import java.io.Serializable;
import java.util.List;
/*Servira para quando deletar uma vaga vou deletar também todos os candidatos dela.*/
import jakarta.persistence.CascadeType;
/*Entity de entidades que no caso será as tabelas do banco de dados.*/
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*Quando selecionar um campo selecionará também o Id.*/
import jakarta.persistence.Id;
/*OneToMany e cardinalidade da entidade vaga que no caso e um para muitos.*/
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Vaga implements Serializable{
	
	/*Mecanismo de segurança para não ter problema quando trabalhamos com os dados*/
	private static final long serialVersionUID = 1L;
	
	/*Código da vaga*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Gere um valor de forma automatica que no caso será o id codigo. Porém o AUTO faz com que o spring crie uma tabela a mais para resolver esse problema colocaremos IDENTITY
	private long codigo;
	
	@NotEmpty//NotEmpty o campo não pode ser vazio.
	private String nome;
	
	@NotEmpty
	private String descricao;
	
	@NotEmpty
	private String data;

	@NotEmpty
	private String salario;
	
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE)//Significa que quando for deletada uma vaga será deletada também os candidatos.
	private List<Candidato> candidatos;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	/*Lista de candidatos*/
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	
	
}
