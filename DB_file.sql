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
 
 create table movie(id int auto_increment not null, movieName varchar(100) not null, 
 movieDescription varchar(255),genre varchar(100), ticketValue int not null, 
 primary key(id));
 
 
 
 create table movie_resource(resourceCode varchar(100) not null, resourceDetail varchar(100) not null);

select *from movie_resource;

insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Action');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Adventure');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Animated');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Comedy');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Crime');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Drama');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Horror');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Mystery');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Romance');
insert into movie_resource(resourceCode, resourceDetail) values ('genre', 'Science Fiction');
insert into movie_resource(resourceCode, resourceDetail) values ('genre','Thriller');
 
 