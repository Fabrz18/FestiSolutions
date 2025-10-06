INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_PROVEEDOR');
INSERT INTO roles (name) VALUES ('ROLE_ANFITRION');
INSERT INTO users(username, password) VALUES ('user1','$2a$12$1oxeKzyeOcbic8CbfLU3yOqwyEoHDwQ9GlwmNac5vGlsxP6LIhfHC');
INSERT INTO users(username, password) VALUES ('admin','$2a$12$teRvjTadqUL3hfZZHgCkeeOWwBS57sVAhRaYtvtF2kjp/ms0MvzSC');
INSERT INTO users(username, password) VALUES ('proveedor','$2a$12$teRvjTadqUL3hfZZHgCkeeOWwBS57sVAhRaYtvtF2kjp/ms0MvzSC');
INSERT INTO users(username, password) VALUES ('anfitrion','$2a$12$teRvjTadqUL3hfZZHgCkeeOWwBS57sVAhRaYtvtF2kjp/ms0MvzSC');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- user1 with ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- admin with ROLE_ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (4, 4);
