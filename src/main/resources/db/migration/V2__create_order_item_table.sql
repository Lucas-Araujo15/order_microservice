CREATE TABLE order_item (
    id bigint(20) not null AUTO_INCREMENT,
    description varchar(255) default null,
    quantity int(11) not null,
    order_id bigint(20) not null,
    primary key (id),
    foreign key (order_id) references orders(id)
)