package br.com.digix.api.dominio.categoria;

import br.com.digix.api.dominio.jogador.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
