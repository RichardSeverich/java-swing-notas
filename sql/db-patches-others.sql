--Users
DROP TABLE users;
SELECT * FROM users;
SELECT * FROM public.users;

--Students
DROP TABLE students;
SELECT * FROM students;
SELECT * FROM public.students;

--Courses
DROP TABLE courses;
SELECT * FROM courses;
SELECT * FROM public.courses;

--Subjects
DROP TABLE subjects;
SELECT * FROM subjects;
SELECT * FROM public.subjects;

--Validate Login
select * from users
where username = 'admin'
and password = 'Administrador123';

--Inner Join All Subjects into a Course
SELECT
courses_subjects.id,
subjects.id as id_subject,
subjects.name 
FROM subjects
INNER JOIN courses_subjects
ON subjects.id=courses_subjects.id_subject
INNER JOIN courses
ON courses.id=courses_subjects.id_course
WHERE courses_subjects.id_course = 1;

-- Inner Join All Students into a Course
SELECT
courses_students.id,
students.id as id_student,
students.dni,
students.name,
students.last_name,
students.birth_date,
students.telephone,
students.adress,
students.email 
FROM students
INNER JOIN courses_students
ON students.id=courses_students.id_student
INNER JOIN courses
ON courses.id=courses_students.id_course
WHERE courses_students.id_course = 1;

--Inner Join All Courses by Student
SELECT
courses_students.id,
courses.id as id_course,
courses.name 
FROM students
INNER JOIN courses_students
ON students.id=courses_students.id_student
INNER JOIN courses
ON courses.id=courses_students.id_course
WHERE courses_students.id_student = 9;

--All subjects NOT IN a course
SELECT subjects.*
FROM subjects
WHERE subjects.id
NOT IN (
  SELECT courses_subjects.id_subject 
  FROM courses_subjects 
  WHERE courses_subjects.id_course = 1
);

--All students NOT IN a course
SELECT students.*
FROM students
WHERE students.id
NOT IN (
  SELECT courses_students.id_student 
  FROM courses_students 
  WHERE courses_students.id_course = 1
);

--All subjects by id student and id course
SELECT 
subjects_students.id,
subjects.id as subjects_id,
subjects.name,
subjects_students.score 
FROM students 
INNER JOIN subjects_students
ON students.id=subjects_students.id_student
INNER JOIN subjects
ON subjects.id=subjects_students.id_subject
INNER JOIN courses_subjects
ON courses_subjects.id_subject=subjects_students.id_subject
WHERE subjects_students.id_student=2 AND courses_subjects.id_course=1;

--Validate Exist
select * from courses_students 
where id_course = 1;
