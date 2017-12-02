CREATE TABLE customer (
    id INTEGER NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO customer (firstname, lastname) VALUES('John','Smith');