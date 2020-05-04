DROP TABLE usertable;
CREATE TABLE usertable(
customer_id INTEGER,
first_name VARCHAR(80),
last_name VARCHAR(20),
email VARCHAR(100) PRIMARY KEY,
password VARCHAR(100)
);
INSERT INTO room(HOTEL_ID,ROOM_TYPE,ROOM_NO) VALUES(112,'BUSINESS',100);
DROP TABLE reservation;
CREATE TABLE reservation (
  reserve_id INTEGER PRIMARY KEY,
  hotel_id INTEGER,
  customer_id INTEGER,
  room_type VARCHAR(250),
  room_no INTEGER
);
DROP TABLE hotel;
CREATE TABLE hotel (
hotel_id INTEGER PRIMARY KEY,
hotel_name VARCHAR(250),
city VARCHAR(50),
rating INTEGER,
total_rooms INTEGER
);

DROP TABLE room;
CREATE TABLE room (
room_no INTEGER,
hotel_id INTEGER,
room_type VARCHAR(50),
PRIMARY KEY(room_no,hotel_id)
);

