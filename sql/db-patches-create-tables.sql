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

--TABLE COURSES SUBJECTS
CREATE TABLE courses_subjects(
   id serial,
   id_course int REFERENCES courses(id),
   id_subject int REFERENCES subjects(id),
   UNIQUE (id_subject, id_course),
   PRIMARY KEY (id)
);

--TABLE COURSES STUDENTS
CREATE TABLE courses_students(
   id serial,
   id_course int REFERENCES courses(id),
   id_student int REFERENCES students(id),
   UNIQUE (id_student, id_course),
   PRIMARY KEY (id)
);

--TABLE SUBJECTS STUDENTS
CREATE TABLE subjects_students(
   id serial,
   id_subject int REFERENCES subjects(id),
   id_student int REFERENCES students(id),
   score TEXT,
   UNIQUE (id_subject, id_student),
   PRIMARY KEY (id)
);
