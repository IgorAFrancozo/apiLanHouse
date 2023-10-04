package br.com.digix.api.dominio.inscricao.validacoes;

import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.jogador.DadosCadastroJogador;
import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidarNicknameJogador implements ValidadorInscricao {
    JogadorRepository jogadorRepository;

    @Autowired
    public ValidarNicknameJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void validar(DadosAgendamentoInscricao dados) {
        var jogadorExistente = jogadorRepository.findAtivoById(dados.idJogador());

        return jogadorExistente.isEmpty();
    }
}