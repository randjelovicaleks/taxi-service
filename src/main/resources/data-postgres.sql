INSERT INTO taxi_service (pib, name, address, phone_number)
VALUES ('4564684846', 'Crveni Taxi', 'Dunavska 2', '021 565 888');

INSERT INTO dispatcher (username, password, name, surname, address, phone_number, salary, taxi_service_id)
VALUES ('dispatcher', '123', 'Jovan', 'Jovanovic', 'Skerliceva 2', '063525987', 25000, 1);

INSERT INTO customer (username, password, name, surname, address, phone_number, taxi_service_id)
VALUES ('customer', 'customer', 'Aleksandra', 'Randjelovic', 'Ostroska 39', '0632547896', 1);

INSERT INTO driver (username, password, name, surname, address, phone_number, salary, taxi_card_number, taxi_service_id)
VALUES ('driver1', 'driver1', 'Marko', 'Markovic', 'Skerliceva 55', '0624578962', 30000, '555690', 1);
INSERT INTO driver (username, password, name, surname, address, phone_number, salary, taxi_card_number, taxi_service_id)
VALUES ('driver2', 'driver2', 'Janko', 'Jankovic', 'Skerliceva 85', '0624548962', 30000, '555698', 1);

INSERT INTO vehicle (model, manufacturer, first_registration, registration_number, vehicle_number,taxi_service_id, driver_id)
VALUES ('Punto', 'Fiat', '2011', 'NS005KJ', '001', 1, 1);
INSERT INTO vehicle (model, manufacturer, first_registration, registration_number, vehicle_number,taxi_service_id, driver_id)
VALUES ('Golf', 'Volkswagen', '2010', 'NS654LL', '002',1,2);
--Vehicle without driver
INSERT INTO vehicle (model, manufacturer, first_registration, registration_number, vehicle_number,taxi_service_id)
VALUES ('Polo', 'Volkswagen', '2014', 'NS478AA', '003',1);

--Drive by phone
INSERT INTO drive (order_date, starting_address, driver_id, dispatcher_id, customer_name)
VALUES ('16-04-2020 12:00:00', 'Marka Kraljevica 56', 1, 1, 'Jova');
INSERT INTO drive (order_date, starting_address, driver_id, dispatcher_id, customer_name)
VALUES ('16-04-2020 13:00:00', 'Temerinska 31', 1, 1, 'Pera');

--Drive by app
INSERT INTO drive (order_date, starting_address, driver_id, customer_id)
VALUES ('16-04-2020 13:15:00', 'Kisacka 51', 1, 1);

