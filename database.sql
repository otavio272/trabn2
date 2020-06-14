
create table Conta ( 
	id int,
	idPagador int,
	NomeConta varchar(255),
	valor int,
	primary key(id)
);


create table Pessoa (
	id int,
	nome varchar(50),
	idade int,
	primary key(id)
);