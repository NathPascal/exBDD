-- 1.1 Générer votre base de données à l’aide du script Shop.sql --

DROP DATABASE IF EXISTS Shop;
CREATE DATABASE shop;
USE Shop;


CREATE TABLE T_Articles(
	IdArticle		int (4)		PRIMARY KEY AUTO_INCREMENT,
	Description		varchar(30)	NOT NULL,
	Brand 			varchar(30)	NOT NULL,
	UnitaryPrice	float(8)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Souris', 'Logitoch', 65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clavier', 'Microhard', 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Systeme d"exploitation', 'Fenetres vistouille', 150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Tapis souris', 'Chapeau Bleu', 5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Cle USB 8 To', 'Syno', 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Laptop', 'Ph', 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('CD x 500', 'CETME', 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD-R x 100', 'CETME', 99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD+R x 100', 'CETME', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Batterie Laptop', 'PH', 80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('WebCam', 'Logitoch', 755);

SELECT * FROM T_Articles;

-- 1.2 Effectuer les requêtes permettant d’afficher toutes les tables en base --

SHOW tables;

-- 1.3 Trouver un moyen pour décrire une table --

DESCRIBE T_Articles;

-- 1.4 Ajouter à la table des articles des occurrences de votre choix --

INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('MacBook', 'Apple', 2000);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Iphone 50', 'Apple', 20000);

SELECT * FROM T_Articles;

-- 1.5 Modifier un article avant de vérifier si c’est pris en compte --

UPDATE T_Articles set Brand = 'Logitech', UnitaryPrice = 85 where IdArticle = 1;



-- 1.6 Supprimer un article puis vérifier --

DELETE FROM T_Articles WHERE IdArticle = 2;

SELECT * FROM T_Articles;

-- 1.7 Sélectionner tous les articles dont le prix est supérieur à 100 --

SELECT * FROM T_Articles WHERE UnitaryPrice > 100;

-- 1.8 Sélectionner les articles dont le prix est compris entre 50 et 150 -- 

SELECT * FROM T_Articles WHERE UnitaryPrice BETWEEN '50' AND '150';

-- 1.9 Afficher les articles dans l'ordre croissant des prix -- 

SELECT * FROM T_Articles ORDER BY UnitaryPrice ASC;

-- 1.10 Afficher uniquement la description des articles --

SELECT Description FROM T_Articles;

-- 1.11 Choisissez une requête particulièrement intéressante à présenter --
-- pour spécifier le nombre maximum de résultats que l’ont souhaite obtenir -- 

SELECT * FROM T_Articles LIMIT 5;
 
-- 1.12 Ajouter la table des catégories à votre base de données et insérez-en -- 

CREATE TABLE T_Categories(
	IdCategory INT(4) PRIMARY KEY AUTO_INCREMENT,
	CatName VARCHAR(30) NOT NULL,
	Description VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Categories (CatName, Description) VALUES ('PC', 'ordinateur portable ou pas');
INSERT INTO T_Categories (CatName, Description) VALUES ('Smartphone', 'telephone de derniere generation avec ecran tactile + applis');
INSERT INTO T_Categories (CatName, Description) VALUES ('Materiel info', 'tout materiel informatique physique en lien avec un ordi');

SELECT * FROM T_Categories;

ALTER TABLE T_Articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 1;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 2;
UPDATE T_Articles SET IdCategory = 2 WHERE IdArticle = 3;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 4;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 5;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 6;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 7;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 8;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 9;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 10;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 11;
UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle = 12;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 13;
UPDATE T_Articles SET IdCategory = 2 WHERE IdArticle = 14;

SELECT * FROM T_Articles;

-- 1.13 Trouver la requête qui permet d’obtenir le résultat suivant

-- exo 6 user
CREATE TABLE T_Users (
IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
Login varchar(20) NOT NULL,
Password varchar(20) NOT NULL,
) ENGINE = InnoDB;
