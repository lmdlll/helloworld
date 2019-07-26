
create database if not exists `tangshi`;
use `tangshi`;
create table if not exists `poerty`(
  title varchar(64) not null,
  dynasty varchar(32) not null ,
  author varchar (20) not null ,
  content varchar (1024) not null
);




