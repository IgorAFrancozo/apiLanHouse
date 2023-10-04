package br.com.digix.api.dominio.jogador;

import br.com.digix.api.dominio.ValidacaoException;
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
    private Boolean ativo;

    public Jogador(DadosCadastroJogador dadosCadastro) {
        this.ativo = true;
        this.nome = dadosCadastro.nome();
        this.dataNascimento = dadosCadastro.dataNascimento();
        this.nickname = dadosCadastro.nickname();
        this.email = dadosCadastro.email();
    }

    public void atualizarInformacoes(DadosAtualizacaoJogador dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.nickname() != null) {
            this.nickname = dados.nickname();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }

    }

    public boolean validarIdadeParaInscricao(Jogador jogador) {
        var idadeLimite = 14;
        if (jogador.getIdadeDoJogador() <= idadeLimite) {
            throw new ValidacaoException("Jogador não possui idade mínima para se inscrever");
        }
        return jogador.getIdadeDoJogador() > idadeLimite;
    }

    public int getIdadeDoJogador() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public void excluir() {
        this.ativo = false;
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
