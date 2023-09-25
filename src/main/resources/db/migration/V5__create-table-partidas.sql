CREATE TABLE IF NOT EXISTS partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jogo_id INT,
    status ENUM('PROGRAMADA', 'EM_ANDAMENTO', 'FINALIZADA') NOT NULL,
    horarioInicioProgramado DATETIME,
    horarioFimProgramado DATETIME,
    horarioInicioReal DATETIME,
    horarioFimReal DATETIME,
    vencedor_id INT
);