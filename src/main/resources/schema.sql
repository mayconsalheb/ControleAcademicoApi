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

