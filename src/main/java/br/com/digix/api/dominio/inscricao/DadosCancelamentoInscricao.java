package br.com.digix.api.dominio.inscricao;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInscricao(
        @NotNull
        Long idInscricao,

        @NotNull
        MotivoCancelamento motivo
) {
}
