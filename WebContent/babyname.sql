-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  
-- Version du serveur :  5.7.24
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `baby`
--

-- --------------------------------------------------------

--
-- Structure de la table `babyname`
--

DROP TABLE IF EXISTS `babyname`;
CREATE TABLE IF NOT EXISTS `babyname` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `region` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `babyname`
--

INSERT INTO `babyname` (`id`, `name`, `prenom`, `sex`, `region`) VALUES
(2, 'paul', 'macking', 'boy', 'Ile DE France'),
(3, 'ramesh', 'bihaji', 'boy', 'Hauts De France'),
(4, 'jack', 'painlous', 'boy', 'Grand Est'),
(7, 'socki', 'dialo', 'girl', 'Nouvelle Aquitaine'),
(8, 'bob', 'boulail', 'girl', 'Nouvelle Aquitaine'),
(10,'boudjama', 'mouloud', 'boy', 'bourgogne -Comte'),
(11,'MALIKA', 'MOUHAMED', 'girl', 'Occitanie');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
