
-- setup user, project and tasks --
insert into user (email, password_encrypted) values ('kbalante@gmail.com', 'kakarat');
insert into project (name, project_key, is_private, owner_user_id) values ('BlueCloud Application Development','blue',false, 1);
insert into project (name, project_key, is_private, owner_user_id) values ('Shaw.ca Commerce','shaw',false, 1);
insert into project (name, project_key, is_private, owner_user_id) values ('Encana ','enca',false, 1);
insert into project (name, project_key, is_private, owner_user_id) values ('Wiles Jackson','wja',false, 1);
insert into project (name, project_key, is_private, owner_user_id) values ('WestJet CMS','cms',false, 1);

insert into task (project_id, summary) values (1,'summary test 1');
insert into task (project_id, summary) values (1,'summary test 2');
insert into task (project_id, summary) values (1,'summary test 3');
insert into task (project_id, summary) values (1,'summary test 4');

insert into task (project_id, summary) values (6,'summary test 1');
insert into task (project_id, summary) values (6,'summary test 2');
insert into task (project_id, summary) values (3,'summary test 3');
insert into task (project_id, summary) values (4,'summary test 4');


insert into task (project_id, summary) values (4,'summary test 1');
insert into task (project_id, summary) values (4,'summary test 2');
insert into task (project_id, summary) values (4,'summary test 3');
insert into task (project_id, summary) values (4,'summary test 4');


insert into task (project_id, summary) values (5,'summary test 1');
insert into task (project_id, summary) values (5,'summary test 2');
insert into task (project_id, summary) values (5,'summary test 3');
insert into task (project_id, summary) values (5,'summary test 4');


insert into person (first_name, last_name) values ('Keith','Balante');
insert into person (first_name, last_name) values ('Elaine','Balante');

select * from project

delete from project where id = 2

-- select queries
-- select * from user
select * from project
select * from task
-- truncate table user;