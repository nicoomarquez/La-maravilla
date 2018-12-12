
/*************************************
*	Insercion de registros en tablas *
**************************************/

insert into SARA.dbo.Arreglo (nombre,descripcion,costoArreglo) values 
('Fondo Goma','',100.0),
('1/2 Suela','',50),
('1/2 Goma','',50),
('Cambio de Taco','',200),
('Tapitas Suela','',100),
('Taco de goma','',80),
('Plantilla','',200),
('Limpieza','',100),
('Tapitas plastico','',50),
('Soportes','',100),
('Cambrillones','',200),
('Cierres','',90),
('Pegado Completo','',200),
('Puntera','',200),
('Horna','',200),
('Teñidas','',90),
('Parches','',100),
('Taloneras','',100);


insert into Sara.dbo.Empleado values
('Nico','Marquez','1','1','domicilio 1','localidad 1','47552265',1),
('Nico','Ragusa','2','2','domicilio 2','localidad 2','47998825',1),
('Santi','Mamani','3','3','domicilio 3','localidad 1','47976521',1),
('Conra','Navarro','4','4','domicilio 4','localidad 2','47551145',1);


insert into Sara.dbo.Cliente values
('Ester','Maldonado','doñaester@','111','calle 1','Localidad 1','1540',1),
('Juan Carlos','Thompson','jThompson@','222','calle 5','Localidad 10','1607',1),
('Gabriel','Nieva','g.nieva@','333','calle 5','Localidad 10','1607',1),
('Gabriel','Montes','g.montes@','444','calle 1','Localidad 1','1540',1);

insert into Sara.dbo.Calzado  (codigoCalzado, costoCalzado,idEmpleado,estado) values 
('ZM001',200,1,'P'), 
('ZH002',300,2,'P');

insert into Sara.dbo.ArregloCalzado values 
(1,'ZM001'),
(2,'ZM001'),
(3,'ZM001'), 
(4,'ZH002'),
(2,'ZH002'),
(9,'ZH002');

insert into Sara.dbo.Boleta (idCliente, total,seña, fecha) values ('1',500,200,'12-8-2018');

insert into Sara.dbo.BoletaCalzado VALUES
 (1,'ZM001'),
 (1,'ZH002');
/*******************************************************************
*	Drops tables ordenado de mayor dependencia a menor dependencia *
********************************************************************/

drop table sara.dbo.ArregloCalzado
drop table sara.dbo.BoletaCalzado
drop table sara.dbo.Arreglo
drop table sara.dbo.Calzado
drop table sara.dbo.Empleado
drop table sara.dbo.Boleta
drop table sara.dbo.Cliente


/***************************
*	Seleccion de registros *
****************************/

select * from sara.dbo.ArregloCalzado
select * from sara.dbo.BoletaCalzado
select * from sara.dbo.Arreglo
select * from sara.dbo.Calzado
select * from sara.dbo.Empleado
select * from sara.dbo.Boleta
select * from sara.dbo.Cliente
