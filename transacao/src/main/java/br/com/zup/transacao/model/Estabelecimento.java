package br.com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cidade;
	private String endereco;
	
	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

}
