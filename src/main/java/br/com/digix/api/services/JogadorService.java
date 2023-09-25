package br.com.digix.api.services;

import br.com.digix.api.dominio.jogador.Jogador;
import br.com.digix.api.dominio.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService extends BaseService<Jogador> {

    private final JogadorRepository jogadorRepository;
    private final ValidarJogador validarJogador;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository, ValidarJogador validarJogador) {
        this.jogadorRepository = jogadorRepository;
        this.validarJogador = validarJogador;
    }

    @Override
    public void adicionar(Jogador jogador) {
        if (validarJogador.validarIdade(jogador) && validarJogador.validarNicknameUnico(jogador)) {
            jogadorRepository.save(jogador);
        } else {
            throw new IllegalArgumentException("O jogador não atende aos critérios de idade ou o nickname não é único.");
        }
    }

    @Override
    public void remover(Long jogadorId) {
        if (!jogadorRepository.existsById(jogadorId)) {
            throw new IllegalArgumentException("Jogador não encontrado");
        }
        jogadorRepository.deleteById(jogadorId);
    }

    @Override
    public void atualizar(Long jogadorId, Jogador dadosAtualizacao) {
        Jogador jogador = jogadorRepository.findById(jogadorId)
                .orElseThrow(() -> new IllegalArgumentException("Jogador não encontrado"));

        if (dadosAtualizacao.getNome() != null) {
            jogador.setNome(dadosAtualizacao.getNome());
        }
        if (dadosAtualizacao.getDataNascimento() != null) {
            jogador.setDataNascimento(dadosAtualizacao.getDataNascimento());
        }
        if (dadosAtualizacao.getNickname() != null) {
            jogador.setNickname(dadosAtualizacao.getNickname());
        }
        if (dadosAtualizacao.getEmail() != null) {
            jogador.setEmail(dadosAtualizacao.getEmail());
        }

        if (validarJogador.validarIdade(jogador) && validarJogador.validarNicknameUnico(jogador)) {
            jogadorRepository.save(jogador);
        } else {
            throw new IllegalArgumentException("O jogador não atende aos critérios de idade ou o nickname não é único.");
        }
    }

    public Page<Jogador> listar(Pageable pageable) {
        return jogadorRepository.findAll(pageable);
    }
}