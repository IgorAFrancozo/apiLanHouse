-- FK para tabela 'jogos' (coluna 'jogador_id')
ALTER TABLE partidas
    ADD CONSTRAINT fk_partida_jogo
    FOREIGN KEY (jogo_id)
    REFERENCES jogos(id);

-- FK tabela 'jogadores' (coluna 'vencedor_id')
ALTER TABLE partidas
    ADD CONSTRAINT fk_partida_vencedor
    FOREIGN KEY (vencedor_id)
    REFERENCES jogadores(id);