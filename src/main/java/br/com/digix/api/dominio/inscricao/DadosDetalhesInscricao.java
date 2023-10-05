package br.com.digix.api.dominio.inscricao;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhesInscricao(
        Long idJogador,
        Long idPartida,
        @NotNull
        @Future
        LocalDateTime data
) {
    public DadosDetalhesInscricao(Inscricao inscricao) {
        this(inscricao.getJogador().getId(), inscricao.getPartida().getId(), inscricao.getDataInscricao());
    }
}
