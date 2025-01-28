-- Inserindo usuários
INSERT INTO usuario (documento, nome) VALUES ('12345678901', 'João Silva');
INSERT INTO usuario (documento, nome) VALUES ('98765432109', 'Maria Oliveira');
INSERT INTO usuario (documento, nome) VALUES ('45678912345', 'Carlos Souza');

-- Inserindo registros de presença para João Silva (id = 1)
INSERT INTO presenca (data_entrada, horario_entrada, usuario_id) VALUES ('2023-10-01', '08:00:00', 1);
INSERT INTO presenca (data_entrada, horario_entrada, data_saida, horario_saida, usuario_id) VALUES ('2023-10-01', '08:00:00', '2023-10-01', '17:00:00', 1);

-- Inserindo registros de presença para Maria Oliveira (id = 2)
INSERT INTO presenca (data_entrada, horario_entrada, usuario_id) VALUES ('2023-10-01', '09:00:00', 2);
INSERT INTO presenca (data_entrada, horario_entrada, data_saida, horario_saida, usuario_id) VALUES ('2023-10-02', '08:30:00', '2023-10-02', '18:00:00', 2);

-- Inserindo registros de presença para Carlos Souza (id = 3)
INSERT INTO presenca (data_entrada, horario_entrada, usuario_id) VALUES ('2023-10-01', '07:45:00', 3);
INSERT INTO presenca (data_entrada, horario_entrada, data_saida, horario_saida, usuario_id) VALUES ('2023-10-02', '08:15:00', '2023-10-02', '17:30:00', 3);