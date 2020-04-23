create table order_of_service (
	id bigint not null auto_increment,
	customers_id bigint not null,
	description varchar(80) not null,
	price decimal(10,2) not null,
	status varchar(20) not null,
	date_open datetime not null,
	date_finished datetime,
	primary key (id)
);

alter table order_of_service add constraint fk_order_of_service_customers
foreign key (customers_id) references customers (id);