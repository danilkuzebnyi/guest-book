CREATE TABLE cat
(
    id   SERIAL      not null
        constraint cat_pk
            primary key,
    name varchar(50) not null,
    age  int         not null
);

create table "user"
(
    id             SERIAL      not null
        constraint user_pk
            primary key,
    name           varchar(50) not null,
    age            INTEGER     not null,
    admin          BOOLEAN     not null,
    balance        DOUBLE PRECISION,
    "creationDate" DATE
);