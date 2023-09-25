-- FK para a tabela 'partidas' (coluna 'partida_id')
ALTER TABLE inscricoes
    ADD CONSTRAINT fk_inscricao_partida
    FOREIGN KEY (partida_id)
    REFERENCES partidas(id);

-- FK para a tabela 'jogadores' (coluna 'jogador_id')
ALTER TABLE inscricoes
    ADD CONSTRAINT fk_inscricao_jogador
    FOREIGN KEY (jogador_id)
    REFERENCES jogadores(id);