package br.com.digix.api.dominio.partida.validacoes;

import br.com.digix.api.dominio.partida.DadosValidacaoPartida;

public interface ValidadorPartida {
    void validar(DadosValidacaoPartida dados);
}
