INSERT INTO house (house_id, house_name, house_size) VALUES( 1, 'Test House 1', 5000);
INSERT INTO house (house_id, house_name, house_size) VALUES( 2, 'Test House 2', 3000);
INSERT INTO house (house_id, house_name, house_size) VALUES( 3, 'Test House 3', 2570.46);

INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 1, 'Test House 1 Furniture 1', 25.86, 1);
INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 2, 'Test House 1 Furniture 2', 45.67, 1);
INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 3, 'Test House 1 Furniture 3', 2.66, 1);

INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 4, 'Test House 2 Furniture 1', 17, 2);
INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 5, 'Test House 2 Furniture 2', 268, 2);

INSERT INTO furniture (furniture_id, furniture_name, furniture_size, house_fk) VALUES( 6, 'Test House 3 Furniture 1', 22.66, 3);