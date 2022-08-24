INSERT INTO levifood.cozinha (nacionalidade) VALUES('Tailandesa');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Indiana');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Brasileira');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Japonesa');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Argentina');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Chinesa');
INSERT INTO levifood.cozinha (nacionalidade) VALUES('Italiana');

INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Melting Pot', 10.5, 1);
INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Pizza Hut', 7.5, 1);
INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Golden Palace', 6.5, 2);
INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Grubber Hub', 10.5, 2);
INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Quick Bite', 7.5, 3);
INSERT INTO levifood.restaurante (nome, taxa_frete, cozinha_id) VALUES('Many Foods', 6.5, 1);

INSERT INTO levifood.forma_pagamento (descricao) VALUES('Criptoativos');
INSERT INTO levifood.forma_pagamento (descricao) VALUES('Agiota');
INSERT INTO levifood.forma_pagamento (descricao) VALUES('Permuta');

INSERT INTO levifood.permissao (descricao, nome) VALUES('Consultar Todos os Registros', 'ROLE_FIND_ALL');
INSERT INTO levifood.permissao (descricao, nome) VALUES('Incluir/Alterar um Registro', 'ROLE_INCLUDE_ALTER');
INSERT INTO levifood.permissao (descricao, nome) VALUES('Remover um Registro', 'ROLE_REMOVE');

INSERT INTO levifood.estado (sigla, nome) VALUES("SC", 'SANTA CATARINA');
INSERT INTO levifood.estado (sigla, nome) VALUES("SP", 'SÃO PAULO');
INSERT INTO levifood.estado (sigla, nome) VALUES("MG", 'MINAS GERAIS');

INSERT INTO levifood.cidade (nome, estado_id) VALUES('Blumenau', 1);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Lages', 1);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Pomerode', 1);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Osasco', 2);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Campinas', 2);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Belo Horizonte', 3);
INSERT INTO levifood.cidade (nome, estado_id) VALUES('Matozinhos', 3);








