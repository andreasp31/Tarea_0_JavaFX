DROP DATABASE IF EXISTS Datos;
CREATE DATABASE IF NOT EXISTS Datos;
USE Datos;

CREATE TABLE IF NOT EXISTS plantas (
	Nombre varchar(15),
    Familia varchar(15),
    Luz varchar(8),
    Riego int,
    Ubicacion varchar(8)
);

FLUSH PRIVILEGES;

SELECT * FROM plantas; 

DELETE FROM plantas WHERE Nombre LIKE "a";