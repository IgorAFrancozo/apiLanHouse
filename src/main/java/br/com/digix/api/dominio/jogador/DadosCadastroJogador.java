package br.com.digix.api.dominio.jogador;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public record DadosCadastroJogador(
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email
) {
}