CREATE TABLE POKEMON_SPEC (
  INDEX_NUMBER INTEGER PRIMARY KEY,
  NAME VARCHAR (50),
  HP INTEGER,
  ATTACK INTEGER,
  DEFENSE INTEGER,
  SPECIAL_ATTACK INTEGER,
  SPECIAL_DEFENSE INTEGER,
  SPEED INTEGER
);

CREATE TABLE TRAINER (
  TRAINER_ID INTEGER PRIMARY KEY,
  NAME VARCHAR (50)
);

CREATE TABLE POKEMON (
  POKEMON_ID INTEGER PRIMARY KEY,
  INDEX_NUMBER INTEGER,
  BIRTH_DATE DATE,
  LEVEL INTEGER,
  TRAINER_ID INTEGER,
);