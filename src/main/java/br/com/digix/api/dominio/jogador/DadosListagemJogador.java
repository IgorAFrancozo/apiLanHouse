package br.com.digix.api.dominio.jogador;

import java.time.LocalDate;

public record DadosListagemJogador(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String nickname,
        String email,
        int idade
) {

    public DadosListagemJogador(Jogador jogador) {
        this(
                jogador.getId(),
                jogador.getNome(),
                jogador.getDataNascimento(),
                jogador.getNickname(),
                jogador.getEmail(),
                jogador.getIdadeDoJogador());
    }
}