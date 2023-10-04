package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorJogadorAtivo implements ValidadorInscricao {
    @Autowired
    private JogadorRepository jogadorRepository;

    public void validar(DadosAgendamentoInscricao dados) {
        var jogadorEstaAtivo = jogadorRepository.findAtivoById(dados.idJogador());
        if (!jogadorEstaAtivo) {
            throw new ValidacaoException("Inscrição não pode ser feita com jogador excluído");
        }

    }
}
