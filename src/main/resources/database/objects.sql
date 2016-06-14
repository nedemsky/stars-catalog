DROP TABLE IF EXISTS discoverer;
DROP TABLE IF EXISTS star;



create table discoverer (
	name varchar(50)  not null, 
	constraint pk_discoverer primary key (name)
	);


create table star (
    id serial,
    name varchar(25) not null,
    altitude varchar(25)  not null,
    longitude varchar(25)  not null,
    clazz varchar(5) not null,
    discoverer varchar(50)  not null, 
    constraint pk_star primary key (name)
);



