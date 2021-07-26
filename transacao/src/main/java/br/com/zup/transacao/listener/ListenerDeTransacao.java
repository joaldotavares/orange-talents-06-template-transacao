package br.com.zup.transacao.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.model.Transacao;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao eventoDeTransacao) {
    	System.out.println("Id: " + eventoDeTransacao.getId());
        System.out.println("Valor: " + eventoDeTransacao.getValor());
        System.out.println("Estabelecimento: " + eventoDeTransacao.getEstabelecimento().getNome());
        System.out.println("Cartão: " + eventoDeTransacao.getCartao().getId());
        System.out.println("Data: " + eventoDeTransacao.getEfetivadaEm());
    }

}
