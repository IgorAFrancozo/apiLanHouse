package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.partida.PartidaRepository;
import br.com.digix.api.dominio.partida.StatusPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPartidaProgramada implements ValidadorInscricao {

    @Autowired
    private PartidaRepository partidaRepository;

    @Override
    public void validar(DadosAgendamentoInscricao dados) {
        var partida = partidaRepository.getReferenceById(dados.idPartida());

        if (partida.getStatus() != StatusPartida.PROGRAMADA) {
            throw new ValidacaoException("A partida não está programada para inscrições");
        }

    }
}
