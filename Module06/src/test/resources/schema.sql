CREATE TABLE IF NOT EXISTS Product (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price VARCHAR(255)
);