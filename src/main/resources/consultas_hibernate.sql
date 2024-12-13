DROP SCHEMA IF EXISTS `titanic_spaceship`;
CREATE SCHEMA IF NOT EXISTS `titanic_spaceship`;

SELECT * FROM `titanic_spaceship`.`pasajeros`;
SELECT * FROM `titanic_spaceship`.`entretenimientos`;
SELECT * FROM `titanic_spaceship`.`gastos`;

SELECT *
FROM `titanic_spaceship`.`gastos`
JOIN `titanic_spaceship`.`entretenimientos` ON `entretenimientos`.`id`=`gastos`.`id_entretenimiento`
JOIN `titanic_spaceship`.`pasajeros` ON `pasajeros`.`id`=`gastos`.`id_pasajero`;