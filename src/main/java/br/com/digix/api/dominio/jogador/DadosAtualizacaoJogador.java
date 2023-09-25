package br.com.digix.api.dominio.jogador;

import java.time.LocalDate;

public record DadosAtualizacaoJogador(
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email
) {
}