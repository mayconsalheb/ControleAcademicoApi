insert into TB_USER (id, name, password) VALUES
(1, 'joao', '$2a$10$h3m/QiY7PxEa4nhoTevoceJlqOKtcD/tUPb9Rjf05HBypZBeWl0X.');
insert into TB_USER (id, name, password) VALUES
(2, 'flavio', '$2a$10$h3m/QiY7PxEa4nhoTevoceJlqOKtcD/tUPb9Rjf05HBypZBeWl0X.');

insert into TB_ROLE (id, name) VALUES
(1, 'ADMIN');
insert into TB_ROLE (id, name) VALUES
(2, 'DIRECTOR');

insert into RL_USER_ROLE (id_user, id_role) VALUES
(1,2);
insert into RL_USER_ROLE (id_user, id_role) VALUES
(2,1);
insert into RL_USER_ROLE (id_user, id_role) VALUES
(2,2);