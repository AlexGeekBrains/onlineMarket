CREATE TABLE products (
    id bigserial  PRIMARY KEY,
    title         VARCHAR(255),
    cost          INT
                      );

INSERT INTO products (title, cost)
VALUES ('Milk', 150),
       ('Potatoes', 80),
       ('Eggs', 90),
       ('Pancake', 75),
       ('Paper', 150),
       ('Oil', 50),
       ('Salt', 10),
       ('Pineapple', 200),
       ('Watermelon', 175),
       ('Candy', 87);

create table users (
     id bigserial  PRIMARY KEY,
     username      varchar(30) not null unique,
     password      varchar(80) not null,
     email         varchar(50) unique,
     created_at    timestamp default current_timestamp,
     updated_at    timestamp default current_timestamp
                   );

create table roles (
     id bigserial  PRIMARY KEY,
     name          varchar(50) not null,
     created_at    timestamp default current_timestamp,
     updated_at    timestamp default current_timestamp
                   );

CREATE TABLE users_roles (
      user_id      bigint not null,
      role_id      bigint not null,
      primary key  (user_id, role_id),
      foreign key  (user_id) references users (id),
      foreign key  (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$10$d9SaYo0LnMh2zp3rhuVTqOIGRnBy3VSMxnXpCopIPvBlMaxtoWBOu', 'user@gmail.com'),
       ('admin', '$2a$10$d9SaYo0LnMh2zp3rhuVTqOIGRnBy3VSMxnXpCopIPvBlMaxtoWBOu', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values
    (1, 1),
    (2, 1),
    (2, 2);