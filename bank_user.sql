-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2016 at 07:58 PM
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
-- Table structure for table `bank_user`
--

CREATE TABLE IF NOT EXISTS `bank_user` (
`uid` int(11) NOT NULL,
  `uname` varchar(25) NOT NULL,
  `upass` varchar(25) NOT NULL,
  `account_no` varchar(4) NOT NULL,
  `balance` decimal(10,2) NOT NULL DEFAULT '10000.00',
  `status` int(11) NOT NULL DEFAULT '1',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_user`
--

INSERT INTO `bank_user` (`uid`, `uname`, `upass`, `account_no`, `balance`, `status`, `timestamp`) VALUES
(1, 'vagu', 'asd', '1231', '10500.00', 1, '2016-10-27 17:55:09'),
(2, 'nvagu', 'asda', '1230', '13500.00', 1, '2016-08-26 07:50:40'),
(4, 'qqq', 'qqqq', '1111', '10000.00', 0, '2016-10-27 15:45:15'),
(5, 'qqqa', 'qqqq', '1112', '6000.00', 1, '2016-10-27 17:55:09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_user`
--
ALTER TABLE `bank_user`
 ADD PRIMARY KEY (`uid`), ADD UNIQUE KEY `accoun_no` (`account_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank_user`
--
ALTER TABLE `bank_user`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
