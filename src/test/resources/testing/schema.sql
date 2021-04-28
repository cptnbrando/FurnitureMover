CREATE TABLE house (
    house_id INTEGER NOT NULL AUTO_INCREMENT
    , house_name VARCHAR(255) NOT NULL
    , house_size DOUBLE NOT NULL
    , PRIMARY KEY (house_id)
);

CREATE TABLE furniture (
    furniture_id INTEGER NOT NULL AUTO_INCREMENT
    , furniture_name VARCHAR(255) NOT NULL
    , furniture_size DOUBLE NOT NULL
    , house_fk INTEGER NOT NULL
    , PRIMARY KEY (furniture_id)
    , FOREIGN KEY (house_fk) REFERENCES house(house_id)
);