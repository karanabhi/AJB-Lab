-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 26, 2016 at 09:51 AM
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_trans`
--

INSERT INTO `bank_trans` (`uid`, `payee`, `payer`, `amount`, `timestamp`) VALUES
(1, 1, 2, '200.00', '2016-08-14 20:29:37'),
(2, 2, 1, '100.00', '2016-08-14 20:32:10'),
(3, 1, 2, '500.00', '2016-08-26 07:40:50');

-- --------------------------------------------------------

--
-- Table structure for table `bank_user`
--

CREATE TABLE IF NOT EXISTS `bank_user` (
`uid` int(11) NOT NULL,
  `uname` varchar(25) NOT NULL,
  `upass` varchar(25) NOT NULL,
  `account_no` varchar(4) NOT NULL,
  `balance` decimal(10,2) NOT NULL DEFAULT '10000.00',
  `status` int(11) NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_user`
--

INSERT INTO `bank_user` (`uid`, `uname`, `upass`, `account_no`, `balance`, `status`, `timestamp`) VALUES
(1, 'vagu', 'asd', '1231', '6500.00', 1, '2016-08-26 07:40:48'),
(2, 'nvagu', 'asda', '1230', '13500.00', 1, '2016-08-26 07:50:40');

-- --------------------------------------------------------

--
-- Table structure for table `user_master`
--

CREATE TABLE IF NOT EXISTS `user_master` (
`uid` int(11) NOT NULL,
  `uname` varchar(25) NOT NULL,
  `upass` varchar(25) NOT NULL,
  `urole` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_master`
--

INSERT INTO `user_master` (`uid`, `uname`, `upass`, `urole`) VALUES
(1, 'abhi', 'pass', 'admin'),
(2, 'baba', 'karan', 'admin'),
(3, 'yolo', 'qqq', 'teacher'),
(4, 'yyy', 'aaa', 'teacher'),
(5, 'hhh', 'kjk', 'manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_trans`
--
ALTER TABLE `bank_trans`
 ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `bank_user`
--
ALTER TABLE `bank_user`
 ADD PRIMARY KEY (`uid`), ADD UNIQUE KEY `accoun_no` (`account_no`);

--
-- Indexes for table `user_master`
--
ALTER TABLE `user_master`
 ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank_trans`
--
ALTER TABLE `bank_trans`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `bank_user`
--
ALTER TABLE `bank_user`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_master`
--
ALTER TABLE `user_master`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
