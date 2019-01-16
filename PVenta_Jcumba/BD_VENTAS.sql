create database Ventas;
use Ventas;
CREATE TABLE Clientes
(
	cod_cliente          INTEGER IDENTITY(1,1) NOT NULL,
	nom_client           VARCHAR(50) NULL,
	ape_client           VARCHAR(50) NULL,
	telf_client          VARCHAR(9) NULL,
	email_client         VARCHAR(80) NULL,
	est_cli				 Varchar(2) null
);



ALTER TABLE Clientes
ADD PRIMARY KEY (cod_cliente);



CREATE TABLE Productos
(
	cod_productos        INTEGER IDENTITY(1,1) NOT NULL,
	nom_product          VARCHAR(50) NULL,
	costo_product        DECIMAL(8,2) NULL,
	peso_product         VARCHAR(50) NULL,
	est_prod			 VARCHAR(2) NULL
);



ALTER TABLE Productos
ADD PRIMARY KEY (cod_productos);



CREATE TABLE Usuarios
(
	cod_us               INTEGER IDENTITY(1,1) NOT NULL,
	usuario              VARCHAR(50) NULL,
	nombres              VARCHAR(255) NULL,
	pwd_us               VARCHAR(10) NULL,
	nivel              INT NULL
);

ALTER TABLE Usuarios
ADD PRIMARY KEY (cod_us);



CREATE TABLE Ventas
(
	cod_ventas           INTEGER IDENTITY(1,1) NOT NULL,
	cod_cliente          INTEGER NULL,
	cod_productos        INTEGER NULL,
	fch_venta            DATE NULL,
	cod_us               INTEGER NULL,
	total_venta          DECIMAL(8,2) NULL
);



ALTER TABLE Ventas
ADD PRIMARY KEY (cod_ventas);


CREATE TABLE Almacen
(
	cod_al               INTEGER identity (1,1) NOT NULL,
	cantida_ini           integer NULL,
	cod_productos        INTEGER NULL,
	cantidad_fin           INTEGER NULL,
	total_can				integer null
);



ALTER TABLE Almacen
ADD PRIMARY KEY (cod_al);



/*
ALTER TABLE Ventas
ADD FOREIGN KEY R_1 (cod_cliente) REFERENCES Clientes (cod_cliente);



ALTER TABLE Ventas
ADD FOREIGN KEY R_2 (cod_productos) REFERENCES Productos (cod_productos);



ALTER TABLE Ventas
ADD FOREIGN KEY R_3 (cod_us) REFERENCES Usuarios (cod_us);
*/