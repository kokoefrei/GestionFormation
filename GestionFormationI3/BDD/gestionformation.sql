-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 02 mai 2017 à 06:57
-- Version du serveur :  5.7.17
-- Version de PHP :  7.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionformation`
--

-- --------------------------------------------------------

--
-- Structure de la table `choisirformation`
--

CREATE TABLE `choisirformation` (
  `numSalarie` int(11) NOT NULL,
  `numFormation` int(11) NOT NULL,
  `statutFormation` varchar(32) NOT NULL DEFAULT 'En Attente',
  `chefResponsable` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='L''association ChoisirFormation devient une table';

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `numFormation` int(11) NOT NULL,
  `prestaFormation` varchar(256) NOT NULL,
  `dateFormation` date NOT NULL,
  `dureeFormation` int(11) NOT NULL,
  `lieuFormation` varchar(256) NOT NULL,
  `creditFormation` int(11) NOT NULL,
  `contenuFormation` varchar(256) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Table Formation répertoriant toutes les formations proposées par la M2L';

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`numFormation`, `prestaFormation`, `dateFormation`, `dureeFormation`, `lieuFormation`, `creditFormation`, `contenuFormation`) VALUES
(1, 'Azyres', '2016-02-01', 2, 'Paris 78', 600, 'Service client'),
(2, 'CGI', '2016-02-04', 2, 'Bruxelles', 1000, 'Bonnes Pratiques de programmation'),
(3, 'StaffordShire University', '2017-03-28', 5, 'Stoke-On-Trent', 5, 'Unified Modelling Language'),
(4, 'EFREI', '2017-02-08', 3, 'Villejuif', 12, 'Numerical Technologies'),
(5, 'EFREI', '2017-05-31', 4, 'Accords Hotel Arena', 12, 'Local Area Network Configuration'),
(6, 'SalsaNueva', '2017-07-28', 1, 'Rue General Marchal', 3, 'Spleen, Swing, On2, On1'),
(7, 'MamboSalsa', '2017-09-16', 4, 'Amber square', 4, 'On1, Shines, smile');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `numUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(32) NOT NULL,
  `prenomUtilisateur` varchar(32) NOT NULL,
  `mailUtilisateur` varchar(32) NOT NULL,
  `passeUtilisateur` varchar(256) NOT NULL,
  `keywordUtilisateur` varchar(256) NOT NULL COMMENT 'mot clé utilisateur',
  `chefUtilisateur` varchar(32) DEFAULT '0',
  `credits` int(32) DEFAULT '5000' COMMENT 'Le nombre de crédits encore en possession de l''utilisateur',
  `joursUtilisateur` int(11) DEFAULT '15'
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Table Utilisateur répertoriant tous les utilisateurs de l''application';

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`numUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `mailUtilisateur`, `passeUtilisateur`, `keywordUtilisateur`, `chefUtilisateur`, `credits`, `joursUtilisateur`) VALUES
(1, 'koko', 'Admin', 'koko.Admin@M2L.com', 'kokoAdmin17', 'FirstNameYear(2)', 'je suis chef', 5000, 15),
(2, 'koko', 'jack', 'koko.jack@M2L.com', '5ffc7fdcf11a832fc797b173d52616a6a99a7d76', 'NameYear(2)', 'koko.Admin@M2L.com', 5000, 15);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `choisirformation`
--
ALTER TABLE `choisirformation`
  ADD PRIMARY KEY (`numSalarie`,`numFormation`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`numFormation`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`numUtilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `numFormation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `numUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
