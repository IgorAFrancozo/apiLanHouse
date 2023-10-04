package br.com.digix.api.dominio.jogador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    Page<Jogador> findAllByAtivoTrue(Pageable pageable);
    Optional<Jogador> findByNickname(String nickname);
}