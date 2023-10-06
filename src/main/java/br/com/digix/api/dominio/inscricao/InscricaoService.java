package br.com.digix.api.dominio.inscricao;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.validacoes.ValidadorInscricao;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import br.com.digix.api.dominio.partida.PartidaRepository;
import br.com.digix.api.dominio.partida.StatusPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InscricaoService {
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

    public List<DadosDetalhesInscricao> listarInscricoes() {
        List<Inscricao> inscricoes = inscricaoRepository.findAll();
        List<DadosDetalhesInscricao> detalhesInscricoes = new ArrayList<>();

        for (Inscricao inscricao : inscricoes) {
            detalhesInscricoes.add(new DadosDetalhesInscricao(inscricao));
        }

        return detalhesInscricoes;
    }

    public DadosCancelamentoInscricao cancelarInscricao(Long inscricaoId, MotivoCancelamento motivo) {
        var inscricao = inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new ValidacaoException("Inscrição não encontrada"));

        if (inscricao.getPartida().getStatus() != StatusPartida.PROGRAMADA) {
            throw new ValidacaoException("Não é possível cancelar uma inscrição em uma partida já iniciada");
        }

        inscricao.cancelar(motivo);
        inscricaoRepository.save(inscricao);

        return new DadosCancelamentoInscricao(inscricao.getId(), motivo);
    }
}
