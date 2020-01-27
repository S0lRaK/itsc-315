/*
SQLyog Community v11.3 (64 bit)
MySQL - 5.6.15 : Database - users
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`users` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `users`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`password`) values ('adam','adam'),('bill','bill');

/* Procedure structure for procedure `addUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `addUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(newUsername varchar(20), newPassword varchar(20))
BEGIN
	insert into users set username=newUsername, password=newPassword;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `deleteUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser`(delUsername varchar(20))
BEGIN
	delete from users where username=delUsername;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getAllUsers` */

/*!50003 DROP PROCEDURE IF EXISTS  `getAllUsers` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUsers`()
BEGIN
	select * from users;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `resetPassword` */

/*!50003 DROP PROCEDURE IF EXISTS  `resetPassword` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `resetPassword`(theUsername varchar(20))
BEGIN
	update users set password='password' where username=theUsername;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `userExists` */

/*!50003 DROP PROCEDURE IF EXISTS  `userExists` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `userExists`(theUsername varchar(20))
BEGIN
	select count(*) from users where username=theUsername;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
