CREATE DATABASE  IF NOT EXISTS `locadora` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `locadora`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: locadora
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `editoras`
--

DROP TABLE IF EXISTS `editoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editoras` (
  `id_editora` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_editora`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editoras`
--

LOCK TABLES `editoras` WRITE;
/*!40000 ALTER TABLE `editoras` DISABLE KEYS */;
INSERT INTO `editoras` VALUES (1,'indefinido',NULL),(2,'Editora Globo','Brasil'),(3,'Penguin Random House','Estados Unidos'),(4,'HarperCollins','Reino Unido'),(5,'Record','Brasil'),(6,'Editora Companhia das Letras','Brasil'),(7,'Alfaguara','Espanha'),(8,'Editora Rocco','Brasil'),(9,'Macmillan','Estados Unidos'),(10,'Editora Planeta','Espanha'),(11,'Leya','Portugal'),(12,'Editora Sextante','Brasil'),(13,'Oxford University Press','Reino Unido'),(14,'Hachette Livre','França'),(15,'Editora Martin Claret','Brasil'),(16,'Cengage Learning','Estados Unidos'),(17,'Editora Arqueiro','Brasil'),(18,'Bloomsbury Publishing','Reino Unido'),(19,'Grupo Editorial Record','Brasil'),(20,'Simon & Schuster','Estados Unidos'),(21,'Editora Panda Books','Brasil'),(22,'Editora Ponto de Leitura','Brasil'),(23,'Editora Aleph','Brasil'),(24,'Wiley','Estados Unidos'),(25,'Editora Intrínseca','Brasil'),(26,'Editora Principis','Brasil'),(27,'Editora Novo Conceito','Brasil'),(28,'Editora Abril','Brasil'),(29,'Glenat','França'),(30,'Editora JBC','Brasil');
/*!40000 ALTER TABLE `editoras` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER before_editora_delete
BEFORE DELETE ON editoras
FOR EACH ROW
BEGIN
    UPDATE produtos
    SET id_editora = 1
    WHERE id_editora = OLD.id_editora;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 19:15:51
