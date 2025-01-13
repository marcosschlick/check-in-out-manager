CREATE DATABASE IF NOT EXISTS controlador_presenca;
USE controlador_presenca;

-- Tabela de usuários com validação no campo documento
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    documento VARCHAR(11) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT chk_documento_valido CHECK (documento REGEXP '^[0-9]{8}$|^[0-9]{11}$')
);

-- Tabela de presenças
CREATE TABLE presenca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    data_entrada DATE NOT NULL,
    horario_entrada TIME NOT NULL,
    data_saida DATE DEFAULT NULL,
    horario_saida TIME DEFAULT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);
