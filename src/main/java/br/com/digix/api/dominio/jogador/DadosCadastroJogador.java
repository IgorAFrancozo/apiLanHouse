package br.com.digix.api.dominio.jogador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroJogador(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNascimento,
        @NotBlank
        String nickname,
        @NotBlank
        @Email
        String email
) {
}
