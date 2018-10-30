insert into Monument (id, codigoPais, pais, ciudad, localizacion, nombre, descripcion, urlImagen) values (1, 'ES', 'España', 'Sevilla', '37.3861784,-5.9948024', 'La Giralda', 'Alminar de estilo renacentista español al que, siglos después, se sobrepuso un campanario gótico barroco.', 'https://i.imgur.com/XqCgfFH.jpg');


insert into User (username, password, enabled) values('admin', '$2a$04$dJ5YWbG5dE0wuPaPZWQDHu2oM/K2luEFhxsztxM6jhNsaU4iT8lvO', true);
insert into authorities(id, usuario, authority) values(1, 'admin','ROLE_ADMIN');