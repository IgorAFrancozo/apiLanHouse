package br.com.digix.api.dominio.partida;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogo.Jogo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Table(name = "partidas")
@Entity(name = "Partida")
@EqualsAndHashCode(of = "id")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "partida_jogadores",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    private List<Jogador> jogadores;

    @Enumerated(EnumType.STRING)
    private StatusPartida status;

    private LocalDateTime horarioInicioProgramado;
    private LocalDateTime horarioFimProgramado;
    private LocalDateTime horarioInicioReal;
    private LocalDateTime horarioFimReal;
    @ManyToOne
    @JoinColumn(name = "vencedor_id")
    private Jogador vencedor;
}