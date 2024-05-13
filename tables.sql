//registration
create table user(
username        varchar(30) unique not null,  
name			varchar(100) not null,  
email			varchar(50) not null,
mobile			varchar(20) not null,
address         varchar(100)    not null,
role			varchar(10) not null,
pw      		varchar(30) not null,
);
//paper
create table paper(
id              int(10)     primary key     not null    auto_increment,    
title			varchar(50) not null,
category		varchar(30) not null,
name            varchar(50) not null,
username        varchar(30) not null,
paper           varchar(200)
);