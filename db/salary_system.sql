/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.42 : Database - employee_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `employee_db`;

/*Table structure for table `bank_accounts` */

DROP TABLE IF EXISTS `bank_accounts`;

CREATE TABLE `bank_accounts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `current_balance` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r9gi1et82prjsig51uqxj2qm6` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `bank_accounts` */

insert  into `bank_accounts`(`id`,`account_name`,`account_number`,`account_type`,`bank_name`,`branch_name`,`current_balance`) values 
(8,'Siyam Hasan','12345678912','Savings','DBBLl','Mirpur',14000),
(9,NULL,'12345678913',NULL,'Islami Bank',NULL,NULL),
(10,'Mainul Hasan','12345678915','Savings','DBBL','Rampura',106250),
(11,NULL,'12345678914',NULL,'City Bank',NULL,60750),
(15,'Mr. Alice','0102030405','Savaings','BRAC BANK','ECB',101750),
(16,'Mr. Alex','0102030406','Savaings','BRAC BANK','ECB',81100),
(17,'Mr. David','0102030407','Savaings','BRAC BANK','ECB',67600);

/*Table structure for table `company_account` */

DROP TABLE IF EXISTS `company_account`;

CREATE TABLE `company_account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `current_balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `company_account` */

insert  into `company_account`(`id`,`account_name`,`account_number`,`account_type`,`bank_name`,`branch_name`,`current_balance`) values 
(2,'Salary-Account','123456789010','Savings','DBBL','Uttara',999507250);

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `employee_id` varchar(4) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `grade` int NOT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `bank_account_id` bigint DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_i72l8nd0nt5yg1c1d0epgbds9` (`bank_account_id`),
  CONSTRAINT `FKm51ydpp71ipp42ps6wfdw3ht1` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employees` */

insert  into `employees`(`employee_id`,`address`,`grade`,`mobile_number`,`name`,`bank_account_id`) values 
('0123','Dinajpur',3,'1231232121','Iftekhar Hasan',11),
('1111','Dhaka',1,'01234567891','Mr. Alice',15),
('1237','Noakhali',6,'01638253115','Hasan Al Mahmud',9),
('1238','Dhaka',1,'74823749281','Hasan AL Mahmud',10),
('2222','Dhaka',2,'01234567892','Mr. Alex',16),
('3333','Dhaka',2,'01234567893','Mr. David',17);

/*Table structure for table `salary_transaction` */

DROP TABLE IF EXISTS `salary_transaction`;

CREATE TABLE `salary_transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `basic_salary` double NOT NULL,
  `house_rent` double NOT NULL,
  `medical_allowance` double NOT NULL,
  `payment_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_salary` double NOT NULL,
  `employee_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1d5aliiuigovg6e1g58p96sgs` (`employee_id`),
  CONSTRAINT `FK1d5aliiuigovg6e1g58p96sgs` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `salary_transaction` */

insert  into `salary_transaction`(`id`,`basic_salary`,`house_rent`,`medical_allowance`,`payment_date`,`status`,`total_salary`,`employee_id`) values 
(5,10000,2000,1500,'2025-07-24','PAID',13500,'1237'),
(6,45000,9000,6750,'2025-07-26','PAID',60750,'0123'),
(7,75000,15000,11250,'2025-07-26','PAID',101250,'1238'),
(8,75000,15000,11250,'2025-07-27','PAID',101250,'1111'),
(9,60000,12000,9000,'2025-07-27','PAID',81000,'2222'),
(10,50000,10000,7500,'2025-07-27','PAID',67500,'3333');

/*Table structure for table `salary_transactions` */

DROP TABLE IF EXISTS `salary_transactions`;

CREATE TABLE `salary_transactions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `employee_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahm8aouyl3mxl6rfx01saqgu3` (`employee_id`),
  CONSTRAINT `FKahm8aouyl3mxl6rfx01saqgu3` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `salary_transactions` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
