DROP DATABASE IF EXISTS itsc315lab7;
CREATE DATABASE itsc315lab7;

USE `itsc315lab7`;

CREATE TABLE `user` (
  `UserName` varchar(25) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(25) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `user`(`UserName`,`FirstName`,`LastName`,`Email`,`Password`) values 
    ('admin','Admin','Admin','admin@nowhere.com','secret'),
    ('abe','Abe','Aberly','abe@nowhere.com','password'),
    ('bob','Bob','Barker','bob@nowhere.com','bobpassword');
