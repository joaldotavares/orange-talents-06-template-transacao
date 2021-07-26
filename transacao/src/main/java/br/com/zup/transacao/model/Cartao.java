package br.com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

	@Id
	private String id;
	
	@Email
	private String email;

	public Cartao() {
		super();
	}

	public Cartao(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
	
	
}
