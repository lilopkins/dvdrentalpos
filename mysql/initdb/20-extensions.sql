USE sakila;

CREATE TABLE `customer_logins` (
    `customer_id` SMALLINT(5) UNSIGNED NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    `password_hash` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`customer_id`),
    CONSTRAINT `fk_customer_login_id`
        FOREIGN KEY (`customer_id`)
        REFERENCES `customer` (`customer_id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE `customer_tokens` (
    `customer_id` SMALLINT(5) UNSIGNED NOT NULL,
    `token` VARCHAR(64) NOT NULL,
    `valid_from_ip` VARCHAR(64) NOT NULL,
    `valid_until` TIMESTAMP NOT NULL,
    PRIMARY KEY (`customer_id`, `token`),
    CONSTRAINT `fk_customer_token_customer_id`
        FOREIGN KEY (`customer_id`)
        REFERENCES `customer` (`customer_id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DELIMITER ;;
CREATE TRIGGER `ins_customer_token` AFTER INSERT ON `customer_tokens` FOR EACH ROW BEGIN
    DELETE FROM `customer_tokens` WHERE `valid_until` < CURRENT_TIMESTAMP;
END;;
DELIMITER ;

CREATE TABLE `staff_tokens` (
    `staff_id` TINYINT(3) UNSIGNED NOT NULL,
    `token` VARCHAR(64) NOT NULL,
    `valid_from_ip` VARCHAR(64) NOT NULL,
    `valid_until` TIMESTAMP NOT NULL,
    PRIMARY KEY (`staff_id`, `token`),
    CONSTRAINT `fk_staff_token_staff_id`
        FOREIGN KEY (`staff_id`)
        REFERENCES `staff` (`staff_id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DELIMITER ;;
CREATE TRIGGER `ins_staff_token` AFTER INSERT ON `customer_tokens` FOR EACH ROW BEGIN
    DELETE FROM `customer_tokens` WHERE `valid_until` < CURRENT_TIMESTAMP;
END;;
DELIMITER ;
