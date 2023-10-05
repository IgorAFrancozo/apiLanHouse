package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.inscricao.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInscricaoJogadorUnicaPorDia implements ValidadorInscricao {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Override
    public void validar(DadosAgendamentoInscricao dados) {
        // Lógica para validar inscrição única por dia para um jogador
        // ...
    }
}