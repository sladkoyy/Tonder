insert into tonder.profile
values (nextval('tonder.profile_id_seq'), 'Admin', 'Profile', '20', 'm', 'Красивый адмен'),
       (nextval('tonder.profile_id_seq'), 'User', 'Profile', '16', 'f', 'Красивый юзер');

insert into tonder.user
values (nextval('tonder.user_id_seq'), 'admin', 'admin', 1),
       (nextval('tonder.user_id_seq'), 'user', 'user', 2);

insert into tonder.user_role
values (nextval('tonder.user_role_id_seq'), 1, 1),
       (nextval('tonder.user_role_id_seq'), 2, 2);
