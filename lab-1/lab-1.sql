-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab_1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab_1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab_1` DEFAULT CHARACTER SET utf8 ;
USE `lab_1` ;

-- -----------------------------------------------------
-- Table `lab_1`.`training_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`training_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('Solo', 'General', 'Individual') NOT NULL,
  `number_of_sets` VARCHAR(45) NOT NULL,
  `numbers_of_days` INT(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_1`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `training_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_client_training_type1`
    FOREIGN KEY (`training_type_id`)
    REFERENCES `lab_1`.`training_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_client_training_type1_idx` ON `lab_1`.`client` (`training_type_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab_1`.`gym`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`gym` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `sity` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_1`.`fitness_machine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`fitness_machine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_machine` ENUM('ForHands', 'ForLegs', 'ForBack', 'ForChest') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_1`.`exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `burning calories` INT(45) NOT NULL,
  `time_of_set` INT(45) NOT NULL,
  `training_type_id` INT NOT NULL,
  `fitness_machine_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_exercise_training_type1`
    FOREIGN KEY (`training_type_id`)
    REFERENCES `lab_1`.`training_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exercise_fitness_machine1`
    FOREIGN KEY (`fitness_machine_id`)
    REFERENCES `lab_1`.`fitness_machine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_exercise_training_type1_idx` ON `lab_1`.`exercise` (`training_type_id` ASC) VISIBLE;

CREATE INDEX `fk_exercise_fitness_machine1_idx` ON `lab_1`.`exercise` (`fitness_machine_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab_1`.`client_with_trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`client_with_trainer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_1`.`trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`trainer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `client_with_trainer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `client_with_trainer_id`),
  CONSTRAINT `fk_trainer_client_with_trainer1`
    FOREIGN KEY (`client_with_trainer_id`)
    REFERENCES `lab_1`.`client_with_trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_trainer_client_with_trainer1_idx` ON `lab_1`.`trainer` (`client_with_trainer_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab_1`.`gym_has_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`gym_has_client` (
  `gym_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`gym_id`, `client_id`),
  CONSTRAINT `fk_gym_has_client_gym`
    FOREIGN KEY (`gym_id`)
    REFERENCES `lab_1`.`gym` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gym_has_client_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `lab_1`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_gym_has_client_client1_idx` ON `lab_1`.`gym_has_client` (`client_id` ASC) VISIBLE;

CREATE INDEX `fk_gym_has_client_gym_idx` ON `lab_1`.`gym_has_client` (`gym_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab_1`.`gym_has_trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`gym_has_trainer` (
  `gym_id` INT NOT NULL,
  `trainer_id` INT NOT NULL,
  PRIMARY KEY (`gym_id`, `trainer_id`),
  CONSTRAINT `fk_gym_has_trainer_gym1`
    FOREIGN KEY (`gym_id`)
    REFERENCES `lab_1`.`gym` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gym_has_trainer_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `lab_1`.`trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_gym_has_trainer_trainer1_idx` ON `lab_1`.`gym_has_trainer` (`trainer_id` ASC) VISIBLE;

CREATE INDEX `fk_gym_has_trainer_gym1_idx` ON `lab_1`.`gym_has_trainer` (`gym_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
