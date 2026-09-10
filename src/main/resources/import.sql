INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO users(username, password) VALUES ('admin@admin.com','$2a$12$8uy5lYxWPbkryPzB8OgzGe2T47c0Z6SuC8ZmB9i674oGawCB1w4Cy');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO roles (name) VALUES ('ROLE_PROVEEDOR');
INSERT INTO users(username, password) VALUES ('proveedor','$2a$12$teRvjTadqUL3hfZZHgCkeeOWwBS57sVAhRaYtvtF2kjp/ms0MvzSC');
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO roles (name) VALUES ('ROLE_ANFITRION');
INSERT INTO users(username, password) VALUES ('anfitrion','$2a$12$teRvjTadqUL3hfZZHgCkeeOWwBS57sVAhRaYtvtF2kjp/ms0MvzSC');
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);