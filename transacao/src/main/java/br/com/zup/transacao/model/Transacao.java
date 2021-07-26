package br.com.zup.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class Transacao {

	@Id
	private String id;
	private BigDecimal valor;

	@Valid
	@OneToOne(cascade = CascadeType.MERGE)
	private Estabelecimento estabelecimento;

	@Valid
	@OneToOne(cascade = CascadeType.MERGE)
	private Cartao cartao;

	private LocalDateTime efetivadaEm;

	public Transacao() {
		super();
	}

	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}
