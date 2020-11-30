DROP DATABASE IF EXISTS theater;
CREATE DATABASE theater; 
USE theater;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
userName	VARCHAR(20) NOT NULL,
email		VARCHAR(30),
passw		VARCHAR(20),
fullName	VARCHAR(50),
address		VARCHAR(50),
creditCard	VARCHAR(16),		
PRIMARY KEY (userName)
);

DROP TABLE IF EXISTS vouchers;
CREATE TABLE vouchers(
vouchNum	INT NOT NULL,
amount		FLOAT,
expiryDate	DATETIME,
PRIMARY KEY (vouchNum)
);

DROP TABLE IF EXISTS movies;
CREATE TABLE movies(
movieName	VARCHAR(50) NOT NULL,
releaseDate	DATETIME NOT NULL,
moviePosterUrl	VARCHAR(250) NOT NULL, 
PRIMARY KEY (movieName)
);

DROP TABLE IF EXISTS showtimes;
CREATE TABLE showtimes(
showTimes	DATETIME NOT NULL,
movieName	VARCHAR(40) NOT NULL,
roomNumber	INT	NOT NULL,
PRIMARY KEY (movieName)
);

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets(
movieName	VARCHAR(25),
seat		INT,
showTimes	DATETIME NOT NULL,
room		INT,
price		FLOAT,
reservationId	INT NOT NULL,
PRIMARY KEY (reservationId)
);

DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations(
reservationId	INT NOT NULL,
userName VARCHAR(25) NOT NULL,
PRIMARY KEY (reservationId)
);
