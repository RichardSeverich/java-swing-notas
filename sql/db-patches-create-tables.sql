CREATE TABLE users(
   id SERIAL,
   dni VARCHAR(7) NOT NULL,
   username VARCHAR(20) NOT NULL,
   password VARCHAR(20) NOT NULL,
   name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   birth_date DATE NOT NULL,
   email TEXT NOT NULL,
   type VARCHAR(13) NOT NULL,
   PRIMARY KEY (id)
);
