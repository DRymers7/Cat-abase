BEGIN TRANSACTION;

DROP TABLE IF EXISTS CASCADE;
DROP SEQUENCE IF EXISTS CASCADE;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE users (

user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
user_email varchar(255) NOT NULL UNIQUE,
password_hash varchar(200) NOT NULL,
role varchar(50) NOT NULL,

CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE user_information (
	
);

CREATE TABLE user_pet_preferences (

);

CREATE TABLE user_financial_preferences (

);

CREATE TABLE user_household_data (

);

