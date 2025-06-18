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
    FOREIGN KEY (id) REFERENCES USERS(id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE do_times (
    do_time_id INT AUTO_INCREMENT PRIMARY KEY,
    id INT NOT NULL,
    date DATE NOT NULL,
    exercise_do DOUBLE NOT NULL,
    study_do DOUBLE NOT NULL,
    sleep_do DOUBLE NOT NULL,
    FOREIGN KEY (id) REFERENCES USERS(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE (id, date)
);

create table todo_lists(
    todo_list_id int AUTO_INCREMENT primary key,
    id int not null,
    list_content varchar(30) not null,
    checkbox boolean default false,
     FOREIGN KEY (id) REFERENCES USERS(id) ON DELETE CASCADE ON UPDATE CASCADE
);


create table results(
    result_id int AUTO_INCREMENT primary key,
    id int not null,
    day_toward double not null,
    feedback varchar(50) not null,
    do_time_id int,
    FOREIGN KEY (id) REFERENCES USERS(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (do_time_id) REFERENCES do_times(do_time_id) ON DELETE CASCADE ON UPDATE CASCADE
);


