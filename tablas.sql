
use SARA

CREATE TABLE Cliente(
idCliente int identity (1,1),
nombre varchar(40),
apellido varchar(40),
email varchar(70),
dni varchar(10) not null,
domicilio varchar(70),
localidad varchar(50),
codigoPostal varchar(7),
estado bit DEFAULT 1,
PRIMARY KEY(idCliente),
CONSTRAINT dni_unico UNIQUE (dni)
)

CREATE TABLE Boleta(
idBoleta int identity (1,1),
idCliente int not null,
total real not null,
seña real,
fecha date,
estadoRetiro char DEFAULT 'P',--P=Pendiente L=Listo E=Entregado 
estado bit DEFAULT 1, --Para el borrado logico
PRIMARY KEY(idBoleta),
CONSTRAINT fk_clienteB FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
)

CREATE TABLE Arreglo(
idArreglo int IDENTITY(1,1),
nombre varchar(40) not null,
descripcion varchar(70),
costoArreglo real not null,
estado bit DEFAULT 1,
PRIMARY KEY(idArreglo),
CONSTRAINT nombre_unico UNIQUE (nombre)
)

CREATE TABLE Empleado(
idEmpleado int identity(1,1),
nombre varchar(40),
apellido varchar(40),
dni varchar(10) not null,
cuil varchar(15) not null,
domicilio varchar(70),
localidad varchar(50),
telefono varchar(15),
estado bit DEFAULT 1,
PRIMARY KEY(idEmpleado),
CONSTRAINT dni_cuil_unico UNIQUE (dni,cuil)
)

CREATE TABLE Calzado(
codigoCalzado varchar(15) not null,
costoCalzado real,
idEmpleado int not null,
--categoria varchar(5), --B, Z, ZH, ZM 
estado char DEFAULT 'P', -- P(pendiente), L(listo), E(entregado)
PRIMARY KEY(codigoCalzado),
CONSTRAINT fk_empleadoC FOREIGN KEY(idEmpleado) REFERENCES Empleado(idEmpleado)
)

CREATE TABLE BoletaCalzado(
idBoleta int not null,
codigoCalzado varchar(15) not null,
PRIMARY KEY(idBoleta, codigoCalzado),
CONSTRAINT fk_boletaBC FOREIGN KEY(idBoleta) REFERENCES Boleta(idBoleta),
CONSTRAINT fk_calzadoBC FOREIGN KEY(codigoCalzado) REFERENCES Calzado(codigoCalzado)
)

CREATE TABLE ArregloCalzado(
idArreglo int not null,
codigoCalzado varchar(15) not null,
PRIMARY KEY(idArreglo, codigoCalzado),
CONSTRAINT fk_arregloAC FOREIGN KEY(idArreglo) REFERENCES Arreglo(idArreglo),
CONSTRAINT fk_calzadoAC FOREIGN KEY(codigoCalzado) REFERENCES Calzado(codigoCalzado)
)
