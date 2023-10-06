package br.com.digix.api.dominio.partida;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.partida.validacoes.ValidadorPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private List<ValidadorPartida> validadores;

    public void inscreverJogador(DadosValidacaoPartida dados) {
        // Lógica para inscrever um jogador na partida
        validadores.forEach(v -> v.validar(dados));
    }

    public void removerInscricao(DadosValidacaoPartida dados) {
        // Lógica para remover a inscrição de um jogador na partida
        validadores.forEach(v -> v.validar(dados));
    }

    public void iniciarPartida(DadosValidacaoPartida dados) {
        // Lógica para iniciar uma partida
        validadores.forEach(v -> v.validar(dados));
    }

    public void removerPartida(Long partidaId) {
        // Lógica para remover uma partida
    }

    public List<Jogador> listarJogadores(Long partidaId) {
        // Lógica para listar jogadores de uma partida
    }

    public void finalizarPartida(DadosValidacaoPartida dados) {
        // Lógica para finalizar uma partida
        validadores.forEach(v -> v.validar(dados));
    }

    public Partida buscarPartidaComMaiorNumeroDeJogadores() {
        // Lógica para encontrar a partida com o maior número de jogadores
    }
}
