
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab_1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab_1
-- -----------------------------------------------------

DROP TABLE IF EXISTS training_type;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS client_with_trainer;
DROP TABLE IF EXISTS fitness_machine;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS gym;
DROP TABLE IF EXISTS gym_has_client;
DROP TABLE IF EXISTS trainer;
DROP TABLE IF EXISTS gym_has_trainer;

CREATE SCHEMA IF NOT EXISTS `lab_1`;
USE `lab_1` ;

-- -----------------------------------------------------
-- Table `lab_1`.`training_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_1`.`training_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('Solo', 'General', 'Individual') NOT NULL,
  `number_of_sets` VARCHAR(45) NOT NULL,
  `numbers_of_days` INT(10) NOT NULL,
  PRIMARY KEY key (`id`))
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

CREATE INDEX `fk_client_training_type1_idx` ON `lab_1`.`client` (`training_type_id` ASC);


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
  `burning_calories` INT(45) NOT NULL,
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

CREATE INDEX `fk_exercise_training_type1_idx` ON `lab_1`.`exercise` (`training_type_id` ASC) ;

CREATE INDEX `fk_exercise_fitness_machine1_idx` ON `lab_1`.`exercise` (`fitness_machine_id` ASC) ;


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

CREATE INDEX `fk_trainer_client_with_trainer1_idx` ON `lab_1`.`trainer` (`client_with_trainer_id` ASC) ;


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

CREATE INDEX `fk_gym_has_client_client1_idx` ON `lab_1`.`gym_has_client` (`client_id` ASC) ;

CREATE INDEX `fk_gym_has_client_gym_idx` ON `lab_1`.`gym_has_client` (`gym_id` ASC) ;


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

CREATE INDEX `fk_gym_has_trainer_trainer1_idx` ON `lab_1`.`gym_has_trainer` (`trainer_id` ASC) ;

CREATE INDEX `fk_gym_has_trainer_gym1_idx` ON `lab_1`.`gym_has_trainer` (`gym_id` ASC) ;


-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- INSERT `training_type`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('1', 'Solo', '5', '3');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('2', 'General', '3', '2');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('3', 'Individual', '4', '6');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('4', 'Solo', '4', '1');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('5', 'General', '10', '3');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('6', 'Individual', '7', '2');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('7', 'Solo', '12', '5');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('8', 'General', '1', '1');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('9', 'Solo', '2', '2');

INSERT INTO `lab_1`.`training_type` (`id`, `type`, `number_of_sets`, `numbers_of_days`)
VALUES ('10', 'General', '10', '1');

-- -----------------------------------------------------
-- INSERT `client`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('1', 'Max', 'Glodan', 'maxglodan@gmail.com', '+380982300000', '1');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('2', 'Vasia', 'Vasyliv', 'vasiavasyliv@gmail.com', '+380975600000', '2');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('3', 'Ivan', 'Ivanych', 'ivanivanych@gmail.com', '+380934566556', '3');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('4', 'Taras', 'Tarasych', 'tarastarasych@gmail.com', '+380951233211', '4');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('5', 'Zakhar', 'Zakharych', 'zakharzakharych@gmail.com', '+380954560987', '5');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('6', 'Ihor', 'Ihorych', 'ihirihorych@gmail.com', '+380674322340', '6');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('7', 'Kolia', 'Kolianych', 'koliakolianychclient@gmail.com', '+380679871234', '7');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('8', 'Bodia', 'Bodianych', 'bodiabodianych@gmail.com', '+380683234543', '8');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('9', 'Mark', 'Markych', 'markmarkych@gmail.com', '+3809812345432', '9');

INSERT INTO `lab_1`.`client` (`id`, `first_name`, `second_name`, `email`, `phone_number`, `training_type_id`)
VALUES ('10', 'Yan', 'Yanych', 'yanyanych@gmail.com', '+380980054678', '10');


-- -----------------------------------------------------
-- INSERT `client_with_trainer`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('1', 'Petro', 'Petrych', '+380731234567');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('2', 'Pavlo', 'Pavlych', '+380731234000');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('3', 'Yana', 'Yanych', '+380735554567');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('4', 'Julia', 'Julich', '+380731112233');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('5', 'Max', 'Glodan', '+380934455666');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('6', 'Ivanko', 'Ivankych', '+380735674567');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('7', 'Maryna', 'Marynych', '+380990005566');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('8', 'Misha', 'Mishanych', '+380732233444');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('9', 'Vitalik', 'Vitalich', '+380670001111');

INSERT INTO `lab_1`.`client_with_trainer` (`id`, `name`, `surname`, `phone_number`)
VALUES ('10', 'Petro', 'Petrych', '+380731234567');

-- -----------------------------------------------------
-- INSERT `fitness_machine`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('1', 'ForHands');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('2', 'ForLegs');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('3', 'ForBack');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('4', 'ForChest');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('5', 'ForLegs');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('6', 'ForHands');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('7', 'ForChest');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('8', 'ForBack');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('9', 'ForHands');

INSERT INTO `lab_1`.`fitness_machine` (`id`, `type_machine`)
VALUES ('10', 'ForChest');

-- -----------------------------------------------------
-- INSERT `exercise`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('1', '50', '30', '1', '1');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('2', '97', '35', '2', '2');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('3', '111', '45', '3', '3');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('4', '123', '60', '4', '4');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('5', '105', '90', '5', '5');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('6', '38', '10', '6', '6');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('7', '43', '25', '7', '7');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('8', '150', '120', '8', '8');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('9', '50', '30', '9', '9');

INSERT INTO `lab_1`.`exercise` (`id`, `burning_calories`, `time_of_set`, `training_type_id`, `fitness_machine_id`)
VALUES ('10', '101', '100', '10', '10');



-- -----------------------------------------------------
-- INSERT `gym`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('1', 'GoldGym', 'LA', 'Venice');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('2', 'SportLife', 'Lviv', 'HeroivUPA');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('3', 'GorilaGym', 'Nadvirna', 'KniahyniOlgy');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('4', 'Fizkult', 'Nadvirna', 'Cheremshyny');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('5', 'AnimalGym', 'IF', 'Velykoho');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('6', 'SportStyle', 'Kiev', 'Shevchenka');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('7', 'SportLife', 'Odessa', 'Doroshenka');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('8', 'MavpaGym', 'Ternopil', 'Franka');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('9', 'FainyyGym', 'Kalush', 'Naukova');

INSERT INTO `lab_1`.`gym` (`id`, `name`, `sity`, `street`)
VALUES ('10', 'ForDrushchGym', 'NY', 'TimeSquere');

-- -----------------------------------------------------
-- INSERT `gym_has_client`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('1', '1');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('2', '2');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('3', '3');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('4', '4');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('5', '5');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('6', '6');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('7', '7');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('8', '8');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('9', '9');

INSERT INTO `lab_1`.`gym_has_client` (`gym_id`, `client_id`)
VALUES ('10', '10');


-- -----------------------------------------------------
-- INSERT `trainer`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('1', 'Arnold', 'Schwarzenegger', '+1234432555', '1');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('2', 'Rony', 'Kollman', '+1234432000', '2');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('3', 'Victor', 'Blud', '+1000055544', '3');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('4', 'Igor', 'Voitenko', '+733788744', '4');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('5', 'Goga', 'Tupuria', '+71234567', '5');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('6', 'Vasyl', 'Virastiuk', '+380971111111', '6');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('7', 'Kirril', 'Sarychev', '+787643245', '7');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('8', 'Aleksey', 'Mokshyn', '+3806661234', '8');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('9', 'Max', 'Trukhonovets', '+399984785345', '9');

INSERT INTO `lab_1`.`trainer` (`id`, `name`, `surname`, `phone_number`, `client_with_trainer_id`)
VALUES ('10', 'Chris', 'Heria', '+1555666577', '10');

-- -----------------------------------------------------
-- INSERT `gym_has_trainer`
-- -----------------------------------------------------
INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('1', '1');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('2', '2');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('3', '3');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('4', '4');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('5', '5');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('6', '6');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('7', '7');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('8', '8');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('9', '9');

INSERT INTO `lab_1`.`gym_has_trainer` (`gym_id`, `trainer_id`)
VALUES ('10', '10');







