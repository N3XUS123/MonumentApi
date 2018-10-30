drop table Authorities if exists
drop table Monument if exists
drop table User if exists
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table Authorities (id bigint not null, authority varchar(255), usuario varchar(255), primary key (id))
create table Monument (id bigint not null, ciudad varchar(255), codigoPais varchar(255), descripcion varchar(255), localizacion varchar(255), nombre varchar(255), pais varchar(255), urlImagen varchar(255), primary key (id))
create table User (USERNAME varchar(255) not null, ENABLED boolean not null, PASSWORD varchar(255) not null, primary key (USERNAME))
alter table Authorities add constraint FKoi70am0375ik34jo5jpisr5lf foreign key (usuario) references User