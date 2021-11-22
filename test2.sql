/*
MySQL Data Transfer
Source Host: localhost
Source Database: test2
Target Host: localhost
Target Database: test2
Date: 22-11-2021 19:29:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ADMINID` int(11) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `PhoneNumber` int(20) NOT NULL,
  `GENDER` varchar(200) NOT NULL,
  PRIMARY KEY  (`ADMINID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `COURSEID` int(20) NOT NULL default '0',
  `CATALOGID` int(20) default NULL,
  `title` varchar(20) default NULL,
  `description` varchar(50) default NULL,
  `credits` int(20) default NULL,
  `semester` int(20) default NULL,
  `branch` varchar(20) default NULL,
  PRIMARY KEY  (`COURSEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `Grade` varchar(20) NOT NULL default '',
  `STUDENTID` int(20) NOT NULL default '0',
  `COURSEID` int(20) NOT NULL default '0',
  `Date_Of_Entry` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `ProfessorId` int(20) default NULL,
  `NumberOfStudentsEnrolled` int(20) default NULL,
  `CourseID` int(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `STUDENTID` int(20) default NULL,
  `RegistrationID` int(20) NOT NULL default '0',
  `PayableAmount` double(20,0) default NULL,
  `Paymodeid` int(20) NOT NULL default '0',
  `Date_Of_Pay` date default NULL,
  `status` tinyint(20) default NULL,
  PRIMARY KEY  (`RegistrationID`,`Paymodeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `ProfessorID` int(11) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `PhoneNumber` int(11) NOT NULL,
  `GENDER` varchar(20) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  PRIMARY KEY  (`ProfessorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `STUDENTID` int(20) NOT NULL default '0',
  `COURSEID` int(20) NOT NULL default '0',
  `CourseRegistrationStatus` tinyint(10) default NULL,
  `Date_OF_REGISTRATION` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`STUDENTID`,`COURSEID`,`Date_OF_REGISTRATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(10) NOT NULL,
  `ROLE_PROFILE` varchar(20) NOT NULL,
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `STUDENTID` int(11) NOT NULL,
  `NAME` varchar(200) default NULL,
  `PHNNUMBER` int(21) default NULL,
  `GENDER` varchar(20) default NULL,
  `SEMESTER` int(20) default NULL,
  `BRANCH` varchar(20) default NULL,
  `StudentRegistrationStatus` tinyint(6) default NULL,
  `ScholarshipPercentage` int(5) default NULL,
  `AdminStatus` tinyint(6) default NULL,
  PRIMARY KEY  (`STUDENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USERID` int(11) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `role_user_id` int(11) default NULL,
  PRIMARY KEY  (`USERID`),
  KEY `role_user_id` (`role_user_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_user_id`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('101', 'rajesh', '9908776', 'Male');
INSERT INTO `course` VALUES ('0', '101', 'OD', 'OperatingSystem', '5', '1', 'cse');
INSERT INTO `course` VALUES ('242', '101', 'OM', 'operationMan', '9', '1', 'cse');
INSERT INTO `course` VALUES ('276', '101', 'C', 'C-PL', '9', '1', 'cse');
INSERT INTO `course` VALUES ('331', '101', 'DB', 'DataBase', '6', '1', 'cse');
INSERT INTO `course` VALUES ('337', '101', 'OE', 'OpeartingEnvr', '5', '1', 'cse');
INSERT INTO `grade` VALUES ('e', '231', '331', '2021-11-22');
INSERT INTO `inventory` VALUES ('0', null, '32');
INSERT INTO `inventory` VALUES ('362', null, '242');
INSERT INTO `professor` VALUES ('362', 'babu', '98', 'male', 'phd');
INSERT INTO `register` VALUES ('231', '242', '1', '2021-11-22');
INSERT INTO `register` VALUES ('231', '276', '1', '2021-11-22');
INSERT INTO `register` VALUES ('231', '331', '1', '2021-11-22');
INSERT INTO `register` VALUES ('231', '337', '1', '2021-11-22');
INSERT INTO `role` VALUES ('1', 'STUDENT');
INSERT INTO `role` VALUES ('2', 'PROFESSOR');
INSERT INTO `role` VALUES ('3', 'ADMIN');
INSERT INTO `student` VALUES ('231', 'ramu', '990877', 'male', '1', 'cse', '0', '2', '1');
INSERT INTO `student` VALUES ('306', 'ravi', '998877', 'male', '1', 'cse', '0', '2', '0');
INSERT INTO `user` VALUES ('101', 'rajesh', '12345', '3');
INSERT INTO `user` VALUES ('231', 'ramu123', '12345', '1');
INSERT INTO `user` VALUES ('306', 'rvi12', '12345', '1');
INSERT INTO `user` VALUES ('362', 'babu', '12345', '2');
