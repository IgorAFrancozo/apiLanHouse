package br.com.digix.api.controller;

import br.com.digix.api.dominio.jogador.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrarJogador(@RequestBody @Valid DadosCadastroJogador dadosCadastro, UriComponentsBuilder uriBuilder) {
        var jogador = new Jogador(dadosCadastro);
        jogadorRepository.save(jogador);

        var uri = uriBuilder.path("/jogadores/{id}").buildAndExpand(jogador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesJogador(jogador));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemJogador>> listarJogadores(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = jogadorRepository.findAllByAtivoTrue(pageable).map(DadosListagemJogador::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Jogador> atualizarJogador(@RequestBody @Valid DadosAtualizacaoJogador dadosAtualizacao) {
        var jogador = jogadorRepository.getReferenceById(dadosAtualizacao.id());
        jogador.atualizarInformacoes(dadosAtualizacao);
        return ResponseEntity.ok(jogador);
    }

    @DeleteMapping("/{jogadorId}")
    public ResponseEntity<Void> removerJogador(@PathVariable Long jogadorId) {
        var jogador = jogadorRepository.getReferenceById(jogadorId);
        jogador.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var jogador = jogadorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesJogador(jogador));
    }
}