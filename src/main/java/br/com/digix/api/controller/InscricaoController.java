package br.com.digix.api.controller;

import br.com.digix.api.dominio.inscricao.DadosAgendamentoInscricao;
import br.com.digix.api.dominio.inscricao.DadosCancelamentoInscricao;
import br.com.digix.api.dominio.inscricao.DadosDetalhesInscricao;
import br.com.digix.api.dominio.inscricao.InscricaoPartidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        var inscricao = inscricaoPartidaService.inscrever(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @DeleteMapping("/cancelar/{inscricaoId}")
    public ResponseEntity<Void> cancelarInscricao(@PathVariable @Valid DadosCancelamentoInscricao dadosCancelamentoInscricao) {
        inscricaoPartidaService.cancelarInscricao(dadosCancelamentoInscricao.idInscricao(), dadosCancelamentoInscricao.motivo());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DadosDetalhesInscricao>> listarInscricoes() {
        List<DadosDetalhesInscricao> inscricoes = inscricaoPartidaService.listarInscricoes();
        return ResponseEntity.ok(inscricoes);
    }
}
