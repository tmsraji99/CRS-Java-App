/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 19-11-2021 15:58:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `DOJ` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `COURSE_CODE` varchar(20) NOT NULL,
  `COURSE_NAME` varchar(20) NOT NULL,
  `CREDITS` int(5) NOT NULL,
  `COURSE_DESCRIPTION` varchar(20) default NULL,
  `CATALOG_ID` int(10) NOT NULL,
  `BRANCH` varchar(20) NOT NULL,
  `SEMESTER` varchar(20) NOT NULL,
  PRIMARY KEY  (`COURSE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `GRADE` varchar(20) default NULL,
  `COURSE_ID` int(30) default NULL,
  `STUDENT_ID` int(30) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `STUDENT_ID` int(20) default NULL,
  `REFERENCE_ID` int(20) default NULL,
  `NOTIFICATION_ID` int(20) default NULL,
  `NOTIFICATION_MESSAGE` varchar(50) default NULL,
  `Registration_Date` date default NULL,
  `PAYMENT` double(20,3) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `DEPARTMENT` varchar(20) default NULL,
  `DESIGNATION` varchar(20) default NULL,
  `DOJ` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `STUDENT_ID` int(20) NOT NULL default '0',
  `COURSE_ID` int(20) default NULL,
  `DATE_OF_REGISTRATION` date default NULL,
  `Course_Registration_Status` tinyint(2) default NULL,
  PRIMARY KEY  (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(20) NOT NULL default '0',
  `ROLE_PROFILE` varchar(40) default NULL,
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `STUDENT_ID` int(20) NOT NULL,
  `BRANCH` varchar(30) NOT NULL,
  `BATCH` int(20) NOT NULL,
  `STUDENT_NAME` varchar(50) NOT NULL,
  `STUDENT_PHNNUMBER` int(20) default NULL,
  `STDENT_REGISTRATION` tinyint(2) default NULL,
  `STUDENT_SCHOLARSHIPPRECENTAGE` float(4,3) default NULL,
  PRIMARY KEY  (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(20) NOT NULL default '0',
  `USER_NAME` varchar(50) default NULL,
  `USER_PASSWORD` varchar(40) default NULL,
  `ROLE_ID` int(20) default NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'DB', '5', 'DATABASE', '1', 'CS', '1');
INSERT INTO `course` VALUES ('2', 'OS', '5', 'OPERATING SYSTEM', '1', 'CS', '1');
INSERT INTO `course` VALUES ('3', 'C', '8', 'PL', '2', 'CS', '1');
INSERT INTO `role` VALUES ('1', 'Professor');
INSERT INTO `role` VALUES ('2', 'STUDENT');
INSERT INTO `role` VALUES ('3', 'Admin');
INSERT INTO `student` VALUES ('101', 'CSE', '2014', 'RAJESH', '990877', '1', null);
INSERT INTO `student` VALUES ('102', 'CSE', '2014', 'Mahesh', '1234', '1', '2.100');
INSERT INTO `student` VALUES ('103', 'ece', '2014', 'ravi', '1222', '1', '0.100');
INSERT INTO `user` VALUES ('0', null, null, null);
INSERT INTO `user` VALUES ('1', 'RAJESH', '12345', '2');
