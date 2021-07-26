package br.com.zup.transacao.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.dto.TransacaoDTO;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.TransacaoRepository;

@Component
public class ListenerDeTransacao {

	private TransacaoRepository transacaoRepository;

	public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
		super();
		this.transacaoRepository = transacaoRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(TransacaoDTO eventoDeTransacao) {
		Transacao transacao = eventoDeTransacao.toModel();

		transacaoRepository.save(transacao);
	}

}
