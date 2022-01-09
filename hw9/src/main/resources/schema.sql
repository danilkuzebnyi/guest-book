create table customer
(
    id           serial      not null
        constraint customer_pk
            primary key,
    "first_name" varchar(30) not null,
    "last_name"  varchar(30) not null,
    "cell_phone" varchar(15) not null
);

create unique index "customer_cell phone_uindex"
    on customer (cell_phone);

create unique index customer_id_uindex
    on customer (id);


create table product
(
    id              serial       not null
        constraint product_pk
            primary key,
    name            varchar(100) not null,
    description     varchar,
    "current_price" float        not null
);

create unique index product_id_uindex
    on product (id);


create table "booking"
(
    id                serial  not null
        constraint order_pk
            primary key,
    customer_id       INTEGER not null REFERENCES customer (id),
    product_id        INTEGER not null REFERENCES product (id),
    "qty_of_products" INTEGER not null,
    "delivery_place"  varchar not null
);
