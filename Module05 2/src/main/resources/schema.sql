CREATE TABLE IF NOT EXISTS "User"
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS ChatRoom
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS "User_Chatroom"
(
    user_id INTEGER REFERENCES "User" (id),
    chatroom_id INTEGER REFERENCES ChatRoom (id)
)

CREATE TABLE IF NOT EXISTS Messages
(
    id SERIAL PRIMARY KEY,
    text VARCHAR(200) NOT NULL,
    date date,
    author INTEGER REFERENCES "User" (id)
)

CREATE TABLE IF NOT EXISTS "Room_Messages"
(
    message_id INTEGER REFERENCES Messages(id),
    room_id INTEGER REFERENCES ChatRoom(id)
)

