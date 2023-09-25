package br.com.digix.api.dominio.jogador;

import java.time.LocalDate;
import java.time.Period;

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
                calcularIdade(jogador.getDataNascimento()));
    }

    private static int calcularIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
}