package br.com.zup.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.Transacao;

public class TransacaoDTO {

	private String id;
	private BigDecimal valor;
	private Estabelecimento estabalecimento;
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoDTO() {
		super();
	}

	public TransacaoDTO(Transacao transacao) {
		super();
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.estabalecimento = transacao.getEstabelecimento();
		this.cartao = transacao.getCartao();
		this.efetivadaEm = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Transacao toModel() {
		return new Transacao(id, valor, estabalecimento, cartao, efetivadaEm);
	}

	public static Page<TransacaoDTO> converter(Page<Transacao> transacao) {
		return transacao.map(TransacaoDTO::new);
	}
}
