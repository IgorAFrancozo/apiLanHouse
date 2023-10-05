package br.com.digix.api.dominio.inscricao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Page<Inscricao> findAllByAtivoTrue(Pageable paginacao);

}
