-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema javawebdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `javawebdb` ;

-- -----------------------------------------------------
-- Schema javawebdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `javawebdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `javawebdb` ;

-- -----------------------------------------------------
-- Table `javawebdb`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javawebdb`.`cart` (
  `cart_id` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `goods_number` VARCHAR(45) NULL DEFAULT NULL,
  `goods_prices` VARCHAR(45) NULL DEFAULT NULL,
  `goods_size` DOUBLE(10, 2) NULL DEFAULT NULL,
  `goods_color` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `javawebdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javawebdb`.`product` (
  `pro_id` VARCHAR(45) NOT NULL,
  `pro_name` VARCHAR(45) NULL DEFAULT NULL,
  `pro_image` VARCHAR(45) NULL DEFAULT NULL,
  `pro_price` DOUBLE(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`pro_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `javawebdb`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javawebdb`.`userinfo` (
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `javawebdb`.`product`
-- -----------------------------------------------------
START TRANSACTION;
USE `javawebdb`;
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('50b7', 'dog1', 'images/dog1.jpg', '234');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('7cba', 'dog2', 'images/dog2.jpg', '167');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('aa50', 'dog3', 'images/dog3.jpg', '129');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('c47a', 'dog4', 'images/dog4.jpg', '123');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('d091', 'dog5', 'images/dog5.jpg', '654');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('d936', 'dog6', 'images/dog6.jpg', '209');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('g93g', 'dog7', 'images/dog7.jpg', '129');
INSERT INTO `javawebdb`.`product` (`pro_id`, `pro_name`, `pro_image`, `pro_price`) VALUES ('ko34', 'dog8', 'images/dog8.jpg', '200');

COMMIT;


-- -----------------------------------------------------
-- Data for table `javawebdb`.`userinfo`
-- -----------------------------------------------------
START TRANSACTION;
USE `javawebdb`;
INSERT INTO `javawebdb`.`userinfo` (`firstname`, `lastname`, `email`, `password`) VALUES ('firstname', 'lastname', 'email', 'password');
INSERT INTO `javawebdb`.`userinfo` (`firstname`, `lastname`, `email`, `password`) VALUES ('Xia', 'Handong', '2017212926@bupt.edu.cn', '2926');
INSERT INTO `javawebdb`.`userinfo` (`firstname`, `lastname`, `email`, `password`) VALUES ('Yang', 'Shiming', '2017212928@bupt.edu.cn', '2928');
INSERT INTO `javawebdb`.`userinfo` (`firstname`, `lastname`, `email`, `password`) VALUES ('Jiang', 'Yingjie', '2017212935@bupt.edu.cn', '2935');
INSERT INTO `javawebdb`.`userinfo` (`firstname`, `lastname`, `email`, `password`) VALUES ('He', 'Yumeng', '2017212948@bupt.edu.cn', '2948');

COMMIT;

