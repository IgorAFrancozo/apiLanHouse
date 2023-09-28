package br.com.digix.api.dominio.jogador;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidarJogador {
    JogadorRepository jogadorRepository;

    @Autowired
    public ValidarJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public boolean validarIdade(Jogador jogador) {
        return jogador.getIdadeDoJogador() > 14;
    }

    public boolean validarNicknameUnico(Jogador novoJogador) {
        Optional<Jogador> jogadorExistente = jogadorRepository.findByNickname(novoJogador.getNickname());
        return jogadorExistente.isEmpty();
    }
}