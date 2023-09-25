package br.com.digix.api.dominio.jogo;

public record DadosListagemJogo(
        Long id,
        String nome,
        String categoria,
        String fornecedor
) {
}
