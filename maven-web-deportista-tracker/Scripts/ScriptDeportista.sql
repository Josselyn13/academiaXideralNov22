CREATE USER 'manager'@'localhost' IDENTIFIED BY 'manager';

GRANT ALL PRIVILEGES ON * . * TO 'manager'@'localhost'; 
 
-- drop database web_deportista_tracker; -- 
create database web_deportista_tracker;
use web_deportista_tracker;
create table deportista(
id int not null auto_increment,
nombre varchar(45) not null,
aPaterno varchar (45) not null,
aMaterno varchar (45) not null,
deporte varchar (45) not null,
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


insert into deportista values(DEFAULT,"Juan","Avila","Mota","Soccer"),
(DEFAULT,"Carolina","Lopez","Chavez","Soccer")
,(DEFAULT,"Jesus","Perez","Alvarez","Soccer")
,(DEFAULT,"Erik","Estrada","Sauza","Soccer")
,(DEFAULT,"Julio","Montes","Moreno","Soccer")
,(DEFAULT,"Erika","Delgado","Manzur","Soccer");

Select * from deportista;