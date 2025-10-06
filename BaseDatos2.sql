DROP DATABASE IF EXISTS Datos;
CREATE DATABASE IF NOT EXISTS Datos;
USE Datos;

CREATE TABLE IF NOT EXISTS Jardin (
	Codigo int unique not null auto_increment,
	Nombre varchar(15),
    Familia varchar(15),
    LuzNecesaria varchar(8),
    Riego int,
    Ubicacion varchar(8)
);

ALTER TABLE Jardin ADD PRIMARY KEY (Codigo);

INSERT INTO Jardin(Codigo,Nombre,Familia,LuzNecesaria,Riego,Ubicacion) VALUES 
	(1,"Rosa","Rosaceae","Alta",3,"exterior"),
    (2,"Tulipan","Liliaceae","Alta",7,"exterior"),
    (3,"Petunia","B","Baja",2,"Maceta");
    
SELECT * FROM Jardin;
FLUSH PRIVILEGES;