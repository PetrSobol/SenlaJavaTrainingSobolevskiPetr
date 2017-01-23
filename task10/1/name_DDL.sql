CREATE DATABASE sobol;
CREATE TABLE IF NOT EXISTS `sobol`.`product` (
  `maker` VARCHAR(10) NULL DEFAULT NULL,
  `model` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`model`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `sobol`.`laptop` (
  `code` INT(11) NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT(255) NULL DEFAULT NULL,
  `ram` SMALLINT(255) NULL DEFAULT NULL,
  `hd` REAL NULL,
  `price` INT(11) NOT NULL,
  `screen` TINYINT(255) NULL DEFAULT NULL,
  PRIMARY KEY (`code`, `model`),
  INDEX `fk_laptop_product1_idx` (`model` ASC),
  CONSTRAINT `fk_laptop_product1`
    FOREIGN KEY (`model`)
    REFERENCES `sobol`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `sobol`.`pc` (
  `code` INT(11) NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT(255) NULL DEFAULT NULL,
  `ram` SMALLINT(255) NULL DEFAULT NULL,
  `hd` REAL NULL,
  `cd` VARCHAR(10) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`code`, `model`),
  INDEX `fk_pc_product1_idx` (`model` ASC),
  CONSTRAINT `fk_pc_product1`
    FOREIGN KEY (`model`)
    REFERENCES `sobol`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `sobol`.`printer` (
  `code` INT(11) NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL,
  `color` CHAR(1) NULL DEFAULT NULL,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`code`, `model`),
  INDEX `fk_printer_product1_idx` (`model` ASC),
  CONSTRAINT `fk_printer_product1`
    FOREIGN KEY (`model`)
    REFERENCES `sobol`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


