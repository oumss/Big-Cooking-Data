DROP TABLE user ;
DROP TABLE ingredient_recipe ;
DROP TABLE ingredient;



-- rajouter une tabole pour visite et pr like 
-- NOMMER LA BD "bcd"

CREATE TABLE `user` ( 
	`id_user` integer AUTO_INCREMENT, 
    `surname` varchar(30), 
    `firstname` varchar(30), 
    `login` varchar(30), 
    `password` varchar(30), 
    PRIMARY KEY (`id_user`)
);
    
    
CREATE TABLE `ingredient` (
  `alim_grp_code`int(11) NOT NULL ,
  `alim_ssgrp_code` int(11) NOT NULL,
  `alim_ssssgrp_code` int(11) NOT NULL,
  `alim_grp_nom_fr` varchar(200) DEFAULT NULL,
  `alim_ssgrp_nom_fr` varchar(200) DEFAULT NULL,
  `alim_ssssgrp_nom_fr` varchar(200) DEFAULT NULL,
  `id_ingredient` int(11) NOT NULL  PRIMARY KEY ,
  `alim_nom_fr` varchar(200) DEFAULT NULL ,
  `Energie, R�glement UE N� 1169/2011 (kcal/100g)`float DEFAULT NULL ,
  `Energie, N x facteur Jones, avec fibres  (kJ/100g)` float DEFAULT NULL,
  `Energie, N x facteur Jones, avec fibres  (kcal/100g)` float DEFAULT NULL ,
  `Eau (g/100g)` float DEFAULT NULL,
  `Prot�ines (g/100g)` float DEFAULT NULL,
  `Prot�ines brutes, N x 6.25 (g/100g)` float DEFAULT NULL,
  `Glucides (g/100g)`  float DEFAULT NULL,
  `Lipides (g/100g)` float DEFAULT NULL,
  `Sucres (g/100g)` float DEFAULT NULL,
  `Amidon (g/100g)` float DEFAULT NULL,
  `Fibres alimentaires (g/100g)` float DEFAULT NULL,
  `Polyols totaux (g/100g)` float DEFAULT NULL,
  `Cendres (g/100g)` float DEFAULT NULL,
  `Alcool (g/100g)` float DEFAULT NULL,
  `Acides organiques (g/100g)` float DEFAULT NULL,
  `AG satur�s (g/100g)`  float DEFAULT NULL,
  `AG monoinsatur�s (g/100g)`  float DEFAULT NULL,
  `AG polyinsatur�s (g/100g)` float DEFAULT NULL,
  `AG 4:0, butyrique (g/100g)` float DEFAULT NULL,
  `AG 6:0, capro�que (g/100g)` float DEFAULT NULL,
  `AG 8:0, caprylique (g/100g)` float DEFAULT NULL,
  `AG 10:0, caprique (g/100g)` float DEFAULT NULL,
  `AG 12:0, laurique (g/100g)` float DEFAULT NULL,
  `AG 14:0, myristique (g/100g)` float DEFAULT NULL,
  `AG 16:0, palmitique (g/100g)` float DEFAULT NULL,
  `AG 18:0, st�arique (g/100g)` float DEFAULT NULL,
  `AG 18:1 9c (n-9), ol�ique (g/100g)` float DEFAULT NULL,
  `AG 18:2 9c,12c (n-6), linol�ique (g/100g)` float DEFAULT NULL,
  `AG 18:3 c9,c12,c15 (n-3), alpha-linol�nique (g/100g)` float DEFAULT NULL,
  `AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)` float DEFAULT NULL,
  `AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)` float DEFAULT NULL,
  `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`float DEFAULT NULL,
  `Cholest�rol (mg/100g)` float DEFAULT NULL,
  `Sel chlorure de sodium (g/100g)` float DEFAULT NULL,
  `Calcium (mg/100g)`  float DEFAULT NULL,
  `Chlorure (mg/100g)` float DEFAULT NULL,
  `Cuivre (mg/100g)` float DEFAULT NULL,
  `Fer (mg/100g)` float DEFAULT NULL,
  `Iode (�g/100g)` float DEFAULT NULL,
  `Magn�sium (mg/100g)` float DEFAULT NULL,
  `Mangan�se (mg/100g)` float DEFAULT NULL,
  `Phosphore (mg/100g)` float DEFAULT NULL,
  `Potassium (mg/100g)` float DEFAULT NULL,
  `S�l�nium (�g/100g)`  float DEFAULT NULL,
  `Sodium (mg/100g)` float DEFAULT NULL,
  `Zinc (mg/100g)` float DEFAULT NULL,
  `R�tinol (�g/100g)` float DEFAULT NULL,
  `Beta-Carot�ne (�g/100g)` float DEFAULT NULL,
  `Vitamine D (�g/100g)` float DEFAULT NULL,
  `Vitamine E (mg/100g)` float DEFAULT NULL,
  `Vitamine K1 (�g/100g)` float DEFAULT NULL,
  `Vitamine K2 (�g/100g)` float DEFAULT NULL,
  `Vitamine C (mg/100g)`  float DEFAULT NULL,
  `Vitamine B1 ou Thiamine (mg/100g)` float DEFAULT NULL,
  `Vitamine B2 ou Riboflavine (mg/100g)` float DEFAULT NULL,
  `Vitamine B3 ou PP ou Niacine (mg/100g)` float DEFAULT NULL,
  `Vitamine B5 ou Acide pantoth�nique (mg/100g)` float DEFAULT NULL,
  `Vitamine B6 (mg/100g)` float DEFAULT NULL,
  `Vitamine B9 ou Folates totaux (�g/100g)` float DEFAULT NULL,
  `Vitamine B12 (�g/100g)` float DEFAULT NULL,
  `poids` int(11) NOT NULL
);
    
