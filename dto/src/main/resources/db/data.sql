INSERT INTO customers(id, name, email, password) VALUES (1, 'John Doe', 'john.doe@gmail.com', 'johnpass1');
INSERT INTO customers(id, name, email, password) VALUES (2, 'Lily Smith', 'lily.smith@gmail.com', 'lilypass1');

INSERT INTO orders (id, customer_id, total_price) VALUES (1, 1, 567.7);
INSERT INTO orders (id, customer_id, total_price) VALUES (2, 1, 22.5);
INSERT INTO orders (id, customer_id, total_price) VALUES (3, 2, 400.0);

INSERT INTO employees(id, name, email, password) VALUES (1, 'Michael Black', 'mick.black@gmail.com', 'mickpass1');
INSERT INTO employees(id, name, email, password) VALUES (2, 'Caroline Lee', 'caroline@gmail.com', 'leepass1');

INSERT INTO users(id, user_name, email, password) VALUES (1, 'big_bad_wolf', 'jake.sommers@gmail.com', 'jakepass1');
INSERT INTO users(id, user_name, email, password) VALUES (2, 'drama_queen', 'lucy.white@gmail.com', 'lucypass1');

INSERT INTO dogs(id, name, age) VALUES (1, 'Sparks', 2);

INSERT INTO cats(id, name, age) VALUES (1, 'Mr Whiskers', 3);