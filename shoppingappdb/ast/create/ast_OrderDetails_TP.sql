DROP TABLE IF EXISTS `ast_OrderDetails_TP`;

CREATE TABLE `ast_OrderDetails_TP` ( `orderId` VARCHAR(256) NOT NULL, `orderItemId` VARCHAR(256) NOT NULL, `itemId` VARCHAR(256) NOT NULL, `itemPrice` DOUBLE(10,2) NULL DEFAULT NULL, `itemQuantity` INT(10) NOT NULL, `subTotal` DOUBLE(10,2) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`orderItemId`));

