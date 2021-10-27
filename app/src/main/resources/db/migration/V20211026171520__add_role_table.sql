create table tonder.role
(
    id   int primary key,
    code varchar not null
);

insert into tonder.role
values (1, 'admin'),
       (2, 'user');

create table tonder.user_role
(
    id      serial primary key,
    user_id int not null references tonder.user (id),
    role_id int not null references tonder.role (id)
);