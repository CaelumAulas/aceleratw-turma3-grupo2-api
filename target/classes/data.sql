DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vehicles;
DROP TABLE IF EXISTS brands;

create table users( user_id serial primary key,
name VARCHAR(255) not null,
password VARCHAR(50) not null );


INSERT INTO users("name", "password")
VALUES ('bianca', '123'),
('ingrid', '123'),
('luiza', '123'),
('ronaldo', '123'),
('wendel', '123');

CREATE TABLE brands(
   brand_id serial primary key,
   name VARCHAR(255) not null
);

insert into brands("name")
values ('marca 1'),
('marca 2'),
('marca 3');

CREATE TABLE vehicles(
   vehicle_id serial not null,
   brand_id serial not null,
   user_id serial not null,
   model VARCHAR(255) not null,
   year INT not null,
   price decimal not null,

   primary key(vehicle_id),
constraint fk_brand foreign key(brand_id) references brands(brand_id),
constraint fk_user foreign key(user_id) references users(user_id) );

insert into vehicles("brand_id", "user_id", "model", "year", "price")
values ('1', '1', 'modelo 1', 2010, 10000.00),
('2', '2', 'modelo 2', 2011, 20000.00),
('3', '3', 'modelo 3', 2012, 30000.00);


select * from users;
select * from brands;
select * from vehicles;


