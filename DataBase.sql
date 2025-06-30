create database MrShima;
use MrShima;
-- drop database MrShima;
create table tejedora(
	ID int 		primary key 	not null 	auto_increment,
    modelo varchar(50) not null,
    galga varchar(50) not null,
    precio double(10, 2) not null,
    serie varchar(100) not null,
    sucursal varchar(100) not null,
    estado bool not null, 
    credito double(10, 2),
    propietario varchar(150) not null,
	cabezas int not null, 
    anio int
);
create table Bordadora(
	ID int 		primary key 	not null  auto_increment,
    precio double(10, 2) not null,
    credito double(10, 2),
    accesorios varchar(150),
    anio int,
    area varchar(8) not null, 
    colores int not null,
    cabezas int not null, 
    marca varchar(100) not null,
    numero_serie varchar(100) not null, 
    estado bool not null, 
    saldo double(10, 2), 
    propietario varchar(150) not null
);
create table inventario_A(
	ID int 		primary key 	not null  auto_increment,
    nombre   varchar(100) not null,
    precio double(10, 2) not null,
    credito double(10, 2),
    Maquinas varchar(100), 
    galga_men int,
    galga_mayor int,
    nivel int,
    cantida int not null,
    estado bool not null,
    tamano varchar(8)
);

create table invetario_b(
	ID int 		primary key 	not null  auto_increment,
    etiqueta  varchar(50), 
    cantidad int 	not null, 
    precio double(10,2) not null,
    credito double(10, 2),
    descripcion text not null,
    maquinas varchar(100), 
	galga_men int,
    galga_mayor int,
    nivel int, 
    estado bool not null,
    unidad  varchar(50) check (unidad in ('litros', 'kilos', 'metros', 'piezas'))
);

INSERT INTO tejedora (modelo,galga,precio,serie, sucursal,estado,credito,propietario,cabezas, anio) 
VALUES ('HOLA','galaga',10.0,'aguna','mi casa',true,11.0,'yo',10,2000);
