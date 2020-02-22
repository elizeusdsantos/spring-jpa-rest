USE `SAMPLE`;

CREATE TABLE IF NOT EXISTS `Country` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40),
    PRIMARY KEY (`id`));

TRUNCATE TABLE `Country`;

INSERT INTO `Country` (name) VALUES('Brazil');
INSERT INTO `Country` (name) VALUES('United States');
INSERT INTO `Country` (name) VALUES('France');

CREATE TABLE IF NOT EXISTS `City` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40),
    `country_id` INT,
    PRIMARY KEY (`id`));

TRUNCATE TABLE `City`;

INSERT INTO `City` (name, country_id) VALUES('Curitiba',1);
INSERT INTO `City` (name, country_id) VALUES('Rio de Janeiro',1);
INSERT INTO `City` (name, country_id) VALUES('Manaus',1);
INSERT INTO `City` (name, country_id) VALUES('Fortaleza',1);
INSERT INTO `City` (name, country_id) VALUES('New York',2);
INSERT INTO `City` (name, country_id) VALUES('Los Angeles',2);
INSERT INTO `City` (name, country_id) VALUES('Atlanta',2);
INSERT INTO `City` (name, country_id) VALUES('Paris',3);
INSERT INTO `City` (name, country_id) VALUES('Lyon',3);

