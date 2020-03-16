--insert into recipe & ingredient_recipe
INSERT INTO `recipe`(`id_recipe`, `id_ingredient_recipe`, `name`, `picture`, `price`, `category`,`difficulty`,`time`,`steps`) VALUES (1,1,"Pomme de terre chelou",null,1,"Accompagnement",1,"15min","1.bla bla blo");
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (1,11122,1);	
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (1,20028,1);
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (1,4043,1);
	
INSERT INTO `recipe`(`id_recipe`, `id_ingredient_recipe`, `name`, `picture`, `price`, `category`,`difficulty`, `time`,`steps`) VALUES (2,2,"Tarte aux choux",null,2,"Plat pricipal",3,"1h30","1.bla 2.bla 3.blo");
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (2,20034,2);
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (2,20014,3);
INSERT INTO `ingredient_recipe`(`id_ingredient_recipe`, `id_ingredient`, `quantity`) VALUES (2,36005,1);

--insert into user
INSERT INTO `bcd`.`user` (`id_user`,`surname`,`firstname`,`login`,`password`)VALUES (1, "TEST", "Test", "test", "test");
INSERT INTO `bcd`.`user` (`id_user`,`surname`,`firstname`,`login`,`password`)VALUES (2, "MOUTAWADII", "Oumaima", "oumss", "oumss");
INSERT INTO `bcd`.`user` (`id_user`,`surname`,`firstname`,`login`,`password`)VALUES (3, "ARHAB", "Samira", "samirablk", "samira");
INSERT INTO `bcd`.`user` (`id_user`,`surname`,`firstname`,`login`,`password`)VALUES (4, "DAOUD", "Sariah", "sariah8", "sariah");

