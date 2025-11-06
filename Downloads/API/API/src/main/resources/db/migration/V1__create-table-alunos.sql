CREATE TABLE ALUNOS (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    data_nascimento varchar(100) not null,
    sexo varchar(100) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    estado varchar(100) not null,
    objetivo varchar(100) not null,
    telefone varchar (100),

    primary key (id)
);