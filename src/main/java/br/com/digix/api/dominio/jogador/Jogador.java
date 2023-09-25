package br.com.digix.api.dominio.jogador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Table(name = "jogadores")
@Entity(name = "Jogador")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String nickname;
    private String email;

    public Jogador(DadosDetalhesJogador dadosCadastro) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
