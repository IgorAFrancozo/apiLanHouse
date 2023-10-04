package br.com.digix.api.dominio.jogador;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoJogador(
        @NotNull
        Long id,
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email
) {
}
