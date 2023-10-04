package br.com.digix.api.dominio.jogador;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosDetalhesJogador(
        @NotNull
        Long id,
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email
) {
    public DadosDetalhesJogador(Jogador jogador) {
        this(jogador.getId(), jogador.getNome(), jogador.getDataNascimento(), jogador.getNickname(), jogador.getEmail());
    }
}