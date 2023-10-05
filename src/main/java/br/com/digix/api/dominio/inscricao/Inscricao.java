package br.com.digix.api.dominio.inscricao;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.partida.Partida;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Table(name = "inscricoes")
@Entity(name = "Inscricao")
@EqualsAndHashCode(of = "id")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;
    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    private LocalDateTime dataInscricao;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public Inscricao(Partida partida, Jogador jogador, LocalDateTime dataInscricao) {
        this.partida = partida;
        this.jogador = jogador;
        this.dataInscricao = dataInscricao;
    }

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}