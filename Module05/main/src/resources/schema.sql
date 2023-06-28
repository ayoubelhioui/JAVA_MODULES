CREATE TABLE User
(
     id SERIAL PRIMARY KEY,
     login VARCHAR(50) NOT NULL,
     password VARCHAR(50) NOT NULL,
     CONSTRAINT FK_user_rooms FOREIGN KEY (id)
         REFERENCES ChatRooms(id)
)

CREATE TABLE ChatRoom
(
    id SEIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,

)