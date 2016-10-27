-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2016 at 07:57 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ajp`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_trans`
--

CREATE TABLE IF NOT EXISTS `bank_trans` (
`uid` int(11) NOT NULL,
  `payee` int(11) NOT NULL,
  `payer` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_trans`
--

INSERT INTO `bank_trans` (`uid`, `payee`, `payer`, `amount`, `timestamp`) VALUES
(1, 1, 2, '200.00', '2016-08-14 20:29:37'),
(2, 2, 1, '100.00', '2016-08-14 20:32:10'),
(3, 1, 2, '500.00', '2016-08-26 07:40:50'),
(4, 1, 5, '500.00', '2016-10-27 17:50:56'),
(5, 5, 1, '4500.00', '2016-10-27 17:55:12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_trans`
--
ALTER TABLE `bank_trans`
 ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank_trans`
--
ALTER TABLE `bank_trans`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
