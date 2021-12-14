DELETE
FROM meals;
DELETE
FROM votes;
DELETE
FROM users;
DELETE
FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (email, password, role)
VALUES ('user1@gmail.com', 'user1pass', 'USER'),
       ('user2@gmail.com', 'user2pass', 'USER'),
       ('admin@gmail.com', 'adminpass', 'ADMIN');

INSERT INTO restaurants (title)
VALUES ('Burger Frog'),
       ('Pizza Shot');

INSERT INTO meals (title, date, price, restaurant_id)
VALUES ('burger', '2020-01-30', 1299, 100003),
       ('salad', '2020-01-30', 599, 100003),
       ('pizza', '2020-01-30', 1340, 100004),
       ('chicken', '2020-01-30', 815, 100004),
       ('tea', '2020-01-30', 215, 100004),
       ('burger', '2020-01-31', 1399, 100003),
       ('coffee', '2020-01-31', 299, 100003),
       ('pizza', '2020-01-31', 1345, 100004),
       ('fries', '2020-01-31', 590, 100004),
       ('egg salad', '2020-01-31', 445, 100004),
       ('juice', '2020-01-31', 320, 100004);

INSERT INTO votes (date, restaurant_id, user_id)
VALUES ('2020-01-30', 100003, 100000),
       ('2020-01-30', 100003, 100001),
       ('2020-01-31', 100004, 100000),
       ('2020-01-31', 100004, 100001);

