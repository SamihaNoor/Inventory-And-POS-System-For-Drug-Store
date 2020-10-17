-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2019 at 10:28 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drug_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_info`
--

CREATE TABLE `employee_info` (
  `empID` int(10) NOT NULL,
  `empName` varchar(20) DEFAULT NULL,
  `contact` int(10) NOT NULL,
  `salary` int(8) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Stores data of employees';

--
-- Dumping data for table `employee_info`
--

INSERT INTO `employee_info` (`empID`, `empName`, `contact`, `salary`, `status`) VALUES
(10601, 'Shawn', 589540, 6200, 'salesman'),
(10602, 'Mike', 854005, 5200, 'salesman'),
(10603, 'Kevin Owens', 963250, 19500, 'manager'),
(10604, 'Ross', 785414, 5500, 'salesman'),
(10605, 'Jon', 785412, 5800, 'salesman'),
(10607, 'Joey', 785423, 5500, 'salesman'),
(10608, 'Min', 785428, 9700, 'manager'),
(10609, 'Stark', 632258, 9800, 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `med_info`
--

CREATE TABLE `med_info` (
  `medId` int(7) NOT NULL,
  `medName` varchar(20) DEFAULT NULL,
  `medType` varchar(20) NOT NULL,
  `unitPrice` double(6,2) NOT NULL,
  `quantity` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `med_info`
--

INSERT INTO `med_info` (`medId`, `medName`, `medType`, `unitPrice`, `quantity`) VALUES
(4000, 'Eumovate', 'Cream', 41.00, 100),
(4001, 'Fona plus Gel', 'Cream', 165.00, 139),
(4002, 'Napa Extra', 'Tablet', 3.80, 815),
(4003, 'Finix', 'Tablet', 5.00, 770),
(4004, 'Ciprocin', 'Capsule', 15.50, 545),
(4005, 'Fexo', 'Tablet', 7.00, 540),
(4006, 'Conasyd', 'Cream', 163.00, 105),
(4007, 'Prevas', 'Capsule', 4.00, 848),
(4008, 'Omidon', 'Tablet', 2.40, 672),
(4009, 'Yamadin', 'Tablet', 4.00, 815),
(4010, 'Stamaril', 'Deep SC Injection', 1000.00, 31),
(4011, 'Qpine', 'Tablet', 3.00, 755),
(4012, 'Xpain', 'Tablet', 2.50, 560),
(4013, 'Adora', 'Drops', 50.00, 83),
(4014, 'Compiron', 'Drops', 30.00, 98),
(4015, 'Rifamex', 'Tablet', 65.00, 744),
(4016, 'Alacot DS', 'Eye drop', 150.45, 103),
(4017, 'Ansulin', 'SC Injection', 4150.00, 85),
(4019, 'Cefotil', 'Power for suspention', 199.34, 18),
(4020, 'Phylopen Forte', 'Oral Suspension', 110.41, 22),
(4021, 'Lanso', 'Capsule', 3.51, 505),
(4022, 'Adorex', 'Drop', 20.07, 121),
(4023, 'Alacot', 'Eye drop', 110.34, 130),
(4024, 'Adiva', 'Tablet', 200.75, 458),
(4025, 'Epitra', 'Tablet', 4.00, 750),
(4026, 'Sedil', 'Suppository', 100.25, 330);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `saleId` int(7) NOT NULL,
  `medId` int(7) NOT NULL,
  `medName` varchar(20) NOT NULL,
  `quantity` int(7) NOT NULL,
  `unitPrice` double(6,2) NOT NULL,
  `amount` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`saleId`, `medId`, `medName`, `quantity`, `unitPrice`, `amount`) VALUES
(1, 4000, 'Eumovate', 2, 40.50, 81.00),
(1, 4005, 'Fexo', 5, 7.00, 35.00),
(1, 4010, 'Stamaril', 5, 1000.00, 5000.00),
(2, 4006, 'Conasyd', 2, 163.00, 326.00),
(2, 4012, 'Xpain', 20, 2.50, 25.00),
(2, 4009, 'Yamadin', 20, 4.00, 80.00),
(2, 4020, 'Phylopen Forte', 1, 110.41, 110.41),
(3, 4011, 'Qpine', 20, 3.00, 60.00),
(3, 4015, 'Rifamex', 1, 65.00, 130.00),
(4, 4012, 'Xpain', 20, 2.50, 37.50),
(4, 4010, 'Stamaril', 5, 1000.00, 5000.00),
(4, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(4, 4012, 'Xpain', 30, 2.50, 75.00),
(5, 4004, 'Ciprocin', 5, 15.50, 77.50),
(5, 4018, 'Brofex', 1, 35.00, 35.00),
(5, 4013, 'Adora', 1, 50.00, 50.00),
(6, 4011, 'Qpine', 20, 3.00, 60.00),
(6, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(6, 4015, 'Rifamex', 2, 65.00, 130.00),
(6, 4020, 'Phylopen Forte', 1, 110.41, 110.41),
(7, 4013, 'Adora', 1, 50.00, 50.00),
(7, 4018, 'Brofex', 3, 35.00, 105.00),
(8, 4007, 'Prevas', 20, 4.00, 80.00),
(8, 4011, 'Qpine', 30, 3.00, 90.00),
(8, 4014, 'Compiron', 15, 30.00, 450.00),
(9, 4015, 'Rifamex', 2, 65.00, 130.00),
(9, 4002, 'Napa Extra', 30, 3.80, 114.00),
(10, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(10, 4005, 'Fexo', 10, 7.00, 70.00),
(11, 4016, 'Alacot DS', 1, 150.45, 150.45),
(11, 4019, 'Cefotil', 1, 199.34, 199.34),
(11, 4005, 'Fexo', 15, 7.00, 105.00),
(12, 4002, 'Napa Extra', 10, 3.80, 38.00),
(12, 4007, 'Prevas', 20, 4.00, 80.00),
(12, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(12, 4012, 'Xpain', 30, 2.50, 75.00),
(13, 4006, 'Conasyd', 2, 163.00, 326.00),
(13, 4008, 'Omidon', 30, 2.40, 72.00),
(14, 4009, 'Yamadin', 20, 4.00, 80.00),
(14, 4016, 'Alacot DS', 1, 150.45, 150.45),
(15, 4009, 'Yamadin', 20, 4.00, 80.00),
(15, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(16, 4014, 'Compiron', 15, 30.00, 450.00),
(16, 4018, 'Brofex', 10, 35.00, 350.00),
(17, 4006, 'Conasyd', 2, 163.00, 326.00),
(17, 4016, 'Alacot DS', 1, 150.45, 150.45),
(18, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(18, 4002, 'Napa Extra', 30, 3.80, 114.00),
(19, 4005, 'Fexo', 5, 7.00, 35.00),
(19, 4009, 'Yamadin', 20, 4.00, 80.00),
(20, 4019, 'Cefotil', 1, 199.34, 199.34),
(20, 4014, 'Compiron', 5, 30.00, 150.00),
(21, 4007, 'Prevas', 30, 4.00, 120.00),
(22, 4012, 'Xpain', 30, 2.50, 75.00),
(23, 4008, 'Omidon', 45, 2.40, 108.00),
(24, 4007, 'Prevas', 20, 4.00, 80.00),
(24, 4014, 'Compiron', 2, 30.00, 60.00),
(25, 4011, 'Qpine', 15, 3.00, 45.00),
(26, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(26, 4002, 'Napa Extra', 10, 3.80, 38.00),
(27, 4018, 'Brofex', 10, 35.00, 350.00),
(27, 4020, 'Phylopen Forte', 2, 110.41, 220.82),
(28, 4013, 'Adora', 5, 50.00, 250.00),
(28, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(28, 4011, 'Qpine', 30, 3.00, 90.00),
(29, 4013, 'Adora', 4, 50.00, 200.00),
(29, 4019, 'Cefotil', 1, 199.34, 199.34),
(30, 4001, 'Fona plus Gel', 2, 160.00, 320.00),
(30, 4009, 'Yamadin', 20, 4.00, 80.00),
(31, 4008, 'Omidon', 15, 2.40, 36.00),
(32, 4000, 'Eumovate', 1, 40.50, 40.50),
(33, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(34, 4000, 'Eumovate', 2, 40.50, 81.00),
(35, 4000, 'Eumovate', 5, 40.50, 202.50),
(36, 4000, 'Eumovate', 2, 40.50, 81.00),
(37, 4000, 'Eumovate', 6, 40.50, 243.00),
(38, 4008, 'Omidon', 10, 2.40, 24.00),
(39, 4004, 'Ciprocin', 5, 15.50, 77.50),
(40, 4007, 'Prevas', 4, 4.00, 16.00),
(41, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(42, 4002, 'Napa Extra', 10, 3.80, 38.00),
(43, 4006, 'Conasyd', 2, 163.00, 326.00),
(44, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(44, 4006, 'Conasyd', 2, 163.00, 326.00),
(45, 4011, 'Qpine', 30, 3.00, 90.00),
(45, 4013, 'Adora', 2, 50.00, 100.00),
(46, 4013, 'Adora', 3, 50.00, 150.00),
(46, 4019, 'Cefotil', 5, 199.34, 996.70),
(47, 4012, 'Xpain', 20, 2.50, 50.00),
(47, 4014, 'Compiron', 4, 30.00, 120.00),
(48, 4003, 'Finix', 5, 5.00, 25.00),
(49, 4006, 'Conasyd', 1, 163.00, 163.00),
(49, 4008, 'Omidon', 8, 2.40, 19.20),
(50, 4009, 'Yamadin', 10, 4.00, 40.00),
(51, 4020, 'Phylopen Forte', 2, 110.41, 220.82),
(52, 4016, 'Alacot DS', 1, 150.45, 150.45),
(53, 4010, 'Stamaril', 5, 1000.00, 5000.00),
(53, 4009, 'Yamadin', 10, 4.00, 40.00),
(54, 4001, 'Fona plus Gel', 1, 160.00, 160.00),
(54, 4011, 'Qpine', 30, 3.00, 90.00),
(55, 4016, 'Alacot DS', 1, 150.45, 150.45),
(55, 4019, 'Cefotil', 1, 199.34, 199.34),
(55, 4004, 'Ciprocin', 15, 15.50, 232.50),
(55, 4014, 'Compiron', 2, 30.00, 60.00),
(56, 4006, 'Conasyd', 1, 163.00, 163.00),
(56, 4004, 'Ciprocin', 5, 15.50, 77.50),
(57, 4000, 'Eumovate', 1, 40.50, 40.50),
(58, 4002, 'Napa Extra', 10, 3.80, 38.00),
(59, 4002, 'Napa Extra', 10, 3.80, 38.00),
(60, 4002, 'Napa Extra', 20, 3.80, 76.00),
(60, 4009, 'Yamadin', 12, 4.00, 48.00),
(61, 4001, 'Fona plus Gel', 4, 160.00, 640.00),
(61, 4002, 'Napa Extra', 10, 3.80, 38.00),
(62, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(63, 4018, 'Brofex', 2, 35.00, 70.00),
(64, 4018, 'Brofex', 3, 35.00, 105.00),
(65, 4015, 'Rifamex', 1, 65.00, 65.00),
(66, 4002, 'Napa Extra', 5, 3.80, 19.00),
(66, 4020, 'Phylopen Forte', 1, 110.41, 110.41),
(67, 4012, 'Xpain', 5, 2.50, 12.50),
(68, 4007, 'Prevas', 20, 4.00, 80.00),
(68, 4009, 'Yamadin', 10, 4.00, 40.00),
(68, 4010, 'Stamaril', 1, 1000.00, 1000.00),
(69, 4015, 'Rifamex', 5, 65.00, 325.00),
(69, 4009, 'Yamadin', 20, 4.00, 80.00),
(70, 4002, 'Napa Extra', 10, 3.80, 38.00),
(70, 4006, 'Conasyd', 1, 163.00, 163.00),
(71, 4022, 'Adorex', 2, 20.07, 40.14),
(72, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(72, 4016, 'Alacot DS', 3, 150.45, 451.35),
(73, 4002, 'Napa Extra', 15, 3.80, 57.00),
(73, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(73, 4004, 'Ciprocin', 5, 15.50, 77.50),
(73, 4016, 'Alacot DS', 3, 150.45, 451.35),
(74, 4016, 'Alacot DS', 3, 150.45, 451.35),
(74, 4017, 'Ansulin', 1, 4150.00, 4150.00),
(75, 4017, 'Ansulin', 3, 4150.00, 12450.00),
(76, 4017, 'Ansulin', 2, 4150.00, 8300.00),
(77, 4022, 'Adorex', 4, 20.07, 80.28),
(78, 4009, 'Yamadin', 10, 4.00, 40.00),
(78, 4022, 'Adorex', 15, 20.07, 301.05),
(78, 4009, 'Yamadin', 5, 4.00, 20.00),
(79, 4006, 'Conasyd', 3, 163.00, 489.00),
(79, 4006, 'Conasyd', 3, 163.00, 489.00),
(80, 4002, 'Napa Extra', 10, 3.80, 38.00),
(81, 4002, 'Napa Extra', 15, 3.80, 57.00),
(82, 4001, 'Fona plus Gel', 1, 165.00, 165.00),
(83, 4006, 'Conasyd', 2, 163.00, 326.00),
(84, 4007, 'Prevas', 12, 4.00, 48.00),
(85, 4011, 'Qpine', 10, 3.00, 30.00);

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`userId`, `password`, `status`) VALUES
(10601, 'project', 'salesman'),
(10602, '18b16', 'salesman'),
(10603, 'manager', 'manager'),
(10604, '451q', 'salesman'),
(10605, '86315347', 'salesman'),
(10607, 'd515', 'salesman'),
(10608, '58372692', 'manager'),
(10609, '45570578', 'manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_info`
--
ALTER TABLE `employee_info`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `med_info`
--
ALTER TABLE `med_info`
  ADD PRIMARY KEY (`medId`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee_info`
--
ALTER TABLE `employee_info`
  MODIFY `empID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10611;

--
-- AUTO_INCREMENT for table `med_info`
--
ALTER TABLE `med_info`
  MODIFY `medId` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4028;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10611;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
