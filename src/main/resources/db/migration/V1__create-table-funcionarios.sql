CREATE TABLE funcionarios (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE,
    pis VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario INTEGER NOT NULL,
    admissao DATE,
    cep VARCHAR(8) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(100),
    bairro VARCHAR(70) NOT NULL,
    cidade VARCHAR(70) NOT NULL,
    uf CHAR(2) NOT NULL
);