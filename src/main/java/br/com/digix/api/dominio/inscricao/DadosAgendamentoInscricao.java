package br.com.digix.api.dominio.inscricao;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoInscricao(
        Long idJogo,
        Long idJogador,
        @NotNull
        @Future
        LocalDateTime data
) {
}
