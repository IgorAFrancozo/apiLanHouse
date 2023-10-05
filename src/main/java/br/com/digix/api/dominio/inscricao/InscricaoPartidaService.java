package br.com.digix.api.dominio.inscricao;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.validacoes.ValidadorInscricao;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import br.com.digix.api.dominio.jogo.JogoRepository;
import br.com.digix.api.dominio.partida.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InscricaoPartidaService {
    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private List<ValidadorInscricao> validadores;

    public DadosDetalhesInscricao inscrever(DadosAgendamentoInscricao dados) {
        validadores.forEach(v -> v.validar(dados));

        var partida = partidaRepository.getReferenceById(dados.idPartida());
        var jogador = jogadorRepository.getReferenceById(dados.idJogador());

        LocalDateTime localDateTime = LocalDateTime.now();
        var inscricao = new Inscricao(partida, jogador, localDateTime);
        inscricaoRepository.save(inscricao);

        return new DadosDetalhesInscricao(inscricao);
    }
}
