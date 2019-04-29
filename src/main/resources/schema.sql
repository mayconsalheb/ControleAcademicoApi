CREATE TABLE TB_USER (
  id		integer PRIMARY KEY,
  name 		VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE TB_ROLE (
  id		integer PRIMARY KEY,
  name 		VARCHAR(255) NOT NULL
);

CREATE TABLE RL_USER_ROLE (
  id_user		integer,
  id_role		integer,
  PRIMARY KEY(id_user, id_role)
);

CREATE TABLE TB_MATRICULA_ONLINE (
  id		integer PRIMARY KEY,
  cpf		VARCHAR(11) NOT NULL,
  nome		VARCHAR(255) NOT NULL,
  idade		integer NOT NULL,
  id_curso integer NOT NULL,
  email		VARCHAR(255) NOT NULL
);

CREATE TABLE TB_MATRICULA (
  id		integer PRIMARY KEY,
  cpf		VARCHAR(11) NOT NULL,
  nome		VARCHAR(255) NOT NULL,
  idade		integer NOT NULL,
  id_curso  integer NOT NULL,
  email		VARCHAR(255) NOT NULL,
  st_ativo   boolean NOT NULL
);

