CREATE TABLE IF NOT EXISTS inscricoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
        partida_id INT,
        jogador_id INT,
        data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        motivo_cancelamento ENUM('PARTIDA_CANCELADA', 'JOGADOR_CANCELADO', 'OUTRO') DEFAULT NULL,
);