package br.com.zup.transacao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.transacao.dto.TransacaoDTO;
import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

	private final CartaoRepository cartaoRepository;

	private final TransacaoRepository transacaoRepository;

	public TransacaoController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
		super();
		this.cartaoRepository = cartaoRepository;
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping("/cartao/{id}")
	public ResponseEntity<Page<?>> exibir(@PathVariable String id,
			@PageableDefault(sort = "efetivadaEm", page = 0, size = 10) Pageable paginacao) {

		Cartao cartao = cartaoRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao com id \"" + id + "\" não existe."));
		Page<Transacao> compras = transacaoRepository.findByCartaoId(id, paginacao);

		logger.info("Cartão encontrado com os seguintes dados, " + cartao.toString());

		return ResponseEntity.ok().body(TransacaoDTO.converter(compras));
	}
}
