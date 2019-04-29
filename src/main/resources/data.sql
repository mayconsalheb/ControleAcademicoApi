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

insert into TB_MATRICULA (id,cpf,nome,idade,id_curso ,email,st_ativo)
VALUES (1,'67240205061', 'Victor Dias', 18, 3,'victordias@gmail.com',true);

insert into TB_MATRICULA (id,cpf,nome,idade, id_curso ,email,st_ativo)
VALUES (2,'32303994047', 'Carlos T', 20, 1,'carlost@gmail.com',true);

insert into TB_MATRICULA (id,cpf,nome,idade, id_curso ,email,st_ativo)
VALUES (3,'78513359068', 'Renata Santos', 25, 2,'renatasantos@gmail.com',true);
