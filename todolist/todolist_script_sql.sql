-- todolist --
create database todolist;
use todolist;

create table Tasks(
	task_id int auto_increment primary key not null,
    task_name varchar(55) not null,
    types varchar(55),
    active boolean default false,
    create_at date
);
insert into Tasks(task_name, types, create_at, active) values ("house", "house", "2024-04-17", true);

truncate table Tasks;

alter table Tasks drop column name;
alter table Tasks add column task_id int auto_increment  primary key not null;
alter table Tasks add column task_name varchar(55);
drop table Tasks;

select task_name from Tasks;
