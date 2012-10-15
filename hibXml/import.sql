CREATE DATABASE  IF NOT EXISTS `hibernate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hibernate`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version	5.5.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_fk` int(11) DEFAULT NULL,
  `connection_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK63717A3F47140EA8` (`user_fk`),
  KEY `FK63717A3F5BF466C8` (`connection_fk`),
  CONSTRAINT `FK63717A3F5BF466C8` FOREIGN KEY (`connection_fk`) REFERENCES `connection` (`connection_id`),
  CONSTRAINT `FK63717A3F47140EA8` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connection`
--

DROP TABLE IF EXISTS `connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connection` (
  `connection_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `difficulty_level` int(11) DEFAULT NULL,
  `field_fk` int(11) DEFAULT NULL,
  `mentor_connection_fk` int(11) DEFAULT NULL,
  `trainee_connection_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`connection_id`),
  KEY `FKEEAE6ADE8670675E` (`trainee_connection_fk`),
  KEY `FKEEAE6ADE9C4D2EB7` (`mentor_connection_fk`),
  KEY `FKEEAE6ADE73138680` (`field_fk`),
  CONSTRAINT `FKEEAE6ADE73138680` FOREIGN KEY (`field_fk`) REFERENCES `field` (`field_id`),
  CONSTRAINT `FKEEAE6ADE8670675E` FOREIGN KEY (`trainee_connection_fk`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKEEAE6ADE9C4D2EB7` FOREIGN KEY (`mentor_connection_fk`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connection`
--

LOCK TABLES `connection` WRITE;
/*!40000 ALTER TABLE `connection` DISABLE KEYS */;
INSERT INTO `connection` VALUES (1,1,0,5,7,NULL),(2,1,0,2,7,NULL),(3,1,0,6,NULL,7),(4,1,0,1,NULL,7),(5,1,0,4,8,NULL),(6,1,0,2,8,NULL),(7,1,0,1,NULL,8),(8,1,0,6,NULL,9),(9,1,0,2,NULL,9),(10,1,0,6,10,NULL),(11,1,0,6,11,NULL),(12,1,0,1,11,NULL),(13,1,0,3,NULL,11),(14,1,0,2,12,NULL),(15,1,0,1,NULL,12);
/*!40000 ALTER TABLE `connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field`
--

DROP TABLE IF EXISTS `field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `field` (
  `field_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `subject_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`field_id`),
  KEY `FK3FCA8DA7BBF5A40` (`subject_fk`),
  CONSTRAINT `FK3FCA8DA7BBF5A40` FOREIGN KEY (`subject_fk`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field`
--

LOCK TABLES `field` WRITE;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;
INSERT INTO `field` VALUES (1,0,'Old 3D graphics API for n00bs','Java 3D',1),(2,0,'2D Java graphics API','Java 2D',1),(3,0,'C# for everybody','C# field 1',2),(4,0,'C# for extreme','C#',2),(5,0,'C# General','C#',2),(6,0,'C++ General','C++',3);
/*!40000 ALTER TABLE `field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,1,'THIS IS JAVAAAAA','Java'),(2,1,'Cminusminus','C sharp'),(3,1,'Cplusplus','C++');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `identifier_openID` varchar(255) DEFAULT NULL,
  `last_Name` varchar(255) DEFAULT NULL,
  `location_city` varchar(255) DEFAULT NULL,
  `location_country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'johndoe@anonymous.xxx','John','','Doe','Undisclosed','Neverland'),(2,1,'sexyjane@anonymous.xxx','Jane','','Doe','Also Undisclosed','Saturn'),(3,1,'awesomepriest@church.chr','George','','Baptista','On his way to heaven','Center of the Earth'),(4,1,'johndoe@anonymous.xxx','John','','Doe','Undisclosed','Neverland'),(5,1,'sexyjane@anonymous.xxx','Jane','','Doe','Also Undisclosed','Saturn'),(6,1,'awesomepriest@church.chr','George','','Baptista','On his way to heaven','Center of the Earth'),(7,1,'bob@smith.com','Bob','345678','Smith','here',''),(8,1,'basdfg@smith.com','Glen','2323','Smiths','there',''),(9,1,'bob@adrbafd.com','Tom','7865425','Smite','over here',''),(10,1,'bob@6ytghj.com','Alex','456412','Smile','over there',''),(11,1,'bob@adfbafv.com','Dave','34898745','Store','here',''),(12,1,'65tghj@smith.com','John','3893564','Robertson','here','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-14 10:40:35
