-- MySQL Workbench Synchronization
-- Generated: 2017-01-17 22:53
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Sobol

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT(11) NOT NULL AUTO_INCREMENT,
  `lastnameCustomer` VARCHAR(45) NULL DEFAULT NULL,
  `firstnameCustomer` VARCHAR(45) NULL DEFAULT NULL,
  `phone` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Book` (
  `idBook` INT(11) NOT NULL AUTO_INCREMENT,
  `idWriter` INT(11) NOT NULL,
  `nameBook` VARCHAR(45) NULL DEFAULT NULL,
  `quantityBook` VARCHAR(45) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`idBook`),
  INDEX `fk_Book_Writer_idx` (`idWriter` ASC),
  CONSTRAINT `fk_Book_Writer`
    FOREIGN KEY (`idWriter`)
    REFERENCES `mydb`.`Writer` (`idWriter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Writer` (
  `idWriter` INT(11) NOT NULL AUTO_INCREMENT,
  `lastnameWriter` VARCHAR(45) NULL DEFAULT NULL,
  `firstnameWriter` VARCHAR(45) NULL DEFAULT NULL,
  `Start_year` DATE NULL DEFAULT NULL,
  `Died_year` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idWriter`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idCustomer` INT(11) NOT NULL,
  `idBook` INT(11) NOT NULL,
  `dateOrder` INT(11) NOT NULL,
  PRIMARY KEY (`dateOrder`),
  INDEX `fk_Order_Customer1_idx` (`idCustomer` ASC),
  INDEX `fk_Order_Book1_idx` (`idBook` ASC),
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Book1`
    FOREIGN KEY (`idBook`)
    REFERENCES `mydb`.`Book` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
