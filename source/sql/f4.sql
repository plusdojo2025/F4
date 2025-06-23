create database f4;
use f4;


create table users(
    id int auto_increment primary key,
    user_name varchar(20) not null,
    mail varchar(50) unique not null,
    pw varchar(20) not null
);


create table goals(
    goals_id int AUTO_INCREMENT primary key,
    id int not null,
    exercise_goal double not null,
    study_goal double not null,
    sleep_goal double not null,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE do_times (
    do_time_id INT AUTO_INCREMENT PRIMARY KEY,
    id INT NOT NULL,
    date DATE NOT NULL,
    exercise_do DOUBLE NOT NULL,
    study_do DOUBLE NOT NULL,
    sleep_do DOUBLE NOT NULL,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE (id, date)
);

create table todo_lists(
    todo_list_id int AUTO_INCREMENT primary key,
    id int not null,
    list_content varchar(30) not null,
    checkbox boolean default false,
     FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);


create table results(
    result_id int AUTO_INCREMENT primary key,
    id int not null,
    day_toward double not null,
    feedback varchar(70) not null,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into users values(0, 'dojouser1', 'dojouser1@plusdojo.jp', '#SEplus2025SEplus');

insert into users values(0, 'dojouser2', 'dojouser2@plusdojo.jp', '#SEplus2025SEplus');

insert into users values(0, 'new', 'new@jp', 'test');

insert into users values(0, 'week', 'week@jp', 'test');
insert into goals values(0, 4, 1, 2, 6);
insert into do_times values(0, 4, '2025-06-17', 1, 2, 6);
insert into do_times values(0, 4, '2025-06-18', 1, 2, 6);
insert into do_times values(0, 4, '2025-06-19', 1, 2, 6);
insert into do_times values(0, 4, '2025-06-20', 1, 2, 6);
insert into do_times values(0, 4, '2025-06-21', 1, 2, 6);
insert into do_times values(0, 4, '2025-06-22', 1, 2, 6);

insert into users values(0, '8day', '8day@jp', 'test');
insert into goals values(0, 5, 1, 2, 6);
insert into do_times values(0, 5, '2025-06-16', 1, 2, 6);