create table tonder.choice
(
	id              serial primary key,
	requester_id    int not null,
    foreign key     (requester_id) references tonder.profile (id),
    adresser_id     int not null,
    foreign key     (requester_id) references tonder.profile (id)
);