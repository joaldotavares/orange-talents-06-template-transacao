package br.com.zup.transacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

	Page<Transacao> findByCartaoId(String id, Pageable paginacao);
}
