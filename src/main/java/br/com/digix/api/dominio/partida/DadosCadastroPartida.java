package br.com.digix.api.dominio.partida;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogo.Jogo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroPartida(
        Long id,
        @NotNull
        Jogo jogo,
        @NotNull
        List<Jogador> jogadores,
        @NotNull
        StatusPartida status,
        @NotNull
        @Future
        LocalDateTime horarioInicioProgramado,
        @NotNull
        @Future
        LocalDateTime horarioFimProgramado,
        @NotNull
        @Future
        LocalDateTime horarioInicioReal,
        @NotNull
        @Future
        LocalDateTime horarioFimReal,
        Jogador vencedor
) {
}
