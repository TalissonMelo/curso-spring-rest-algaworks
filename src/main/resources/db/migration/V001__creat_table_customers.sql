create table customers(
	id bigint not null auto_increment,
	name varchar(80) not null,
	email varchar(60) not null,
	phone varchar(20) not null,
	primary key (id)
)