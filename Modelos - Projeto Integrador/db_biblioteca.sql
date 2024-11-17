-- Cria o banco de dados 'Biblioteca'
CREATE DATABASE IF NOT EXISTS Biblioteca;

-- Usar o novo banco de dados
USE Biblioteca;

-- Criar tabela 'Generos'
CREATE TABLE IF NOT EXISTS Generos (
	ID_Genero INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL
);

-- Criar tabela 'Editoras'
CREATE TABLE IF NOT EXISTS Editoras (
	ID_Editora INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Pais VARCHAR(50)
);

-- Criar tabela 'Autores'
CREATE TABLE IF NOT EXISTS Autores (
	ID_Autor INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Data_Nascimento DATE,
    Nacionalidade VARCHAR(50)
);

-- Criar tabela 'Usuarios'
CREATE TABLE IF NOT EXISTS Usuarios (
	ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    Endereco VARCHAR(200),
    Data_Cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Telefone VARCHAR(20)
);

-- Criar tabela 'Livros'
CREATE TABLE IF NOT EXISTS Livros (
	ID_Livro INT AUTO_INCREMENT PRIMARY KEY,
    ID_Genero INT,
    ID_Editora INT,
    ID_Autor INT,
    Titulo VARCHAR(150) NOT NULL,
    Data_Publicacao DATE NOT NULL,
    Qtde_Disponivel INT DEFAULT 0,
    FOREIGN KEY (ID_Genero) REFERENCES Generos(ID_Genero),
    FOREIGN KEY (ID_Editora) REFERENCES Editoras(ID_Editora),
    FOREIGN KEY (ID_Autor) REFERENCES Autores(ID_Autor)
);

-- Criar tabela 'Emprestimos'
CREATE TABLE IF NOT EXISTS Emprestimos (
	ID_Emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    ID_Usuario INT,
    ID_Livro INT,
    Data_Emprestimo DATE NOT NULL,
    Status_Emprestimo VARCHAR(20),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Livro) REFERENCES Livros(ID_Livro)
);

-- Criar tabela 'Reservas'
CREATE TABLE IF NOT EXISTS Reservas (
	ID_Reserva INT AUTO_INCREMENT PRIMARY KEY,
    ID_Usuario INT,
    ID_Livro INT,
    Status_Reserva VARCHAR(20),
    Data_Reserva DATE NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Livro) REFERENCES Livros(ID_Livro)
);