CREATE TABLE `ingredient_recipe`( 
    `id_ingredient_recipe` integer,
    `id_ingredient` integer, 
    FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
);

CREATE TABLE `recipe`( 
    `id_recipe` integer AUTO_INCREMENT, 
    `url` varchar(300),
    `title` varchar(100),
    `number_of_person` integer,
    `level` integer,
    `budget` integer,
    `category` varchar(100),
    `time_total` varchar(100),
    `time_cooking` varchar(100),
    `utensils` varchar(100),
    `ingredients_list` varchar(200),
    `id_ingredient_recipe` integer, 
    `picture` LONGBLOB, 
    `steps` varchar(1000), 
    PRIMARY KEY (`id_recipe`)
);
    
CREATE TABLE `connexion`( 
    `id_user` integer, 
    `date` varchar(30), 
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
); 
    
CREATE TABLE `weight_ingredient`( 
    `id_weight_ingredient` integer AUTO_INCREMENT,
    `id_user` integer,
    `id_ingredient` integer,
    `weight_ingredient` integer, 
    PRIMARY KEY (`id_weight_ingredient`),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
);
 
CREATE TABLE `weight_recipe`( 
    `id_weight_recipe` integer AUTO_INCREMENT,
    `id_user` integer,
    `id_recipe` integer, 
    `weight_recipe` integer, 
    PRIMARY KEY (`id_weight_recipe`),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`)
);

     
CREATE TABLE `proposed_recipe_user`( 
    `id_proposed_recipe_user` integer AUTO_INCREMENT,
    `id_user` integer,
    `id_recipe` integer,
    `visited` BOOLEAN,
    PRIMARY KEY (`id_proposed_recipe_user`),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`)  
);
    
CREATE TABLE `visits`( 
    `id_visits` integer AUTO_INCREMENT,
    `id_user` integer,
    `id_recipe` integer,
    `liked` BOOLEAN,
    PRIMARY KEY (`id_visits`),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`)  
);
    
