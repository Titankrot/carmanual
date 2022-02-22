-- Cars schema

-- !Ups

CREATE TABLE Cars (
    id SERIAL UNIQUE,
    carNumber VARCHAR(9) NOT NULL,
    carColor VARCHAR(50) NOT NULL,
    carBrand VARCHAR(50) NOT NULL,
    yearOfCreate INTEGER NOT NULL,
    timeOfRow TIMESTAMP NOT NULL
);

-- !Downs

DROP TABLE cars;
DROP TABLE cars_id_seq;