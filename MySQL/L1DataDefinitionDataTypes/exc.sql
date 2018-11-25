CREATE DATABASE softuni_db;

USE softuni_db;

CREATE TABLE people(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    picture TINYBLOB,
    height DOUBLE(3,2),
    weight DOUBLE(5,2),
    gender ENUM('m','f') NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
    );

INSERT INTO people(id, name,picture, height, weight, gender, birthdate, biography)
VALUES
(1,'Pesho', NULL, 1.8, 45, 'm', '1889-01-28','az sym pesho'),
(2,'Gosho', NULL, 1.2, 50, 'm', '1881-01-28','az sym gosho'),
(3,'Asen', NULL, 1.3, 55, 'm', '1898-01-28','az sym sf'),
(4,'Nedqlko', NULL, 1.4, 65, 'm', '1999-01-28','az sym pfsdgfsg'),
(5,'Rumi', NULL, 1.5, 75, 'f', '1989-01-28','az sym fdzgdsgd');


CREATE TABLE users(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(25) NOT NULL,
    profile_picture BLOB(900),
    last_login_time DATETIME,
    is_deleted BIT
    );
    
INSERT INTO users(id, username, password, profile_picture, last_login_time, is_deleted)
VALUES
(1,'nedqlko88', 'fdfd', NULL, date(now()), 0),
(2,'gugudka42', 'afs', NULL, date(now()), 0),
(3,'Asen98', 'fd3234fd', NULL, date(now()), 0),
(4,'dsdsds@_sfs', 'fd234324fd',NULL, date(now()), 0),
(5,'patka@43', 'fdfasafasfd', NULL, date(now()), 0);

SELECT * FROM users;

ALTER TABLE users 
MODIFY id INT(11);

ALTER TABLE users 
DROP PRIMARY KEY;

ALTER TABLE users 
ADD PRIMARY KEY (id,username);

ALTER TABLE users 
MODIFY last_login_time DEFAULT CURRENT_TIMESTAMP;