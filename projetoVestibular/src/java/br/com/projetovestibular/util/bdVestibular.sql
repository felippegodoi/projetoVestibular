create table cargo
(
	id_cargo SERIAL NOT NULL,
	nome_cargo VARCHAR(30) NOT NULL,
	CONSTRAINT pk_id_cargo PRIMARY KEY (id_cargo)
)

create table email
(
	id_email SERIAL NOT NULL,
	nome_email VARCHAR(40) NOT NULL,
	data_fim_email DATE NOT NULL,
	motivo_email VARCHAR(20) NOT NULL,
	CONSTRAINT pk_id_email PRIMARY KEY (id_email)
)

create table telefone
(
	id_telefone SERIAL NOT NULL,
	numero_telefone VARCHAR(30) NOT NULL,
	data_fim_telefone DATE NOT NULL,
	motivo_telefone VARCHAR(30) NOT NULL,
	CONSTRAINT pk_id_telefone PRIMARY KEY (id_telefone)
)

create table cep
(
	id_cep SERIAL NOT NULL,
	nome_cep VARCHAR(30) NOT NULL,
	CONSTRAINT pk_id_cep PRIMARY KEY (id_cep)
)

create table estado
(
	id_estado SERIAL NOT NULL,
	nome_estado VARCHAR(50) NOT NULL,
	nome_uf VARCHAR(5) NOT NULL,
	CONSTRAINT pk_id_estado PRIMARY KEY (id_estado)
)

create table cidade
(
	id_cidade SERIAL NOT NULL,
	nome_cidade VARCHAR(50) NOT NULL,
	id_estado INTEGER NOT NULL,
	CONSTRAINT pk_id_cidade PRIMARY KEY (id_cidade),
	CONSTRAINT fk_id_estado FOREIGN KEY (id_estado) references estado
	
)

create table candidato
(
	id_candidato SERIAL NOT NULL,
	status_candidato VARCHAR(30) NOT NULL,
	motivo_candidato VARCHAR(40) NOT NULL,
	id_pessoa INTEGER NOT NULL,
	CONSTRAINT pk_id_candidato PRIMARY KEY (id_candidato),
	CONSTRAINT fk_id_pessoa FOREIGN KEY (id_pessoa) references pessoa
	
)

create table pessoa
(
	id_pessoa SERIAL NOT NULL,
	nome_pessoa VARCHAR(50) NOT NULL,
	cpf_pessoa VARCHAR(20) NOT NULL,
	rg_pessoa VARCHAR(20) NOT NULL,
	endereco_pessoa VARCHAR(50) NOT NULL,
	numero_endereco_pessoa VARCHAR(10),
	bairro_endereco_pessoa VARCHAR(25) NOT NULL,
	motivo_pessoa VARCHAR(20) NOT NULL,
	data_fim_pessoa DATE NOT NULL,
	observacao_pessoa VARCHAR(20) NOT NULL,
	id_email INTEGER NOT NULL,
	id_cep INTEGER NOT NULL,
	id_cidade INTEGER NOT NULL,
	id_telefone INTEGER NOT NULL,
	CONSTRAINT pk_id_pessoa PRIMARY KEY (id_pessoa),
	CONSTRAINT fk_id_email FOREIGN KEY (id_email) references email,
	CONSTRAINT fk_id_cep FOREIGN KEY (id_cep) references cep,
	CONSTRAINT fk_id_cidade FOREIGN KEY (id_cidade) references cidade,
	CONSTRAINT fk_id_telefone FOREIGN KEY (id_telefone) references telefone

)

create table funcionario
(
	id_funcionario SERIAL NOT NULL,
	matricula_funcionario VARCHAR(30) NOT NULL,
	login_funcionario VARCHAR(20) NOT NULL,
	senha_funcionario VARCHAR(20) NOT NULL,
	id_pessoa INTEGER NOT NULL,
	id_cargo INTEGER NOT NULL,
	CONSTRAINT pk_id_funcionario PRIMARY KEY (id_funcionario),
	CONSTRAINT fk_id_pessoa FOREIGN KEY (id_pessoa) references pessoa,
	CONSTRAINT fk_id_cargo FOREIGN KEY (id_cargo) references cargo

)


create table contato
(
	id_contato SERIAL NOT NULL,
	data_contato DATE NOT NULL,
	hora_contato TIME NOT NULL,
	assunto_contato VARCHAR(100) NOT NULL, 
	id_funcionario INTEGER NOT NULL,
	id_candidato INTEGER NOT NULL,
	CONSTRAINT pk_id_contato PRIMARY KEY (id_contato),
	CONSTRAINT fk_id_funcionario FOREIGN KEY (id_funcionario) references funcionario,
	CONSTRAINT fk_id_candidato FOREIGN KEY (id_candidato) references candidato
	
)

select * from cargo
select * from cep
select * from email
select * from telefone
select * from estado
select * from cidade
select * from funcionario
select * from candidato
select * from pessoa
select * from contato

drop table cargo
drop table cep
drop table email
drop table telefone
drop table estado
drop table cidade
drop table funcionario;
drop table candidato;
drop table pessoa
drop table contato;



