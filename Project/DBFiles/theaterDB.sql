DROP DATABASE IF EXISTS theater;
CREATE DATABASE theater; 
USE theater;

DROP TABLE IF EXISTS movies;
CREATE TABLE movies(
movieName	VARCHAR(25) NOT NULL,
releaseDate	DATETIME,
PRIMARY KEY (movieName)
);

DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations(
reservationId	INT NOT NULL,
userName		VARCHAR(25),
PRIMARY KEY (reservationId)
);

DROP TABLE IF EXISTS showtimes;
CREATE TABLE showtimes(
showTime	VARCHAR(25),
movieName	VARCHAR(25)
);

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets(
movieName	VARCHAR(25),
seat		INT,
showTime	VARCHAR(25),
room		INT,
price		FLOAT,
reservationId	INT
);

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