package br.com.digix.api.dominio.jogador;

import lombok.Getter;

import java.time.LocalDate;

public record DadosDetalhesJogador(
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email
) {
}