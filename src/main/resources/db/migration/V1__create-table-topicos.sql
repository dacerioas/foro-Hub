create table topicos(

 id bigint not null auto_increment,
 activo tinyint,
 titulo varchar(100) not null,
 mensaje text not null,
 fecha_creacion datetime not null,
 status varchar(20) not null,

 nombre_autor varchar(100) not null,
 email varchar(100) not null,

 nombre_curso varchar(100) not null,
 categoria varchar(100) not null,

 primary key(id)

);