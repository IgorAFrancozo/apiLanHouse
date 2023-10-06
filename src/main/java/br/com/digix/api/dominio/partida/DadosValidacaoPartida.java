package br.com.digix.api.dominio.partida;

import java.time.LocalDate;

public record DadosValidacaoPartida(
        Long idPartida,
        Long idJogador,
        Long idJogo,
        LocalDate data
) {
}
