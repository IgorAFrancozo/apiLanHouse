package br.com.digix.api.dominio.jogador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosDetalhesJogador(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNascimento,
        @NotBlank
        String nickname,
        @NotBlank
        String email
) {
}