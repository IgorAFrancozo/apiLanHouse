package br.com.digix.api.controller;

import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.inscricao.DadosDetalhesInscricao;
import br.com.digix.api.dominio.inscricao.InscricaoPartidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoPartidaService inscricaoPartidaService;

    @PostMapping("/inscrever")
    public ResponseEntity<DadosDetalhesInscricao> inscreverParaPartida(@RequestBody @Valid DadosAgendamentoInscricao dados) {
        try {
            DadosDetalhesInscricao inscricao = inscricaoPartidaService.inscrever(dados);
            return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DadosDetalhesInscricao(e.getMessage()));
        }
    }

    @DeleteMapping("/cancelar/{inscricaoId}")
    public ResponseEntity<Void> cancelarInscricao(@PathVariable Long inscricaoId) {
        inscricaoPartidaService.cancelarInscricao(inscricaoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DadosDetalhesInscricao>> listarInscricoes() {
        List<DadosDetalhesInscricao> inscricoes = inscricaoPartidaService.listarInscricoes();
        return ResponseEntity.ok(inscricoes);
    }
}
