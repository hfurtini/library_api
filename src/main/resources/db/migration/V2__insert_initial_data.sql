INSERT INTO person (name, cpf, cep, email, password) VALUES
('João Silva', '11111111111', '37200-000', 'joao.silva@email.com', 'senha123'),
('Maria Oliveira', '22222222222', '37200-001', 'maria.oliveira@email.com', 'senha123'),
('Carlos Santos', '33333333333', '37200-002', 'carlos.santos@email.com', 'senha123'),
('Ana Costa', '44444444444', '37200-003', 'ana.costa@email.com', 'senha123'),
('Lucas Pereira', '55555555555', '37200-004', 'lucas.pereira@email.com', 'senha123');

INSERT INTO book (name, author, release_date) VALUES
('O Senhor dos Anéis', 'J.R.R. Tolkien', '1954-07-29'),
('1984', 'George Orwell', '1949-06-08'),
('Dom Casmurro', 'Machado de Assis', '1899-01-01'),
('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', '1943-04-06'),
('Algoritmos: Teoria e Prática', 'Thomas H. Cormen', '1989-01-01');

INSERT INTO book_loan (book_id, person_id) VALUES
(1, 1), -- João pegou 'O Senhor dos Anéis'
(2, 2), -- Maria pegou '1984'
(3, 3), -- Carlos pegou 'Dom Casmurro'
(4, 4), -- Ana pegou 'O Pequeno Príncipe'
(5, 1); -- João pegou o livro de 'Algoritmos' também