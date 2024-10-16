INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$OPXYveR7idxZtQECioy1W.YG8U5hMw2Pgqo6pUVcErevxcJFjQBhu',1, 'Andres', 'Aedo','gaedo@mail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$cExQqr4AxV9FSVxgQ/yLj.XH343wcZGNKLFughClfokwftRQk1kJW',1, 'Cristobal', 'Aedo','caedo@mail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `phones` (number) VALUES ('956505213');
INSERT INTO `phones` (number) VALUES ('956505214');
INSERT INTO `phones` (number) VALUES ('956505215');
INSERT INTO `phones` (number) VALUES ('956505216');


INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (1, 1);
INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (1, 2);


INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (2, 1);
INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (2, 2);
INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (2, 3);
INSERT INTO `usuarios_phones` (usuario_id, phone_id) VALUES (2, 4);