-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema company
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `company` ;

-- -----------------------------------------------------
-- Schema company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `company` DEFAULT CHARACTER SET latin1 ;
USE `company` ;

-- -----------------------------------------------------
-- Table `company`.`legoblock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company`.`legoblock` (
  `legoblockName` VARCHAR(45) NOT NULL,
  `length` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`legoblockName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `company`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `company`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company`.`orders` (
  `OrderId` INT(11) NOT NULL AUTO_INCREMENT,
  `User_userId` INT(11) NOT NULL,
  PRIMARY KEY (`OrderId`),
  INDEX `user` (`User_userId` ASC),
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `company`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `company`.`odetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company`.`odetails` (
  `Order_orderId` INT(11) NOT NULL,
  `quantity` INT(10) UNSIGNED NULL DEFAULT NULL,
  `legoblockName` VARCHAR(45) NOT NULL,
  `User_userId` INT(11) NOT NULL,
  PRIMARY KEY (`Order_orderId`, `legoblockName`),
  INDEX `legoblockName` (`legoblockName` ASC),
  INDEX `Userid_idx` (`User_userId` ASC),
  CONSTRAINT `Userid`
    FOREIGN KEY (`User_userId`)
    REFERENCES `company`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `odetails_ibfk_1`
    FOREIGN KEY (`Order_orderId`)
    REFERENCES `company`.`orders` (`OrderId`),
  CONSTRAINT `odetails_ibfk_2`
    FOREIGN KEY (`legoblockName`)
    REFERENCES `company`.`legoblock` (`legoblockName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;