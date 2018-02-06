CREATE DATABASE  IF NOT EXISTS `uvrdata` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `uvrdata`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: uvrdata
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.22-MariaDB

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
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `fecha_servidor` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_movil` date NOT NULL,
  `fecha_captura_gps` date NOT NULL,
  `posicion` point NOT NULL,
  `ubicacion` tinyint(1) NOT NULL,
  `frecuencia` double NOT NULL,
  `lectura` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (1,1,'Julian','activo','2017-10-20 03:04:53','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2821001613888'),(2,1,'Julian','activo','2017-10-20 03:06:04','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2821001613888'),(3,1,'Julian','activo','2017-10-20 03:06:05','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(4,1,'Julian','activo','2017-10-20 03:06:15','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(5,1,'Julian','activo','2017-10-20 03:06:17','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(6,1,'Julian','activo','2017-10-20 03:06:18','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(7,1,'Julian','activo','2017-10-20 03:06:20','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(8,1,'Julian','activo','2017-10-20 03:06:21','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(9,1,'Julian','activo','2017-10-20 03:06:23','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(10,1,'Julian','activo','2017-10-20 03:06:24','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2821001613888'),(11,1,'Julian','activo','2017-10-20 03:06:25','2017-10-19','2017-10-19','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2821001613888'),(12,1,'Julian','activo','2017-10-22 02:12:42','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(13,1,'Julian','activo','2017-10-22 02:12:43','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2826626785554'),(14,1,'Julian','activo','2017-10-22 02:12:45','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2828501842776'),(15,1,'Julian','activo','2017-10-22 02:12:46','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(16,1,'Julian','activo','2017-10-22 02:12:48','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(17,1,'Julian','activo','2017-10-22 02:12:49','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2826626785554'),(18,1,'Paola y su cerveza','activo','2017-10-22 02:13:19','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(19,1,'Paola y su cerveza','activo','2017-10-22 02:13:20','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(20,1,'Paola y su cerveza','activo','2017-10-22 02:13:22','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.282287667111'),(21,1,'Paola y su cerveza','activo','2017-10-22 02:13:23','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2819126556666'),(22,1,'Paola y su cerveza','activo','2017-10-22 02:13:24','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(23,1,'Paola y su cerveza','activo','2017-10-22 02:13:26','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(24,1,'Paola y su cerveza','activo','2017-10-22 02:13:27','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332'),(25,1,'Paola y su cerveza','activo','2017-10-22 02:13:28','2017-10-21','2017-10-21','\0\0\0\0\0\0\0g\Å&\è\å–@Ÿ\Ý\ÆŽ\'S@',0,1000,'3.2824751728332');
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Paola','andree709@hotmail.com','1234',''),(2,'Paola','andree709@hotmail.com','1234',''),(3,'jjjjjjj','JJJ@','jjjj',''),(5,'paola','Andree709q@h','1234','andrea12'),(6,'paola','@1324','1234','andrea'),(7,'paola','Andree@','1234','linda');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 14:59:45
