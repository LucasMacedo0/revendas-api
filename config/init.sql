-- Criar o banco de dados se não existir
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'revendasDB')
BEGIN
    CREATE DATABASE revendasDB;
END
GO

-- Usar o banco de dados
USE revendasDB;
GO

-- Criar a tabela de revendas primeiro (tabela pai)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'revendas')
BEGIN
    CREATE TABLE revendas (
        id INT PRIMARY KEY IDENTITY(1,1),
        CNPJ VARCHAR(18) UNIQUE NOT NULL CHECK (CNPJ LIKE '[0-9]%'),
        NomeSocial VARCHAR(100) NOT NULL
    );
END
GO

-- Criar a tabela de usuários (depende de revendas)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'usuarios')
BEGIN
    CREATE TABLE usuarios (
        id INT PRIMARY KEY IDENTITY(1,1),
        nome VARCHAR(100) NOT NULL,
        email VARCHAR(100) UNIQUE NOT NULL,
        senha VARCHAR(255) NOT NULL,
        cargo VARCHAR(50) NOT NULL,
        revenda_id INT NULL,
        CONSTRAINT FK_Usuarios_Revendas FOREIGN KEY (revenda_id) REFERENCES revendas(id)
    );
END
GO

-- Criar a tabela de oportunidades (depende de revendas e usuarios)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'oportunidades')
BEGIN
    CREATE TABLE oportunidades (
        id INT PRIMARY KEY IDENTITY(1,1),
        status VARCHAR(50) NOT NULL DEFAULT 'NOVO',
        motivoConclusao VARCHAR(255),
        nomeCliente VARCHAR(100) NOT NULL,
        emailCliente VARCHAR(100) NOT NULL,
        telefoneCliente VARCHAR(20) NOT NULL,
        marcaVeiculo VARCHAR(50) NOT NULL,
        modeloVeiculo VARCHAR(50) NOT NULL,
        versaoVeiculo VARCHAR(50) NOT NULL,
        anoModelo INT,
        revenda_id INT NOT NULL,
        usuario_responsavel_id INT NOT NULL,
        dataAtribuicao DATE,
        dataConclusao DATE,
        CONSTRAINT FK_Oportunidades_Revendas FOREIGN KEY (revenda_id) REFERENCES revendas(id),
        CONSTRAINT FK_Oportunidades_Usuarios FOREIGN KEY (usuario_responsavel_id) REFERENCES usuarios(id)
    );
END
GO
