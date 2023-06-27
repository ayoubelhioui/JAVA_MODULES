CREATE TABLE table_name
(
     id SERIAL PRIMARY KEY,
     login VARCHAR(50) NOT NULL,
     password VARCHAR(50) NOT NULL,
     createdRooms INTEGER NOT NULL CONSTRAINT FK_CustomerID
         REFERENCES tblCustomers (CustomerID),
)