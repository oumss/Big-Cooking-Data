SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";



DROP TABLE site;
DROP TABLE hotel;
DROP TABLE transport;
DROP TABLE coordinate;

-- NOMMER LA BD "agp_voyage"


CREATE TABLE `coordinate` (

  `id_coordinate` int(11) NOT NULL  PRIMARY KEY,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL 
);

CREATE TABLE `site` (
  `id_site` int(11) NOT NULL  PRIMARY KEY,
  `name` varchar(200) NOT NULL,
  `adress` varchar(500) NOT NULL,
  `site_price` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `site_isle` varchar(45) DEFAULT NULL,
  `id_coordinate` int(11) NOT NULL REFERENCES coordinate(`id_coordinate`) ,
  `busDisponibility` boolean ,
  `boatDisponibility` boolean
);

CREATE TABLE `hotel` (

  `id_hotel` int(11) NOT NULL  PRIMARY KEY,
  `hotel_name` varchar(100) DEFAULT NULL,
  `hotel_price` int(11) DEFAULT NULL,
  `hotel_isle` varchar(100) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `id_coordinate` int(11) NOT NULL REFERENCES coordinate(`id_coordinate`) ,
  `busDisponibility` boolean ,
  `boatDisponibility` boolean
  );

CREATE TABLE `transport` (

  `id_transport` int(11) NOT NULL  PRIMARY KEY,
  `type_transport` varchar(100) DEFAULT NULL,
  `price_transport` float DEFAULT NULL
  
);

