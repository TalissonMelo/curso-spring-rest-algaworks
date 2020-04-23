create table comments (
	id bigint not null auto_increment,
	order_of_service_id bigint not null,
	description varchar(80) not null,
	date_send datetime,
	primary key (id)
);

alter table comments add constraint fk_comments_order_of_service
foreign key (order_of_service_id) references order_of_service (id);