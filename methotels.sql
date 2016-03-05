-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 01, 2016 at 11:55 PM
-- Server version: 5.5.47
-- PHP Version: 5.3.10-1ubuntu3.21

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `methotels`
--

-- --------------------------------------------------------

--
-- Table structure for table `Drzava`
--

CREATE TABLE IF NOT EXISTS `Drzava` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=50 ;

--
-- Dumping data for table `Drzava`
--

INSERT INTO `Drzava` (`ID`, `Ime`) VALUES
(35, 'Tanzanija'),
(37, 'Poljska'),
(38, 'Jermenija'),
(39, 'Vijetnam'),
(40, 'Mongolija'),
(41, 'Ekvador'),
(42, 'Etiopija'),
(44, 'Japan'),
(46, 'Rusija'),
(47, 'Angola'),
(48, 'Kenija'),
(49, 'Srbija');

-- --------------------------------------------------------

--
-- Table structure for table `Gost`
--

CREATE TABLE IF NOT EXISTS `Gost` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `drzID` int(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `drzID` (`drzID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=20 ;

--
-- Dumping data for table `Gost`
--

INSERT INTO `Gost` (`ID`, `Ime`, `Prezime`, `drzID`) VALUES
(12, 'Dikembe', 'Mutombo', 35),
(13, 'Fedor', 'Emelijanenko', 46),
(14, 'Nenad', 'Stekic', 49),
(15, 'Emir', 'Bekric', 49);

-- --------------------------------------------------------

--
-- Table structure for table `Grad`
--

CREATE TABLE IF NOT EXISTS `Grad` (
  `Grad_ID` int(10) NOT NULL,
  `Grad_Ime` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `drzID` int(10) NOT NULL,
  PRIMARY KEY (`Grad_ID`),
  KEY `drzID` (`drzID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Grad`
--

INSERT INTO `Grad` (`Grad_ID`, `Grad_Ime`, `drzID`) VALUES
(1, 'Smederevo', 1),
(2, 'Atina', 2),
(3, 'Sao Paolo', 3),
(4, 'Leskovac', 1);

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE IF NOT EXISTS `soba` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Sprat` int(11) NOT NULL,
  `TV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Internet` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Djakuzi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Rezervacija` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ime_sobe` (`Ime`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=324 ;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID`, `Ime`, `Sprat`, `TV`, `Internet`, `Djakuzi`, `Rezervacija`) VALUES
(102, 'Ubedljivo Najbolji Apartman', 5, 'Da', 'Da', 'Ne', 'REZERVISANA'),
(202, 'Novi Apartman', 2, 'Da', 'Da', 'Da', 'REZERVISANA'),
(301, 'Gornji Apartman', 3, 'Da', 'Da', 'Da', 'SLOBODNA'),
(303, 'Najbolji Apartman', 3, 'Da', 'Da', 'Da', 'SLOBODNA'),
(304, 'Najtrazeniji apartman', 4, 'Da', 'Da', 'Da', 'SLOBODNA'),
(305, 'Najlepsi Apartman', 5, 'Da', 'Da', 'Da', 'SLOBODNA'),
(306, 'Extra Apartman', 5, 'Da', 'Da', 'Da', 'REZERVISANA'),
(307, 'Veliki Apartman', 4, 'Da', 'Da', 'Da', 'REZERVISANA'),
(308, 'Top Apartman', 5, 'Da', 'Da', 'Da', 'SLOBODNA'),
(314, 'Deluxe Apartman', 6, 'Da', 'Da', 'Ne', 'REZERVISANA'),
(315, 'Super Apartman', 5, 'Da', 'Da', 'Da', 'SLOBODNA'),
(319, 'Best Apartman', 3, 'Da', 'Ne', 'Ne', 'SLOBODNA'),
(320, 'Exclusive Apartman', 5, 'Da', 'Ne', 'Ne', 'REZERVISANA'),
(321, 'Fine Apartman', 5, 'Da', 'Ne', 'Ne', 'SLOBODNA'),
(322, 'Beautiful Apartman', 4, 'Da', 'Da', 'Da', 'SLOBODNA'),
(323, 'Etno Apartman', 5, 'Da', 'Ne', 'Ne', 'SLOBODNA');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `User_ID` int(10) NOT NULL AUTO_INCREMENT,
  `User_email` varchar(40) COLLATE utf8_bin NOT NULL,
  `User_password` varchar(100) COLLATE utf8_bin NOT NULL,
  `User_rola` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`User_ID`, `User_email`, `User_password`, `User_rola`) VALUES
(1, 'mymail@mail.com', 'c0a8e1e5e307cc5b33819b387b5f01fd', 'KORISNIK'),
(3, 'admin@mail.com', '923352284767451ab158a387a283df26', 'ADMIN');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Gost`
--
ALTER TABLE `Gost`
  ADD CONSTRAINT `Gost_ibfk_1` FOREIGN KEY (`drzID`) REFERENCES `Drzava` (`ID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
