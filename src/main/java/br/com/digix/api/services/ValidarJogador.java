package br.com.digix.api.services;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ValidarJogador {
    @Autowired
    JogadorRepository jogadorRepository;

    public boolean validarIdade(Jogador jogador) {
        return jogador.getIdadeDoJogador() > 14;
    }

    public boolean validarNicknameUnico(Jogador novoJogador) {
        Optional<Jogador> jogadorExistente = jogadorRepository.findByNickname(novoJogador.getNickname());
        return jogadorExistente.isEmpty();
    }
}