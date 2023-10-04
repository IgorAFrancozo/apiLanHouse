package br.com.digix.api.dominio.inscricao;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.validacoes.ValidadorInscricao;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import br.com.digix.api.dominio.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeInscricao {
    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private List<ValidadorInscricao> validadores;

    public DadosDetalhesInscricao inscrever(DadosAgendamentoInscricao dados) {
        if (!jogadorRepository.existsById(dados.idJogador())) {
            throw new ValidacaoException("Id do jogador informado não existe!");
        }

        if (!jogoRepository.existsById(dados.idJogo())) {
            throw new ValidacaoException("Id do jogo informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var jogador = jogadorRepository.getReferenceById(dados.idJogador());

        var inscricao = new Inscricao();
        inscricaoRepository.save(inscricao);

        return new DadosDetalhesInscricao(incricao);
    }
}
