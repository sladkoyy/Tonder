create table tonder.profile
(
	id          serial primary key,
	first_name  varchar not null,
	last_name   varchar not null,
	age         int not null,
	gender      char(1) not null,
	info        varchar not null
);

create table tonder.user
(
	id          serial primary key,
	username    varchar not null,
	password    varchar not null,
	profile_id  int,
	foreign key (profile_id) references tonder.profile (id),
	created_at  timestamptz not null default now()
);

create unique index user_username_uniq_idx on tonder.user (username);
