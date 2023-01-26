BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_account, user_pet_preferences, user_financial_preferences, user_household_data,
category, recommendation CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_level_id, seq_category_id, seq_recommendation_id CASCADE;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_pet_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_level_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_category_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_recommendation_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE users (

	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	user_email varchar(255) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	salt varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_email UNIQUE (user_email)
);

CREATE TABLE user_account (
	
	user_id int NOT NULL,
	user_name varchar(64),
    balance decimal(13, 2) NOT NULL,
	owns_other_pets boolean,
	user_age int,
	activity_level varchar(64),
	works_from_home boolean,
	user_address varchar(255),
	user_state_province varchar(16),
	user_country varchar (16),
	
    CONSTRAINT PK_account PRIMARY KEY (user_id),
    CONSTRAINT FK_user_account FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE pet (
	
	/*
	CAN INCLUDE OTHER INFO FROM PETFINDER API FOR SMARTER RECOMMENDATIONS
	*/
	
	pet_id int DEFAULT nextval('seq_pet_id'::regclass) NOT NULL,
	pet_species varchar(64),
	pet_breed varchar(64),
	pet_spoilness varchar(255) NOT NULL,
	size_lbs int, 
	sociability varchar(64),
	indoor_outdoor varchar(64),
	good_with_other_animals boolean,
	pet_cost_month int,
	pet_cost_year int,
	pet_image TEXT,
	
	CONSTRAINT PK_pet PRIMARY KEY (pet_id)
);

CREATE TABLE user_pet_join (
	
	pet_id int NOT NULL,
	user_id int NOT NULL,
	
	CONSTRAINT PK_user_pet_join PRIMARY KEY (pet_id, user_id),
	CONSTRAINT FK_user_account_user_pet_join FOREIGN KEY (user_id) REFERENCES user_account(user_id),
	CONSTRAINT FK_pet_user_pet_join FOREIGN KEY (pet_id) REFERENCES pet(pet_id)
);

CREATE TABLE user_pet_preferences (
	
	pet_id int NOT NULL,
	level_id int DEFAULT nextval('seq_level_id'::regclass) NOT NULL UNIQUE,
	spoilness varchar(255) NOT NULL,
	size_lbs int,
	socialability varchar(64),
	indoor_outdoor varchar(64),
	good_with_other_animals boolean,

	CONSTRAINT PK_user_pet_preferences PRIMARY KEY (pet_id),
	CONSTRAINT FK_user_pet_preferences FOREIGN KEY (pet_id) REFERENCES pet(pet_id)
);

CREATE TABLE category (
	
	category_id int DEFAULT nextval('seq_category_id'::regclass) NOT NULL,
	level_id int,
	categories varchar(255),
	
	CONSTRAINT PK_category PRIMARY KEY (category_id),
	CONSTRAINT FK_category_user_pet_preferences FOREIGN KEY (level_id) REFERENCES user_pet_preferences(level_id)
);

CREATE TABLE recommendation (
	
	/*
	UNSURE OF WHAT LEVEL REPRESENTS OR HOW IT CONNECTS TO REC/category, WILL NEED A REFRESHER
	
	level_id int NOT NULL,
	category_id int NOT NULL,
	
	CONSTRAINT FK_rec_level FOREIGN KEY(level_id) REFERENCES user_pet_preferences (level_id),
    CONSTRAINT FK_rec_cate FOREIGN KEY(cate_id) REFERENCES category (category_id)
	*/
	
	recommendation_id int DEFAULT nextval('seq_recommendation_id'::regclass) NOT NULL,
	suggestions varchar(255) NOT NULL,
	
	CONSTRAINT PK_recommendation PRIMARY KEY (recommendation_id)
);

CREATE TABLE user_recommendation_join (
	
	user_id int NOT NULL,
	recommendation_id int NOT NULL,
	
	CONSTRAINT PK_user_recommendation_join PRIMARY KEY (user_id, recommendation_id),
	CONSTRAINT FK_user_recommendation_join_user_account FOREIGN KEY (user_id) REFERENCES user_account(user_id),
	CONSTRAINT FK_user_recommendation_join_recommendation FOREIGN KEY (recommendation_id) REFERENCES recommendation(recommendation_id)
);

CREATE TABLE pet_recommendation_join (
	
	pet_id int NOT NULL,
	recommendation_id int NOT NULL,
	
	CONSTRAINT PK_pet_recommendation_join PRIMARY KEY (pet_id, recommendation_id),
	CONSTRAINT FK_pet_recommendation_join_pet FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
	CONSTRAINT FK_pet_recommendation_join_recommendation FOREIGN KEY (recommendation_id) REFERENCES recommendation(recommendation_id)
);

CREATE TABLE user_financial_preferences (
	
	user_id int NOT NULL,
	user_monthly_spend_total DECIMAL (13,2),
	user_weekly_spend_total DECIMAL (13,2),
	user_yearly_spend_total DECIMAL (13,2),
	user_food_budget DECIMAL (13,2),
	user_vet_practice varchar(255),
	user_emergency_fund_pool DECIMAL (13,2),
	
	CONSTRAINT PK_user_financial_preferences PRIMARY KEY (user_id),
	CONSTRAINT FK_user_financial_preferences_user_account FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

CREATE TABLE user_household_data (
	
	user_id int NOT NULL,
	user_housing_type varchar(64),
	user_housing_sqft int,
	user_has_yard boolean,
	user_has_neighbors boolean,
	user_access_petsitters boolean,
	user_home_env varchar(255),
	
	CONSTRAINT PK_user_household_data PRIMARY KEY (user_id),
	CONSTRAINT FK_user_household_data_user_account FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

COMMIT TRANSACTION;