create table estoque(
	id bigint AUTO_INCREMENT,
    nome varchar(60),
    endereco varchar(80),
    categoria varchar(60),
    CNPJ varchar(15),
    
    primary key(id) 
);

create table produto(
	id bigint AUTO_INCREMENT,
    nome varchar(60),
    preco double,
    quantidade int,
    fornecedor varchar(60),
    
    primary key(id)
);

create table fornecedor(
	id bigint AUTO_INCREMENT,
    nome varchar(60),
    endereco varchar(80),
    email varchar(60),
    telefone varchar(15),
    cnpj varchar(15),
    
    primary key(id)
);