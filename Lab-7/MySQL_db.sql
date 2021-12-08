DROP DATABASE IF EXISTS lab7;
CREATE DATABASE IF NOT EXISTS lab7;
USE lab7;

DROP TABLE IF EXISTS coworker;
CREATE TABLE coworker (
  id INT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  seniority INT NOT NULL,
  dob DATE NOT NULL,
  passport_number VARCHAR(100) NOT NULL,
  position_id INT NOT NULL,
  academic_status_id INT NOT NULL,
  degree_id INT NULL,
  PRIMARY KEY (id),
  UNIQUE (passport_number));
  
DROP TABLE IF EXISTS discipline;
CREATE TABLE discipline (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  semester_number varchar(100) NULL,
  code varchar(100) NOT NULL,
  assessment_id INT NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS position;
CREATE TABLE position (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS academic_status;
CREATE TABLE academic_status (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS degree;
CREATE TABLE degree (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
PRIMARY KEY (id));

DROP TABLE IF EXISTS coworker_discipline;
CREATE TABLE coworker_discipline (
  coworker_id INT NOT NULL,
  discipline_id INT NOT NULL,
PRIMARY KEY (coworker_id, discipline_id));

DROP TABLE IF EXISTS assessment;
CREATE TABLE assessment (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));