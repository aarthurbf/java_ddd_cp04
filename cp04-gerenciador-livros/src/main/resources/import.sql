INSERT INTO usuario (nome, email) VALUES ('Alice Silva', 'alice@email.com');
INSERT INTO usuario (nome, email) VALUES ('Bruno Santos', 'bruno@email.com');
INSERT INTO usuario (nome, email) VALUES ('Carla Pereira', 'carla@email.com');

INSERT INTO livro (titulo, autor, ano, status) VALUES ('Dom Casmurro', 'Machado de Assis', 1899, 'DISPONIVEL');
INSERT INTO livro (titulo, autor, ano, status) VALUES ('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 1943, 'DISPONIVEL');
INSERT INTO livro (titulo, autor, ano, status) VALUES ('1984', 'George Orwell', 1949, 'DISPONIVEL');

INSERT INTO emprestimo (livro_id, usuario_id, data_retirada, data_devolucao)
VALUES (2, 1, DATE '2025-10-05', DATE '2025-10-12');
