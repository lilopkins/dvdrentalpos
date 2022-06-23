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

-- Update default auto-increments
ALTER TABLE actor AUTO_INCREMENT = 201;
ALTER TABLE address AUTO_INCREMENT = 606;
ALTER TABLE category AUTO_INCREMENT = 17;
ALTER TABLE city AUTO_INCREMENT = 601;
ALTER TABLE country AUTO_INCREMENT = 110;
ALTER TABLE customer AUTO_INCREMENT = 600;
ALTER TABLE film AUTO_INCREMENT = 1001;
ALTER TABLE language AUTO_INCREMENT = 7;
ALTER TABLE payment AUTO_INCREMENT = 16050;
ALTER TABLE rental AUTO_INCREMENT = 16050;
ALTER TABLE staff AUTO_INCREMENT = 3;
ALTER TABLE store AUTO_INCREMENT = 3;

-- Add example customer login
INSERT INTO `customer_logins` (`customer_id`, `username`, `password_hash`) VALUES (1, "Mary", "8cb2237d0679ca88db6464eac60da96345513964");
