-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema simplevirtualstore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema simplevirtualstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simplevirtualstore` ;
USE `simplevirtualstore` ;

-- -----------------------------------------------------
-- Table `simplevirtualstore`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simplevirtualstore`.`client` (
  `idclient` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idclient`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simplevirtualstore`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simplevirtualstore`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `price` FLOAT(10,2) NOT NULL,
  PRIMARY KEY (`idproduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simplevirtualstore`.`order_store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simplevirtualstore`.`order_store` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `idclient` INT NOT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`idorder`),
  INDEX `fk_order_1_idx` (`idclient` ASC) VISIBLE,
  CONSTRAINT `fk_order_1`
    FOREIGN KEY (`idclient`)
    REFERENCES `simplevirtualstore`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simplevirtualstore`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simplevirtualstore`.`order_has_product` (
  `idorder` INT NOT NULL,
  `idproduct` INT NOT NULL,
  PRIMARY KEY (`idorder`, `idproduct`),
  INDEX `fk_order_has_product_product1_idx` (`idproduct` ASC) VISIBLE,
  INDEX `fk_order_has_product_order1_idx` (`idorder` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`idorder`)
    REFERENCES `simplevirtualstore`.`order_store` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`idproduct`)
    REFERENCES `simplevirtualstore`.`product` (`idproduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simplevirtualstore`.`user_authetication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simplevirtualstore`.`user_authetication` (
  `iduser_authetication` INT NOT NULL AUTO_INCREMENT,
  `name_user` VARCHAR(45) NOT NULL,
  `token` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`iduser_authetication`),
  UNIQUE INDEX `name_user_UNIQUE` (`name_user` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
