USE phyt;

/*Run these queries to drop foreign keys that link the tables before you drop tables - Comment out if not needed*/
ALTER TABLE Exercises DROP FOREIGN KEY exercises_ibfk_1;
ALTER Table Media DROP FOREIGN KEY media_ibfk_1;
Alter table authorities DROP FOREIGN KEY authorities_ibfk_1;
Alter table ptinfo DROP FOREIGN KEY ptinfo_ibfk_1;
Alter table workouts DROP FOREIGN KEY workouts_ibfk_1;
Alter table workouts DROP FOREIGN KEY workouts_ibfk_2;
Alter table exerciseworkoutlink DROP FOREIGN KEY exerciseworkoutlink_ibfk_1;
Alter table exerciseworkoutlink DROP FOREIGN KEY exerciseworkoutlink_ibfk_2;

/*Drop tables AFTER above queries run if tables already created - comment out if not needed*/
DROP TABLE authorities;
Drop Table media;
Drop TABLE Exercises;
DROP TABLE User;
DROP TABLE workouts;
DROP TABLE ptinfo;
DROP TABLE exerciseworkoutlink;

/*Create db tables for Phyt app - Run creation in order */

/*Create main user table - contains login & registration data for both Trainers & Clients*/
CREATE TABLE IF NOT EXISTS User (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL UNIQUE,
    user_password VARCHAR(50) NOT NULL,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    user_role VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    trainer_id INT(6) REFERENCES User(id) ON DELETE SET NULL,
    enabled boolean DEFAULT True,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


/*Create user role authority table - required for Security authentication*/
create table authorities (
	username varchar (50) not null,
	authority varchar (50) not null,
	constraint fk_authorities_users foreign key(username) references user(user_name) On delete cascade on update cascade
);

/*creates a trigger so that authorities table is updated when a new user is added to User table*/
DELIMITER $$
	CREATE TRIGGER after_new_user_insert
	AFTER INSERT
	ON User FOR EACH ROW
	BEGIN
			INSERT INTO authorities(username, authority)
			VALUES(NEW.user_name, NEW.user_role);
	END$$
DELIMITER ;

/*Create exercise table - links to User table via user.id*/
CREATE TABLE IF NOT EXISTS Exercises (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	trainer_id INT(6),
	exercise_name VARCHAR(50) NOT NULL,
	exercise_desc VARCHAR(2000) NOT NULL,
	category ENUM('Core', 'Upper body', 'Lower body', 'Cardio', 'Drills'),
    thumbnail_img VARCHAR(100),
    thumbnail_alt VARCHAR (100),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (trainer_id)
		REFERENCES User(id)
        ON DELETE CASCADE
);

/*Create media table - stores data for Images & Videos linked to exercises*/
CREATE TABLE IF NOT EXISTS Media (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
	img_src VARCHAR(100) NOT NULL,
	alt_text VARCHAR (100) NOT NULL,
	type ENUM('Image', 'Video'),
    media_blob BLOB,
    exercise_id INT(6),
    media_type VARCHAR(45),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY (exercise_id)
		REFERENCES Exercises(id)
		ON DELETE CASCADE	
);

/*Create workout table*/
CREATE TABLE IF NOT EXISTS Workouts (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	client_id INT(6) NOT NULL,
    exercise_length INTEGER NOT NULL,
    exercise_rest INTEGER NOT NULL,
    rep_rest INTEGER NOT NULL,
    reps INTEGER NOT NULL,
    equipment TEXT,
    thumbnail_img VARCHAR(100),
    complete_by DATE NOT NULL,
    completed boolean default false, /*This will need to be automatic when timer for workout finishes*/
    completed_at DATETIME , /*This will need to be automatic when timer for workout finishes*/
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES User(id) ON DELETE CASCADE
);

/*Create link table that links exercises to workout*/
CREATE TABLE IF NOT EXISTS ExerciseWorkoutLink (
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
    workout_id INT(10),
    exercise_id INT(10),
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (workout_id) REFERENCES Workouts(id) ON DELETE CASCADE,
	FOREIGN KEY (exercise_id) REFERENCES Exercises(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PTInfo(
    id int not null AUTO_INCREMENT primary key,
    about TEXT,
    qualifications varchar(200),
    PT_location VARCHAR(200) NOT NULL,
    Trainer_id INT NOT NULL,
     FOREIGN KEY(Trainer_id)
    REFERENCES user(id)
    ON DELETE CASCADE
);