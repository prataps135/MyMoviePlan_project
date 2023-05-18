create database movie;

use movie;

drop table users;
drop table admin;

create table users(id int auto_increment not null, userName varchar(100) not null, userPassword varchar(100)
 not null, userEmail varchar(100) not null,
 userContact varchar(100) not null
 , primary key(id));
 
 select * from users;
 
 create table admin(id int auto_increment not null, adminName varchar(100) not null, adminPassword varchar(100)
 not null, adminEmail varchar(100) not null, adminContact varchar(100) not null
 ,primary key(id));
 
 select * from admin;
 
 create table movie(id int auto_increment not null, movieName varchar(100) not null, movieDescription varchar(255)
 , ticketValue int not null, primary key(id));