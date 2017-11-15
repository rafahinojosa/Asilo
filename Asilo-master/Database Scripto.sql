-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: asilo
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `enfermera`
--

DROP TABLE IF EXISTS `enfermera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermera` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `sexo` tinyint(2) NOT NULL,
  `zonaAsignada` tinyint(3) NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermera`
--

LOCK TABLES `enfermera` WRITE;
/*!40000 ALTER TABLE `enfermera` DISABLE KEYS */;
INSERT INTO `enfermera` VALUES (1,'Juanita Perez','1985-02-12','Calle 13',1,1),(2,'Paola Zaragoza','1980-10-24','Avenida 303',1,1),(3,'Carolina Castillo','1989-01-05','Juarez 405',1,2),(7,'Dora Dominguez','1988-07-20','Privada X 193',1,2),(8,'Melissa Morales','1976-12-15','Calle 16',1,1),(9,'Javi','3900-01-12','',1,-1),(10,'Carlitox','3900-05-04','tacos',0,2),(11,'Sung','3912-02-01','Korea',1,1);
/*!40000 ALTER TABLE `enfermera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `id_med` varchar(6) NOT NULL,
  `nombreMed` varchar(45) NOT NULL,
  `cant_disponible` int(11) NOT NULL,
  `proveedor` varchar(45) NOT NULL,
  `dosis` varchar(45) NOT NULL,
  PRIMARY KEY (`id_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id_nota` int(11) NOT NULL,
  `autor` varchar(60) NOT NULL,
  `info` varchar(10000) NOT NULL,
  `involucrados` varchar(60) NOT NULL,
  PRIMARY KEY (`id_nota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operaciones`
--

DROP TABLE IF EXISTS `operaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operaciones` (
  `nombreOp` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `id_Operacion` int(11) NOT NULL,
  PRIMARY KEY (`id_Operacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operaciones`
--

LOCK TABLES `operaciones` WRITE;
/*!40000 ALTER TABLE `operaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `operaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `Nombre` varchar(60) NOT NULL,
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `FechaNacimiento` date NOT NULL,
  `Direccion` varchar(80) NOT NULL,
  `Estado` tinyint(3) NOT NULL,
  `Sexo` tinyint(2) NOT NULL,
  `TipoDeSangre` tinyint(8) NOT NULL,
  `Foto` blob,
  `ZonaAsignada` tinyint(3) NOT NULL,
  `CamaAsignada` tinyint(30) NOT NULL,
  `Notas` int(11) NOT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FKZona_idx` (`ZonaAsignada`),
  CONSTRAINT `FKZona` FOREIGN KEY (`ZonaAsignada`) REFERENCES `zona` (`idZona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES ('Toño Revolicionado',15,'1985-10-21','Lux 200',0,0,0,NULL,3,24,0),('Adle Zamora',16,'1998-08-21','Las moras 4211',0,1,2,NULL,1,17,0),('Kahjiit Wares',17,'1529-01-31','Skyrim 901',0,0,2,NULL,1,18,0),('Skooma deKahjit',18,'1569-09-11','Skyrim 903',0,1,4,NULL,2,19,0),('Outcasto Robato',19,'2017-12-30','MIB 429',0,0,7,NULL,1,3,0);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padecimientos`
--

DROP TABLE IF EXISTS `padecimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `padecimientos` (
  `id_padecimiento` varchar(6) NOT NULL,
  `nombrePad` varchar(45) NOT NULL,
  `FKPaciente` int(11) NOT NULL,
  PRIMARY KEY (`id_padecimiento`),
  KEY `FKPaciente_idx` (`FKPaciente`),
  CONSTRAINT `FKPaciente` FOREIGN KEY (`FKPaciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padecimientos`
--

LOCK TABLES `padecimientos` WRITE;
/*!40000 ALTER TABLE `padecimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `padecimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsable` (
  `nombreResp` varchar(60) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suceso`
--

DROP TABLE IF EXISTS `suceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suceso` (
  `id_suceso` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `emergencia` tinyint(2) NOT NULL,
  `nom_pac` varchar(60) NOT NULL,
  `nom_enf` varchar(60) NOT NULL,
  `info` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id_suceso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suceso`
--

LOCK TABLES `suceso` WRITE;
/*!40000 ALTER TABLE `suceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `suceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona` (
  `idZona` tinyint(3) NOT NULL AUTO_INCREMENT,
  `Camas` tinyint(30) NOT NULL,
  PRIMARY KEY (`idZona`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES (1,30),(2,30),(3,30),(4,30);
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-15 11:03:53
