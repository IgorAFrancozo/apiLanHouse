package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;

public interface ValidadorInscricao {
    void validar(DadosAgendamentoInscricao dados);
}
