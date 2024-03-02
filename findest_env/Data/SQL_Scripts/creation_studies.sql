DROP TABLE IF EXISTS Studies;

CREATE TABLE Studies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(10),
    creationDate DATE
);