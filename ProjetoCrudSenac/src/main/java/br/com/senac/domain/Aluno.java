package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// diz que esta classe ira formar uma tabela
@Entity
public class Aluno implements Serializable {

	/**
	 * para o objeto ser unico
	 */
	private static final long serialVersionUID = -9188148431809422228L;

	// como sera o incremento da chave primaria	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// define o nome da tabela
	@Column (name = "nomeAluno")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
}
