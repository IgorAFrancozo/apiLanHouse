package br.com.digix.api.controller;

import br.com.digix.api.dominio.jogador.*;
import br.com.digix.api.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemJogador>> listarJogadores(Pageable pageable) {
        Page<Jogador> page = jogadorService.listar(pageable);
        Page<DadosListagemJogador> dadosPage = page.map(DadosListagemJogador::new);
        return ResponseEntity.ok(dadosPage);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Jogador> cadastrarJogador(@RequestBody DadosDetalhesJogador dadosCadastro) {
        Jogador jogador = new Jogador(dadosCadastro);
        jogadorService.adicionar(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
    }

    @PutMapping("/atualizar/{jogadorId}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long jogadorId, @RequestBody DadosDetalhesJogador dadosAtualizacao) {
        Jogador jogador = new Jogador(dadosAtualizacao);
        jogadorService.atualizar(jogadorId, jogador);
        return ResponseEntity.ok(jogador);
    }

    @DeleteMapping("/deletar/{jogadorId}")
    public ResponseEntity<Void> removerJogador(@PathVariable Long jogadorId) {
        jogadorService.remover(jogadorId);
        return ResponseEntity.noContent().build();
    }
}