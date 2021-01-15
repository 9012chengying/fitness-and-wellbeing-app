USE phyt;

/*Only run these 3 rows if tables have already been created - should be run first - Comment out if not needed*/
ALTER TABLE Exercises DROP FOREIGN KEY exercises_ibfk_1;
ALTER Table Media DROP FOREIGN KEY media_ibfk_1;

/*Drop tables AFTER above 3 queries run if tables already created - comment out if not needed*/
Drop Table media;
Drop TABLE Exercises;
DROP TABLE User;

CREATE TABLE IF NOT EXISTS User (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    user_role VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    trainer_id INT(6) REFERENCES User(id) ON DELETE SET NULL,
    user_name VARCHAR(12) NOT NULL,
    user_password VARCHAR(12) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

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

CREATE TABLE IF NOT EXISTS Media (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
	img_src VARCHAR(100) NOT NULL,
	alt_text VARCHAR (100) NOT NULL,
	type ENUM('Image', 'Video'),
    exercise_id INT(6),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY (exercise_id)
		REFERENCES Exercises(id)
		ON DELETE CASCADE	
);