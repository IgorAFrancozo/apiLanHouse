package br.com.digix.api.dominio.jogador;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.Period;

@Data
@Table(name = "jogadores")
@Entity(name = "Jogador")
@EqualsAndHashCode(of = "id")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String nickname;
    private String email;

    public Jogador(DadosCadastroJogador dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.dataNascimento = dadosCadastro.dataNascimento();
        this.nickname = dadosCadastro.nickname();
        this.email = dadosCadastro.email();
    }
    public Jogador(DadosAtualizacaoJogador dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.dataNascimento = dadosCadastro.dataNascimento();
        this.nickname = dadosCadastro.nickname();
        this.email = dadosCadastro.email();
    }

    public int getIdadeDoJogador() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
}
