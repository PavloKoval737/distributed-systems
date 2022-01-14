CREATE SCHEMA `user_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE SCHEMA `cars_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE SCHEMA `deal_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE `user_db`.`user` (
                        `id_user` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
                        `user_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `phone_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `login` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `cars_db`.`car` (
                       `id_car` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
                       `status_car` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                       `vin_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                       `marka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                       `model` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                       `year_production` int(255) NOT NULL,
                       `run_car_km` int(255) NOT NULL,
                       `colour` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                       `type_car` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                       `price_car_$` int(255) NOT NULL,
                       PRIMARY KEY (`id_car`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `deal_db`.`deal` (
                        `id_deal` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
                        `car_id` bigint(30) unsigned NOT NULL,
                        `user_id` bigint(30) unsigned NOT NULL,
                        `deal_date` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        `status_deal` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                        PRIMARY KEY (`id_deal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `user_db`.`user` (`id_user`,`user_type`,`first_name`,`last_name`,`email`,`phone_number`,`login`,`password`) VALUES (1,'admin','pavlo','koval','pavlokoval@gmail.com','+380951112233','pavlo12','12345');

INSERT INTO `cars_db`.`car` (`id_car`,`status_car`,`vin_number`,`marka`,`model`,`year_production`,`run_car_km`,`colour`,`type_car`,`price_car_$`) VALUES (1,'new','abc123','lexus','lx570',2021,15,'blue','suv',80000);

INSERT INTO `deal_db`.`deal` (`id_deal`,`car_id`,`user_id`,`deal_date`,`status_deal`) VALUES (1,1,1,'20/12/2021','Done');
INSERT INTO `deal_db`.`deal` (`id_deal`,`car_id`,`user_id`,`deal_date`,`status_deal`) VALUES (2,2,2,'18/12/2021','Done');