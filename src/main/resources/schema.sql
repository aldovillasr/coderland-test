 create table car (
       id bigint not null,
        brand varchar(255),
		model varchar(255),
		maximum_speed integer,
        engine double not null,
        features varchar(255),
        launch_date timestamp,
        primary key (id)
    );
