-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2021 at 10:10 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `critter`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

USE CRITTER;

CREATE TABLE `customer` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_pet_ids`
--

CREATE TABLE `customer_pet_ids` (
  `customer_id` bigint(20) NOT NULL,
  `pet_ids` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee_days_available`
--

CREATE TABLE `employee_days_available` (
  `employee_id` bigint(20) NOT NULL,
  `days_available` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee_skills`
--

CREATE TABLE `employee_skills` (
  `employee_id` bigint(20) NOT NULL,
  `skills` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pet_data`
--

CREATE TABLE `pet_data` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL,
  `birth_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedule_activities`
--

CREATE TABLE `schedule_activities` (
  `schedule_id` bigint(20) NOT NULL,
  `activities` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedule_employee_ids`
--

CREATE TABLE `schedule_employee_ids` (
  `schedule_id` bigint(20) NOT NULL,
  `employee_ids` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedule_pet_ids`
--

CREATE TABLE `schedule_pet_ids` (
  `schedule_id` bigint(20) NOT NULL,
  `pet_ids` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_pet_ids`
--
ALTER TABLE `customer_pet_ids`
  ADD KEY `FK7tniq4xolqlrmpy2s7aj2n8k7` (`customer_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_days_available`
--
ALTER TABLE `employee_days_available`
  ADD KEY `FK7ra3ha8r7rcikm5k4ow91hluk` (`employee_id`);

--
-- Indexes for table `employee_skills`
--
ALTER TABLE `employee_skills`
  ADD KEY `FKnepe51hewn4dd673e3qk1v2qx` (`employee_id`);

--
-- Indexes for table `pet_data`
--
ALTER TABLE `pet_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule_activities`
--
ALTER TABLE `schedule_activities`
  ADD KEY `FKp4gtwmuodj21fo9kjww5ql477` (`schedule_id`);

--
-- Indexes for table `schedule_employee_ids`
--
ALTER TABLE `schedule_employee_ids`
  ADD KEY `FKkb49i2ardhwgjvbiurm7sv06n` (`schedule_id`);

--
-- Indexes for table `schedule_pet_ids`
--
ALTER TABLE `schedule_pet_ids`
  ADD KEY `FKlyd6ijxoe9igbceaek83uoupp` (`schedule_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_pet_ids`
--
ALTER TABLE `customer_pet_ids`
  ADD CONSTRAINT `FK7tniq4xolqlrmpy2s7aj2n8k7` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `employee_days_available`
--
ALTER TABLE `employee_days_available`
  ADD CONSTRAINT `FK7ra3ha8r7rcikm5k4ow91hluk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `employee_skills`
--
ALTER TABLE `employee_skills`
  ADD CONSTRAINT `FKnepe51hewn4dd673e3qk1v2qx` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `schedule_activities`
--
ALTER TABLE `schedule_activities`
  ADD CONSTRAINT `FKp4gtwmuodj21fo9kjww5ql477` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

--
-- Constraints for table `schedule_employee_ids`
--
ALTER TABLE `schedule_employee_ids`
  ADD CONSTRAINT `FKkb49i2ardhwgjvbiurm7sv06n` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

--
-- Constraints for table `schedule_pet_ids`
--
ALTER TABLE `schedule_pet_ids`
  ADD CONSTRAINT `FKlyd6ijxoe9igbceaek83uoupp` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
