create database SmartSplitDB;
CREATE TABLE `SmartSplitDB`.`Users` (
  `UserEmailID` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserEmailID`));
  
  CREATE TABLE `SmartSplitDB`.`Groups` (
  `GroupID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `CreatedBy` VARCHAR(45) NOT NULL,
  `DateCreated` DATE NULL,
  PRIMARY KEY (`GroupID`),
  INDEX `FK_Createdby_idx` (`CreatedBy` ASC),
  CONSTRAINT `FK_Createdby`
    FOREIGN KEY (`CreatedBy`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSplitDB`.`Transactions` (
  `idTransactions` INT NOT NULL AUTO_INCREMENT,
  `GroupID` INT NULL,
  `AddedBy` VARCHAR(45) NOT NULL,
  `AddedTo` VARCHAR(45) NOT NULL,
  `TotalAmout` DOUBLE NOT NULL,
  `AmountOwe` DOUBLE NOT NULL,
  `Title` VARCHAR(45) NULL,
  `Category` VARCHAR(45) NULL,
  `Date` DATE NULL,
  PRIMARY KEY (`idTransactions`),
  INDEX `FK_TRANS_GROUP_idx` (`GroupID` ASC),
  INDEX `FK_TRANS_USERS_idx` (`AddedBy` ASC),
  INDEX `FK_TRANS_USERS2_idx` (`AddedTo` ASC),
  CONSTRAINT `FK_TRANS_GROUP`
    FOREIGN KEY (`GroupID`)
    REFERENCES `SmartSplitDB`.`Groups` (`GroupID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TRANS_USERS`
    FOREIGN KEY (`AddedBy`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TRANS_USERS2`
    FOREIGN KEY (`AddedTo`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `SmartSplitDB`.`User_Groups` (
  `UserID` VARCHAR(45) NOT NULL,
  `GroupID` INT NOT NULL,
  PRIMARY KEY (`UserID`, `GroupID`),
  INDEX `FK_2_idx` (`GroupID` ASC),
  CONSTRAINT `FK_1`
    FOREIGN KEY (`UserID`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_2`
    FOREIGN KEY (`GroupID`)
    REFERENCES `SmartSplitDB`.`Groups` (`GroupID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `SmartSplitDB`.`User_Friend` (
  `UserID` VARCHAR(45) NOT NULL,
  `FriendID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`, `FriendID`),
  INDEX `FK_UF_2_idx` (`FriendID` ASC),
  CONSTRAINT `FK_UF_1`
    FOREIGN KEY (`UserID`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_UF_2`
    FOREIGN KEY (`FriendID`)
    REFERENCES `SmartSplitDB`.`Users` (`UserEmailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
Truncate table `SmartSplitDB`.`Transactions`;