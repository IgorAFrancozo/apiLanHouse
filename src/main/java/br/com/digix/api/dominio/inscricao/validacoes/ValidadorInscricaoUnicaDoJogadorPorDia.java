package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.inscricao.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class ValidadorInscricaoUnicaDoJogadorPorDia implements ValidadorInscricao {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Override
    public void validar(DadosAgendamentoInscricao dados) {
        LocalDateTime inicioDoDia = dados.data().with(LocalTime.MIN);
        LocalDateTime fimDoDia = dados.data().with(LocalTime.MAX);

        boolean jogadorInscritoNoMesmoDia = inscricaoRepository.existsByJogadorIdAndDataBetween(
                dados.idJogador(), inicioDoDia, fimDoDia);

        if (jogadorInscritoNoMesmoDia) {
            throw new ValidacaoException("Jogador já está inscrito em outra partida no mesmo dia");
        }
    }
}