DROP TABLE meals IF EXISTS;
DROP TABLE votes IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE global_seq AS INTEGER START WITH 100000;

CREATE TABLE users
(
    id       INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(5)   NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON users (email);

CREATE TABLE restaurants
(
    id    INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_title_idx
    ON restaurants (title);

CREATE TABLE meals
(
    id            INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
    title         VARCHAR(255) NOT NULL,
    date          DATE         NOT NULL,
    price         BIGINT       NOT NULL,
    restaurant_id INTEGER      NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_restaurant_title_date_idx
    ON meals (restaurant_id, title, date);

CREATE TABLE votes
(
    id            INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
    date          DATE    NOT NULL,
    restaurant_id INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE,
    user_id       INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX votes_unique_date_user_idx
    ON votes (date, user_id);