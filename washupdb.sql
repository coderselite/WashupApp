-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 06:14 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `washupdb`
--

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `mobile` varchar(15) NOT NULL UNIQUE,
  `referralCode` varchar(8) NOT NULL UNIQUE,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `address_type` varchar(10) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (address_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `catalog`
--

CREATE TABLE `catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL UNIQUE,
  `rate` int(11) NOT NULL,
  `category` varchar(20) NOT NULL,
  PRIMARY KEY (catalog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE `coupon` (
  `coupon_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_code` varchar(10) NOT NULL DEFAULT 'NA',
  `details` varchar(100) NOT NULL,
  PRIMARY KEY (coupon_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `otp`
--

CREATE TABLE `otp` (
  `otp_id` int(11) NOT NULL AUTO_INCREMENT,
  `otp` varchar(4) NOT NULL UNIQUE,
  `mobile` varchar(10) NOT NULL UNIQUE,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (otp_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_type` varchar(10) NOT NULL,
  `order_status` varchar(10) NOT NULL DEFAULT 'SUBMITTED',
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pickup_date` date NOT NULL,
  `pickup_time` varchar(10) NOT NULL,
  `delivery_date` date NOT NULL,
  `delivery_time` varchar(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `coupon_id` int(10) NOT NULL,
   PRIMARY KEY (order_id),
   FOREIGN KEY (user_id) REFERENCES users (user_id)
   ON DELETE CASCADE
   ON UPDATE CASCADE,
   FOREIGN KEY (coupon_id) REFERENCES coupon (coupon_id)
   ON DELETE CASCADE
   ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

CREATE TABLE `orders_catalog` (
  `orders_catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_id` int(10) NOT NULL,
  `order_id` int(10) NOT NULL,
   PRIMARY KEY (`orders_catalog_id`),
   FOREIGN KEY (catalog_id) REFERENCES catalog (catalog_id)
   ON DELETE CASCADE
   ON UPDATE CASCADE,
   FOREIGN KEY (order_id) REFERENCES orders (order_id)
   ON DELETE CASCADE
   ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;