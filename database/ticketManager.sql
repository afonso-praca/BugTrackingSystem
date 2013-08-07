CREATE DATABASE  IF NOT EXISTS `ticketManager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ticketManager`;
-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ticketManager
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.12.04.2

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
-- Table structure for table `FUNCTIONALITY`
--

DROP TABLE IF EXISTS `FUNCTIONALITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FUNCTIONALITY` (
  `idFunctionality` int(11) NOT NULL,
  `functionalityName` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`idFunctionality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FUNCTIONALITY`
--

LOCK TABLES `FUNCTIONALITY` WRITE;
/*!40000 ALTER TABLE `FUNCTIONALITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `FUNCTIONALITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `name` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(12) NOT NULL,
  `token` varchar(8) DEFAULT NULL,
  `type` varchar(3) NOT NULL,
  `isActive` binary(1) NOT NULL,
  `forcePassReset` binary(1) NOT NULL,
  `shouldChangePassword` binary(1) NOT NULL,
  `lastLogonTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `failedLogins` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES ('Afonso','Praça','afonsoinfo@gmail.com','321','6f8e4c6f','USR','0','1','1','2013-07-27 01:56:31',0),('Paulo','Cesar','paulo.inacio@uniriotec.br','123',NULL,'USR','0','1','1','0000-00-00 00:00:00',0),('Paulo','Cesar','pc@pc.com','123456',NULL,'USR','0','1','1','2013-08-07 18:46:04',0);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLE`
--

DROP TABLE IF EXISTS `ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLE` (
  `type` int(11) NOT NULL,
  `roleTag` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLE`
--

LOCK TABLES `ROLE` WRITE;
/*!40000 ALTER TABLE `ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TICKET`
--

DROP TABLE IF EXISTS `TICKET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TICKET` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `systemKey` varchar(45) NOT NULL,
  `componentKey` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `operador` varchar(45) NOT NULL,
  PRIMARY KEY (`idTicket`),
  UNIQUE KEY `idTicket_UNIQUE` (`idTicket`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TICKET`
--

LOCK TABLES `TICKET` WRITE;
/*!40000 ALTER TABLE `TICKET` DISABLE KEYS */;
INSERT INTO `TICKET` VALUES (2,'Bug na integração','channel','Componente 1','Bug na integração com marketplace',1,'pc@pc.com');
/*!40000 ALTER TABLE `TICKET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMPONENT`
--

DROP TABLE IF EXISTS `COMPONENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPONENT` (
  `componentName` varchar(100) NOT NULL,
  `operadorEmail` varchar(255) NOT NULL,
  `systemId` int(11) NOT NULL,
  PRIMARY KEY (`componentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPONENT`
--

LOCK TABLES `COMPONENT` WRITE;
/*!40000 ALTER TABLE `COMPONENT` DISABLE KEYS */;
INSERT INTO `COMPONENT` VALUES ('Componente 1','pc@pc.com',1),('Componente 2','pc@pc.com',1),('Componente 3','pc@pc.com',1),('Componente 4','pc@pc.com',1),('Componente 5','pc@pc.com',1),('Mapeador','pc@pc.com',1);
/*!40000 ALTER TABLE `COMPONENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYSTEM`
--

DROP TABLE IF EXISTS `SYSTEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SYSTEM` (
  `systemName` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `systemName_UNIQUE` (`systemName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYSTEM`
--

LOCK TABLES `SYSTEM` WRITE;
/*!40000 ALTER TABLE `SYSTEM` DISABLE KEYS */;
INSERT INTO `SYSTEM` VALUES ('channel',1),('checkout',2),('logistics',3),('payments',4),('portal',5),('rates and benefits',6),('search',7),('Sistema 1',10),('xpto',8);
/*!40000 ALTER TABLE `SYSTEM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-07 18:42:20