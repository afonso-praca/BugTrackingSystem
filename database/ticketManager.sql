SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `ticketManager` DEFAULT CHARACTER SET big5 ;
USE `ticketManager` ;

-- -----------------------------------------------------
-- Table `ticketManager`.`COMPONENT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`COMPONENT` (
  `componentName` VARCHAR(100) NOT NULL ,
  `operadorEmail` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`componentName`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `ticketManager`.`FUNCTIONALITY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`FUNCTIONALITY` (
  `idFunctionality` INT(11) NOT NULL ,
  `functionalityName` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(100) NOT NULL ,
  `roleId` INT(11) NOT NULL ,
  PRIMARY KEY (`idFunctionality`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `ticketManager`.`ROLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`ROLE` (
  `type` INT(11) NOT NULL ,
  `roleTag` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`type`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `ticketManager`.`SYSTEM`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`SYSTEM` (
  `systemName` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`systemName`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `ticketManager`.`TICKET`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`TICKET` (
  `idTicket` INT(11) NOT NULL ,
  `title` VARCHAR(255) NOT NULL ,
  `systemKey` VARCHAR(45) NOT NULL ,
  `componentKey` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(45) NOT NULL ,
  `status` INT(11) NOT NULL ,
  `operador` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTicket`) ,
  UNIQUE INDEX `idTicket_UNIQUE` (`idTicket` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `ticketManager`.`USER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ticketManager`.`USER` (
  `idUser` INT(10) UNSIGNED NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(12) NOT NULL ,
  PRIMARY KEY (`idUser`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5
COMMENT = 'Tabela de usuarios do sistema';



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
