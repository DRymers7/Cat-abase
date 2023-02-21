DROP TABLE IF EXISTS cat, dog CASCADE;

CREATE TABLE cat (
    id int auto_increment not null,
    breed varchar(64) not null
);

CREATE TABLE dog (
    id int auto_increment not null,
    breed varchar(64) not null
);

