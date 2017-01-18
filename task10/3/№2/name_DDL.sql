-- MySQL Workbench Synchronization
-- Generated: 2017-01-18 13:49
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: ONRiGE

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT(11) NOT NULL AUTO_INCREMENT,
  `lastnameCustomer` VARCHAR(45) NOT NULL,
  `firstnameCustomer` VARCHAR(45) NOT NULL,
  `phone` INT(11) NOT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Book` (
  `idBook` INT(11) NOT NULL AUTO_INCREMENT,
  `idWriter` INT(11) NOT NULL,
  `nameBook` VARCHAR(45) NOT NULL,
  `quantityBook` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`idBook`, `idWriter`),
  INDEX `fk_Book_Writer1_idx` (`idWriter` ASC),
  CONSTRAINT `fk_Book_Writer1`
    FOREIGN KEY (`idWriter`)
    REFERENCES `mydb`.`Writer` (`idWriter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Writer` (
  `idWriter` INT(11) NOT NULL AUTO_INCREMENT,
  `lastnameWriter` VARCHAR(45) NOT NULL,
  `firstnameWriter` VARCHAR(45) NOT NULL,
  `yearOfBirthday` DATE NULL DEFAULT NULL,
  `diedYear` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idWriter`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idCustomer` INT(11) NOT NULL,
  `dBook` INT(11) NOT NULL,
  `dateOrder` DATE NOT NULL,
  PRIMARY KEY (`idCustomer`, `dBook`),
  INDEX `fk_Order_Book1_idx` (`dBook` ASC),
  CONSTRAINT `fk_Order_Customer`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Book1`
    FOREIGN KEY (`dBook`)
    REFERENCES `mydb`.`Book` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
