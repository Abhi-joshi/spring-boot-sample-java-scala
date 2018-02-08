CREATE TABLE customer (
  id              SERIAL NOT NULL PRIMARY KEY,
  firstname       VARCHAR(100) NOT NULL,
  lastname        VARCHAR(100) NOT NULL
);

INSERT INTO customer (firstname, lastname) VALUES('John','Smith');