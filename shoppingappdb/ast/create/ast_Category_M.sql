DROP TABLE IF EXISTS `ast_Category_M`;

CREATE TABLE `ast_Category_M` ( `categoryId` VARCHAR(256) NOT NULL, `productId` VARCHAR(256) NOT NULL, `categoryName` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`categoryId`));

