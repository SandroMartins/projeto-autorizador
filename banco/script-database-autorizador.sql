-- Database: sistema-autorizador

-- DROP DATABASE "sistema-autorizador";

CREATE DATABASE "sistema-autorizador"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
CREATE TABLE autorizador (
	id_autorizador SERIAL,
	nr_procedimento INT NOT NULL,
	idade INT NOT NULL,
	sexo VARCHAR(50) NOT NULL,
	ativo BOOLEAN DEFAULT true,
	PRIMARY KEY (id_autorizador)
);

INSERT INTO autorizador (nr_procedimento, idade, sexo)
VALUES 
	(1234, 10, 'M'),
	(4567, 20, 'M'),
	(6789, 10, 'F'),
	(6789, 10, 'M'),
	(1234, 20, 'M'),
	(4567, 30, 'F');