CREATE SCHEMA IF NOT EXISTS sistemaReservaConsulta;

USE sistemaReservaConsulta;

CREATE TABLE IF NOT EXISTS usuario(
	idUsuario				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login					VARCHAR(255) UNIQUE,
    senha					VARCHAR(255),
    adm						BOOLEAN							
);

CREATE TABLE IF NOT EXISTS enderecoPaciente(
	idEndereco 				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rua						VARCHAR(100) NOT NULL,
    numero					INT NOT NULL,
    cep						VARCHAR(8) NOT NULL,
    cidade					VARCHAR(60) NOT NULL,
    estado					VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS paciente(
	idPaciente				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome					VARCHAR(60) NOT NULL,
    sobrenome				VARCHAR(60) NOT NULL,
	idEndereco 				INT NOT NULL,
    rg						VARCHAR(10) NOT NULL,
    dataAlta				DATE,
    CONSTRAINT fk_Endereco	FOREIGN KEY(idEndereco)		REFERENCES enderecoPaciente(idEndereco)
);


CREATE TABLE IF NOT EXISTS dentista(
	idDentista				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome					VARCHAR(60) NOT NULL,
    sobrenome				VARCHAR(60) NOT NULL,
    matriculaCadastro		VARCHAR(10) NOT NULL
);


CREATE TABLE IF NOT EXISTS consulta(
	idPacienteAtribuido			INT NOT NULL,
    idDentistaAtribuido			INT NOT NULL,
    dataEHoraDaConsulta			DATETIME,
    CONSTRAINT fk_Paciente		FOREIGN KEY(idPacienteAtribuido)	REFERENCES paciente(idPaciente),
    CONSTRAINT fk_Dentista		FOREIGN KEY(idDentistaAtribuido)	REFERENCES dentista(idDentista)
);