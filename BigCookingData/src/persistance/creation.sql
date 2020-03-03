DROP TABLE `connexion`;
DROP TABLE `weight_ingredient`;
DROP TABLE `weight_recipe`;
DROP TABLE `ingredient_recipe`;
DROP TABLE `proposed_recipe_user`;
DROP TABLE `recipe`;
DROP TABLE `ingredient`;
DROP TABLE `user`;


-- NOMMER LA BD "bcd"


CREATE TABLE `user` ( 
	`id_user` integer, 
    `surname` varchar(30), 
    `firstname` varchar(30), 
    `region` varchar(30), 
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
  `Energie, Règlement UE N° 1169/2011 (kcal/100g)`float DEFAULT NULL ,
  `Energie, N x facteur Jones, avec fibres  (kJ/100g)` float DEFAULT NULL,
  `Energie, N x facteur Jones, avec fibres  (kcal/100g)` float DEFAULT NULL ,
  `Eau (g/100g)` float DEFAULT NULL,
  `Protéines (g/100g)` float DEFAULT NULL,
  `Protéines brutes, N x 6.25 (g/100g)` float DEFAULT NULL,
  `Glucides (g/100g)`  float DEFAULT NULL,
  `Lipides (g/100g)` float DEFAULT NULL,
  `Sucres (g/100g)` float DEFAULT NULL,
  `Amidon (g/100g)` float DEFAULT NULL,
  `Fibres alimentaires (g/100g)` float DEFAULT NULL,
  `Polyols totaux (g/100g)` float DEFAULT NULL,
  `Cendres (g/100g)` float DEFAULT NULL,
  `Alcool (g/100g)` float DEFAULT NULL,
  `Acides organiques (g/100g)` float DEFAULT NULL,
  `AG saturés (g/100g)`  float DEFAULT NULL,
  `AG monoinsaturés (g/100g)`  float DEFAULT NULL,
  `AG polyinsaturés (g/100g)` float DEFAULT NULL,
  `AG 4:0, butyrique (g/100g)` float DEFAULT NULL,
  `AG 6:0, caproïque (g/100g)` float DEFAULT NULL,
  `AG 8:0, caprylique (g/100g)` float DEFAULT NULL,
  `AG 10:0, caprique (g/100g)` float DEFAULT NULL,
  `AG 12:0, laurique (g/100g)` float DEFAULT NULL,
  `AG 14:0, myristique (g/100g)` float DEFAULT NULL,
  `AG 16:0, palmitique (g/100g)` float DEFAULT NULL,
  `AG 18:0, stéarique (g/100g)` float DEFAULT NULL,
  `AG 18:1 9c (n-9), oléique (g/100g)` float DEFAULT NULL,
  `AG 18:2 9c,12c (n-6), linoléique (g/100g)` float DEFAULT NULL,
  `AG 18:3 c9,c12,c15 (n-3), alpha-linolénique (g/100g)` float DEFAULT NULL,
  `AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)` float DEFAULT NULL,
  `AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)` float DEFAULT NULL,
  `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)`float DEFAULT NULL,
  `Cholestérol (mg/100g)` float DEFAULT NULL,
  `Sel chlorure de sodium (g/100g)` float DEFAULT NULL,
  `Calcium (mg/100g)`  float DEFAULT NULL,
  `Chlorure (mg/100g)` float DEFAULT NULL,
  `Cuivre (mg/100g)` float DEFAULT NULL,
  `Fer (mg/100g)` float DEFAULT NULL,
  `Iode (µg/100g)` float DEFAULT NULL,
  `Magnésium (mg/100g)` float DEFAULT NULL,
  `Manganèse (mg/100g)` float DEFAULT NULL,
  `Phosphore (mg/100g)` float DEFAULT NULL,
  `Potassium (mg/100g)` float DEFAULT NULL,
  `Sélénium (µg/100g)`  float DEFAULT NULL,
  `Sodium (mg/100g)` float DEFAULT NULL,
  `Zinc (mg/100g)` float DEFAULT NULL,
  `Rétinol (µg/100g)` float DEFAULT NULL,
  `Beta-Carotène (µg/100g)` float DEFAULT NULL,
  `Vitamine D (µg/100g)` float DEFAULT NULL,
  `Vitamine E (mg/100g)` float DEFAULT NULL,
  `Vitamine K1 (µg/100g)` float DEFAULT NULL,
  `Vitamine K2 (µg/100g)` float DEFAULT NULL,
  `Vitamine C (mg/100g)`  float DEFAULT NULL,
  `Vitamine B1 ou Thiamine (mg/100g)` float DEFAULT NULL,
  `Vitamine B2 ou Riboflavine (mg/100g)` float DEFAULT NULL,
  `Vitamine B3 ou PP ou Niacine (mg/100g)` float DEFAULT NULL,
  `Vitamine B5 ou Acide pantothénique (mg/100g)` float DEFAULT NULL,
  `Vitamine B6 (mg/100g)` float DEFAULT NULL,
  `Vitamine B9 ou Folates totaux (µg/100g)` float DEFAULT NULL,
  `Vitamine B12 (µg/100g)` float DEFAULT NULL,
  `poids` int(11) NOT NULL
);

CREATE TABLE `recipe`( 
    `id_recipe` integer, 
    `id_ingredient` integer, 
    `weight` integer, 
    `name` varchar(30) , 
    `picture` LONGBLOB, 
    `price` double, 
    `time` time, 
    PRIMARY KEY (`id_recipe`),
    FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
);
    
CREATE TABLE `connexion`( 
    `id_user` integer, 
    `date` DATE, 
    PRIMARY KEY (`id_user`),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
);
    
CREATE TABLE `weight_ingredient`( 
    `id_user` integer,
    `id_ingredient` integer, 
    `weight_ingredient` integer, 
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
);
    
CREATE TABLE `weight_recipe`( 
    `id_user` integer,
    `id_recipe` integer, 
    `weight_recipe` integer, 
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`)
);
    
CREATE TABLE `ingredient_recipe`( 
    `id_ingredient_recipe` integer,
    `id_ingredient` integer, 
    `quantity` integer, 
    FOREIGN KEY (`id_ingredient_recipe`) REFERENCES `recipe` (`id_ingredient`),
    FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
);
     
CREATE TABLE `proposed_recipe_user`( 
    `id_user` integer,
    `id_recipe` integer,
    `visited` BOOLEAN,
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`)  
);
    

