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

--validate login
select * from users
where username = 'admin'
and password = 'Administrador123';
