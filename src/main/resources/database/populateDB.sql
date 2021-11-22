DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (email, password)
VALUES ('user@gmail.com', 'userpass'),
       ('admin@gmail.com', 'adminpass');

INSERT INTO restaurants (title)
VALUES ('Burger Frog'),
       ('Pizza Shot');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (title, date, price, restaurant_id)
VALUES ('burger', '2020-01-30', 1299, 100002),
       ('salad', '2020-01-30', 599, 100002),
       ('pizza', '2020-01-30', 1340, 100003),
       ('chicken', '2020-01-30', 815, 100003),
       ('egg salad', '2020-01-30', 440, 100003),
       ('tea', '2020-01-30', 215, 100003),
       ('ice-cream', '2020-01-30', 345, 100003),
       ('burger', '2020-01-31', 1399, 100002),
       ('coffee', '2020-01-31', 299, 100002),
       ('pizza', '2020-01-31', 1345, 100003),
       ('fries', '2020-01-31', 590, 100003),
       ('egg salad', '2020-01-31', 445, 100003),
       ('juice', '2020-01-31', 320, 100003);

INSERT INTO votes (date, restaurant_id, user_id)
VALUES ('2020-01-30', 100002, 100000),
       ('2020-01-31', 100003, 100000);

