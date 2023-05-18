create database movie;

use movie;

create table users(id int auto_increment not null, userName varchar(100) not null, userPassword varchar(100)
 not null, userEmail varchar(100) not null,
 userContact int not null
 , primary key(id));
 
 select * from users;
 
 create table admin(id int auto_increment not null, adminName varchar(100) not null, adminPassword varchar(100)
 not null, adminEmail varchar(100) not null, adminContact int not null
 ,primary key(id));
 
 select * from admin;
 
 create table movie(id int auto_increment not null, movieName varchar(100) not null, movieDescription varchar(255)
 , ticketValue int not null, primary key(id));