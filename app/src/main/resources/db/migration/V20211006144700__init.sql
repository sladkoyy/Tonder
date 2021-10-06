create table tonder.profile
(
	id          serial primary key,
	first_name  varchar not null,
	last_name   varchar not null,
	age         int not null,
	gender      char(1) not null,
	info        varchar not null,
	created_at  timestamptz not null default now()
);

create table tonder.user
(
	id          serial primary key,
	username    varchar not null unique,
	password    varchar not null,
	profile_id  int not null,
	foreign key (profile_id) references tonder.profile (id),
	created_at  timestamptz not null default now()
);

create table tonder.choice
(
	id          serial primary key,
	profile_id  int not null references tonder.profile (id),
	choice      bool not null,
	user_id     int not null,
	foreign key (user_id) references tonder.user (id),
	created_at  timestamptz not null default now()
);