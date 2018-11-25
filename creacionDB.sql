CREATE TABLE Cliente(
nombre varchar(40),
apellido varchar(40),
email varchar(70),
dni varchar(10) not null,
domicilio varchar(70),
localidad varchar(50),
codigoPostal varchar(7),
estado bit,
PRIMARY KEY(dni)
)

CREATE TABLE Boleta(
idBoleta int identity (1,1),
dniCliente varchar(10) not null,
total real not null,
seña real,
fecha date,
estado char, --Pendiente, Lista, Entregada
PRIMARY KEY(idBoleta),
CONSTRAINT fk_clienteB FOREIGN KEY(dniCliente) REFERENCES Cliente(dni)
)

CREATE TABLE Arreglo(
idArreglo int IDENTITY(1,1), --se lo pasó como parámetro
nombre varchar(40) not null,
descripcion varchar(70),
costoArreglo real not null,
PRIMARY KEY(idArreglo)
)

CREATE TABLE Empleado(
nombre varchar(40),
apellido varchar(40),
dni varchar(10) not null,
cuil varchar(15) not null,
domicilio varchar(70),
localidad varchar(50),
telefono varchar(15),
estado bit,
PRIMARY KEY(cuil)
)

CREATE TABLE Calzado(
codigoCalzado varchar(15) not null,
costoCalzado real,
cuilEmpleado varchar(15) not null,
categoria varchar(5), --B, Z, ZH, ZM 
estado char, -- P(pendiente), L(listo), E(entregado)
PRIMARY KEY(codigoCalzado),
CONSTRAINT fk_empleadoC FOREIGN KEY(cuilEmpleado) REFERENCES Empleado(cuil)
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
