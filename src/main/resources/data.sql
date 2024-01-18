INSERT INTO brand (id, name) VALUES (1, 'Kia');
INSERT INTO brand (id, name) VALUES (2, 'Hyundai');
INSERT INTO brand (id, name) VALUES (3, 'Toyota');

INSERT INTO model (brand_id, id, name) VALUES (2, 1, 'Acer');
INSERT INTO model (brand_id, id, name) VALUES (2, 2, 'Atos');
INSERT INTO model (brand_id, id, name) VALUES (1, 3, 'Rio');
INSERT INTO model (brand_id, id, name) VALUES (1, 4, 'Picanto');
INSERT INTO model (brand_id, id, name) VALUES (3, 5, 'Corolla');

INSERT INTO fee (id, value, name) VALUES (1, 15.0, 'Regular');
INSERT INTO fee (id, value, name) VALUES (2, 30.0, 'Overdue');

INSERT INTO paymethod (id, name) VALUES (1, 'Cash');
INSERT INTO paymethod (id, name) VALUES (2, 'Credit');

INSERT INTO car (km, model_id, situation, color, plate) VALUES (200, 4, 0, '#c8b84e', 'T100000');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (210, 3, 0, '#9F6C54', 'T100001');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (220, 4, 0, '#685176', 'T100002');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (230, 2, 0, '#E9a21g', 'T100003');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (2809, 2, 0, '#7559F5', 'T100004');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (878, 3, 0, '#4G7Ba8', 'T100005');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (843, 3, 0, '#93F940', 'T100006');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (1800, 3, 0, '#c8439G', 'T100007');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (280, 5, 0, '#c2958c', 'T100008');
INSERT INTO car (km, model_id, situation, color, plate) VALUES (290, 1, 0, '#422b25', 'T100009');

INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #105 interior, 10 de Octubre, La Habana', '95010166700', 'luismiguellagosxenes@gmail.com', 'Pedro Pérez Gonzáles');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #106 interior, 10 de Octubre, La Habana', '96010166700', 'cdrobayna01@gmail.com', 'Juan Alberto Martínez Oropesa');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #107 interior, 10 de Octubre, La Habana', '97010166700', 'luismiguellagosxenes@gmail.com', 'Luis Ricardo Hernández');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #108 interior, 10 de Octubre, La Habana', '98010166700', 'cdrobayna01@gmail.com', 'Mario Gómez Antunes');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #109 interior, 10 de Octubre, La Habana', '99010166700', 'luismiguellagosxenes@gmail.com', 'Lionel Rodriguez Espada');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #104 interior, 10 de Octubre, La Habana', '94010166700', 'cdrobayna01@gmail.com', 'María Pérez González');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #103 interior, 10 de Octubre, La Habana', '93010166700', 'luismiguellagosxenes@gmail.com', 'Juana Martínez Oropesa');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #102 interior, 10 de Octubre, La Habana', '92010166700', 'cdrobayna01@gmail.com', 'Keyla Ricardo Hernández');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #101 interior, 10 de Octubre, La Habana', '91010166700', 'luismiguellagosxenes@gmail.com', 'Lidia Gómez Antunes');
INSERT INTO driver (category, address, dni, email, name) VALUES (1, 'Santa Catalina y Juan Delgado, #100 interior, 10 de Octubre, La Habana', '90010166700', 'cdrobayna01@gmail.com', 'Reina Rodriguez Espada');

INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('AHK169192', 'Paisley Brooklyn Harris Cook', 74, 0, 'Dominica', '297 420 546 29', 'luismiguellagosxenes@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('VZL426023', 'Charlotte Natalie Bennett Gray', 26, 0, 'Pitcairn', '502 593 224 12', 'cdrobayna01@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('OTM861814', 'Ezekiel Adrian Hall Brown', 75, 1, 'Malawi', '245 600 201 22', 'luismiguellagosxenes@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('VSG440514', 'Joseph Brooks Johnson', 33, 1, 'Luxembourg', '52 385 357 81', 'cdrobayna01@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('GDV208807', 'Hannah Zoey Fox Fisher', 50, 1, 'Namibia', '683 010 751 25', 'luismiguellagosxenes@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('LJK556281', 'Cameron Henry Corbyn Graham', 69, 0, 'Svalbard and Jan Mayen', '1-664 106 830 39', 'cdrobayna01@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('AXV445064', 'Luca Jackson Butler Campbel', 60, 0, 'French Southern territories', '353 239 650 59', 'luismiguellagosxenes@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('MUJ192593', 'Aurora Chloe Brooks Harvey', 25, 0, 'Jordan', '856 972 019 55', 'cdrobayna01@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('BCN943850', 'Matthew Amstrong Corbyn', 51, 0, 'Saint Helena', '373 654 490 49', 'luismiguellagosxenes@gmail.com');
INSERT INTO tourist (passport, name, age, gender, country, phone, email) VALUES ('XDT417242', 'Elijah Harrison Anderson', 69, 0, 'Rwanda', '55 864 579 41', 'cdrobayna01@gmail.com');

-- Closed Contracts
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100002', '2018-10-29', 'GDV208807', 1, '95010166700', '2021-02-14', '2022-04-06', 225, 367, 4030);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100002', '2023-01-28', 'AXV445064', 2, NULL, '2023-07-20', '2023-09-18', 1578, 2867, 3900);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100003', '2020-06-27', 'GDV208807', 2, '97010166700', '2021-03-26', '2021-03-26', 1535, 2372, 2100);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100009', '2024-01-01', 'GDV208807', 1, '99010166700', '2024-01-08', '2024-01-12', 2277, 2943, 2400);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100008', '2023-03-13', 'BCN943850', 2, '92010166700', '2023-06-09', '2023-11-06', 1880, 2629, 9600);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100003', '2020-10-02', 'VZL426023', 2, '90010166700', '2022-12-31', '2022-12-31', 1267, 3394, 3750);
-- Open Contracts
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100005', '2024-01-14', 'VZL426023', 2, '95010166700', '2024-01-15', NULL, 878, NULL, 2000);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100004', '2020-07-16', 'OTM861814', 2, '96010166700', '2023-03-15', NULL, 2809, NULL, 1900);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100006', '2023-03-18', 'LJK556281', 2, NULL, '2023-11-26', NULL, 843, NULL, 2307);
INSERT INTO contract (plate, startdate, passport, paymethod_id, driver_dni, enddate, deliverydate, startkm, endkm, value) VALUES ('T100007', '2023-10-29', 'LJK556281', 1, NULL, '2023-12-23', NULL, 1800, NULL, 1085);

INSERT INTO role (name, description) VALUES ('ROLE_ADMIN', 'Administrator');
INSERT INTO role (name, description) VALUES ('ROLE_SUPERUSER', 'High Permissions Worker, e.g. Supervisor');
INSERT INTO role (name, description) VALUES ('ROLE_USER', 'Regular Worker');
INSERT INTO role (name, description) VALUES ('ROLE_DRIVER', 'Driver Worker');
INSERT INTO role (name, description) VALUES ('ROLE_CLIENT', 'Tourist Client');

INSERT INTO users (username, email, password, name, role) VALUES ('admin', 'cdrobayna01@gmail.com', '$2a$12$Fp0.9ip8awWNBin025evqelhKmMAuMPE4SeluHhV1vD3pN1ACegTe', 'Kevin Martínez', 'ROLE_ADMIN');
INSERT INTO users (username, email, password, name, role) VALUES ('superuser', 'luismiguellagosxenes@gmail.com', '$2a$12$P2xt7r2pSSvWP7oKr4s2e..Rdy86/oqo8XewNvQ0VL7ZU40Gg6asW', 'Indira Tamayo', 'ROLE_SUPERUSER');
INSERT INTO users (username, email, password, name, role) VALUES ('user', 'cdrobayna01@gmail.com', '$2a$12$g4yHbyqAooSmX5fthYxg.uV6bVyTTKUvSqbl1S1RLNBtUg2dIKXZm', 'Lorena García', 'ROLE_USER');
INSERT INTO users (username, email, password, name, role) VALUES ('driver', 'luismiguellagosxenes@gmail.com', '$2a$12$WSJZqM6neAfR1LFSRASuw.hPE2REBY3QwZYQWxCkP8KzI.PGEUEUO', 'Gabriel Ulloa', 'ROLE_DRIVER');
INSERT INTO users (username, email, password, name, role) VALUES ('client', 'cdrobayna01@gmail.com', '$2a$12$vvU8NdN6Gsq0Fnb8nXj7ZOjX6kga42LSts9HOF2nqwDYz08jSwBl.', 'Nestor Díaz', 'ROLE_CLIENT');
