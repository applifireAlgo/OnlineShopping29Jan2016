

ALTER TABLE `ast_Brand_M` ADD CONSTRAINT FOREIGN KEY (`productId`) REFERENCES `ast_Product_M`(`productId`);



ALTER TABLE `ast_Brand_M` ADD CONSTRAINT FOREIGN KEY (`categoryId`) REFERENCES `ast_Category_M`(`categoryId`);

