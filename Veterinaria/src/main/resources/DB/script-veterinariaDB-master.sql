CREATE DATABASE  IF NOT EXISTS `veterinaria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `veterinaria`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: veterinaria
-- ------------------------------------------------------
-- Server version	5.7.27

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `idAppointment` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `vet_idUser_vet` varchar(45) NOT NULL,
  `pet_idPet` int(11) NOT NULL,
  `prescription` varchar(8000) NOT NULL,
  PRIMARY KEY (`idAppointment`),
  KEY `fk_appointment_vet1_idx` (`vet_idUser_vet`),
  KEY `fk_appointment_pet1_idx` (`pet_idPet`),
  CONSTRAINT `fk_appointment_pet1` FOREIGN KEY (`pet_idPet`) REFERENCES `pet` (`idPet`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_vet1` FOREIGN KEY (`vet_idUser_vet`) REFERENCES `vet` (`idUser_vet`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,12,12,1998,'jerrycf',21,'hola mundo'),(2,12,12,12,'jerrycf',21,'chiale'),(4,25,10,2019,'jerrycf',21,'Aún no establecido'),(6,30,10,2019,'jerrycf',24,'Aún no establecido'),(7,14,10,2019,'jerrycf',24,'Aún no establecido'),(8,24,10,2019,'jerrycf',25,'Aún no establecido'),(9,30,10,2019,'bryanblancas',26,'Aún no establecido'),(10,30,10,2019,'jerrycf',26,'Aún no establecido'),(11,24,10,2019,'bryanblancas',24,'Aún no establecido');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificate` (
  `certificate` varchar(3000) NOT NULL,
  `user_data_idUser` varchar(45) NOT NULL,
  PRIMARY KEY (`user_data_idUser`),
  KEY `fk_certificate_user_data1_idx` (`user_data_idUser`),
  CONSTRAINT `fk_certificate_user_data1` FOREIGN KEY (`user_data_idUser`) REFERENCES `user_data` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES ('MIIE9jCCA96gAwIBAgIUBLS3hYlrPXIoSd8ngfz7TmTwzSMwDQYJKoZIhvcNAQELBQAwgcAxCzAJBgNVBAYTAk1YMQ0wCwYDVQQIDARDRE1YMQ0wCwYDVQQHDARDRE1YMQ4wDAYDVQQRDAUwMTIzNDENMAsGA1UECQwEQ0RNWDEVMBMGA1UECgwMb3JnYW5pemF0aW9uMRUwEwYDVQQLDAxvcmdhbml6YXRpb24xEDAOBgNVBAMMB2RvbWluaW8xFDASBgNVBAMMC3d3dy5kb21pbmlvMR4wHAYJKoZIhvcNAQkBFg9icnlhbkBnbWFpbC5jb20wHhcNMTkxMDE2MDEzODEwWhcNMjAxMDE1MDEzODEwWjCBwDELMAkGA1UEBhMCTVgxDTALBgNVBAgMBENETVgxDTALBgNVBAcMBENETVgxDjAMBgNVBBEMBTAxMjM0MQ0wCwYDVQQJDARDRE1YMRUwEwYDVQQKDAxvcmdhbml6YXRpb24xFTATBgNVBAsMDG9yZ2FuaXphdGlvbjEQMA4GA1UEAwwHZG9taW5pbzEUMBIGA1UEAwwLd3d3LmRvbWluaW8xHjAcBgkqhkiG9w0BCQEWD2JyeWFuQGdtYWlsLmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKgF68eTPnNSz+tmlxCCa6vVkpa0W9IW+ohPZB6BkDBMl/ZHQwELL43B1tSZDTAW9eWhbpMKYCaYBSAbUpJ5bKTot4INB1rm/Q8SNgTAhUSS9teDCRKFPfZrpewhhhjfJe1qQwC94SkpE0KOxprTCrNEcVLSVAInKxeArgRJvMdelfbgsQftdnOMCiFC3mp33VgXOFbctA8wZXvrs3sgqH4yfv46v5MLSN9zUiL7MTSjGtWK3WLP04cGy/SK5ri4DCnP1Sea/Czzk62ndYypfqayBm3ewgUVppD61IiVWuT5hDFr0ziq2gM9m2pDG35uR8/xEilsFavtdGDRCcSvloUCAwEAAaOB5TCB4jAdBgNVHQ4EFgQUt3IsQ42UsQdGWMdBAAF+FOcpoEwwHwYDVR0jBBgwFoAUt3IsQ42UsQdGWMdBAAF+FOcpoEwwEQYIKwYBBQUHARgEBTADAgEFMBIGA1UdEwEB/wQIMAYBAf8CAQEwDgYDVR0PAQH/BAQDAgWgMEgGA1UdJQEB/wQ+MDwGCCsGAQUFBwMBBggrBgEFBQcDAgYIKwYBBQUHAxEGCCsGAQUFBwMHBggrBgEFBQcDBgYIKwYBBQUHAwUwHwYDVR0RBBgwFoIHZG9taW5pb4ILd3d3LmRvbWluaW8wDQYJKoZIhvcNAQELBQADggEBAJzDQVHZUI+/x2dQ5KWJYjjZ4Diba56X0hAqmaBtB6prpynMFPI3EVuRrmC1riFWWHS0jicZ/E027QnC450R+LWPjlzoMjwrjSIqInyE0Wr+MR6KilhOmRzJZhxQPd6yf08DITmLbRPA49F42Bj5jBdlJnsIuBh174+7E/2F5iSDAkHqYDF1xxVhKKUgQkoJTQ6gx7Cd63ZmIPzfsRW302oST11zNd3Eydh6CLPpGRrfJU3prX0aKjn1CwH4hp1CjQEmkp6HkOWYcgFm8iUUUOyd0YRI3y2HjugJPJkiCnBuXmk0T8Uhn5KqrISDZfcaFGCV/zVXfS1H9i9Wclw+RWQ=','Diego Arturo MG');
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pet` (
  `idPet` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `day_birth` int(11) NOT NULL,
  `month_birth` int(11) NOT NULL,
  `year_birth` int(11) NOT NULL,
  `user_idUser_client` varchar(45) NOT NULL,
  `is_alive` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`idPet`),
  KEY `fk_pet_user1_idx` (`user_idUser_client`),
  CONSTRAINT `fk_pet_user1` FOREIGN KEY (`user_idUser_client`) REFERENCES `user` (`idUser_client`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (21,'asdf',5,4,2002,'Diego Arturo MG',1,'gato'),(24,'gato1',3,2,2003,'Diego Arturo MG',1,'gato'),(25,'hurón',4,4,2000,'Diego Arturo MG',1,'raton'),(26,'muñeca',3,4,2001,'bryanisrael',1,'gato');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `password` varchar(45) NOT NULL,
  `idUser_client` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser_client`),
  CONSTRAINT `fk_user_user_data` FOREIGN KEY (`idUser_client`) REFERENCES `user_data` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1234','bryanisrael'),('Arturo2121','Diego Arturo MG');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_data` (
  `name` varchar(45) NOT NULL,
  `first_lastname` varchar(45) NOT NULL,
  `second_lastname` varchar(45) DEFAULT NULL,
  `day_birth` int(11) NOT NULL,
  `month_birth` int(11) NOT NULL,
  `year_birth` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `idUser` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_data`
--

LOCK TABLES `user_data` WRITE;
/*!40000 ALTER TABLE `user_data` DISABLE KEYS */;
INSERT INTO `user_data` VALUES ('bryan','israel','blancas',8,8,1997,'bryanblancas@hotmail.com','bryanblancas'),('bryan israel','blancas','pérez',7,6,1974,'bryanisrael@hotmail.com','bryanisrael'),('Diego Arturo','Morales','Gonzalez',21,10,1996,'diegoarturo2121@gmail.com','Diego Arturo MG'),('Gerardo','Carrillo','Fernández',30,10,1995,'gerardocf.ipn@gmail.com','jerrycf');
/*!40000 ALTER TABLE `user_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vet`
--

DROP TABLE IF EXISTS `vet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vet` (
  `password` varchar(45) NOT NULL,
  `idUser_vet` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser_vet`),
  CONSTRAINT `fk_vet_user_data1` FOREIGN KEY (`idUser_vet`) REFERENCES `user_data` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vet`
--

LOCK TABLES `vet` WRITE;
/*!40000 ALTER TABLE `vet` DISABLE KEYS */;
INSERT INTO `vet` VALUES ('1234','bryanblancas'),('Jerry123','jerrycf');
/*!40000 ALTER TABLE `vet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-23 14:27:47
