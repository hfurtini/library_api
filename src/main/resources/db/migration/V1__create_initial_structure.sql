CREATE TABLE IF NOT EXISTS person (
    person_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    cep VARCHAR(9),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
    book_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    release_date DATE
);

CREATE TABLE IF NOT EXISTS book_loan (
    loan_id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    person_id BIGINT NOT NULL,
    CONSTRAINT fk_bookloan_book FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE RESTRICT,
    CONSTRAINT fk_bookloan_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE RESTRICT
);