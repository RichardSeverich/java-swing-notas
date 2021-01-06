--TABLE USERS
CREATE TABLE users(
   id SERIAL,
   dni VARCHAR(10) NOT NULL,
   username VARCHAR(20) NOT NULL,
   password VARCHAR(20) NOT NULL,
   name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   birth_date DATE NOT NULL,
   email TEXT NOT NULL,
   type VARCHAR(13) NOT NULL,
   PRIMARY KEY (id)
);

--TABLE STUDENTS
CREATE TABLE students(
   id SERIAL,
   dni VARCHAR(10) NOT NULL,
   name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   birth_date DATE NOT NULL,
   telephone VARCHAR(15) NOT NULL,
   adress VARCHAR(50) NOT NULL,
   email TEXT NOT NULL,
   PRIMARY KEY (id)
);

--TABLE COURSES
CREATE TABLE courses(
   id SERIAL,
   name VARCHAR(20) NOT NULL,
   PRIMARY KEY (id)
);

--TABLE SUBJECTS
CREATE TABLE subjects(
   id SERIAL,
   name VARCHAR(20) NOT NULL,
   PRIMARY KEY (id)
);
