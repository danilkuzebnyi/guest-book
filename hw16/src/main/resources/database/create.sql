create table books
(
    id      serial
        constraint books_pk
            primary key,
    name    varchar(255) not null,
    message varchar(255) not null,
    rating  int          not null
);