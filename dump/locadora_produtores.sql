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
-- Table structure for table `produtores`
--

DROP TABLE IF EXISTS `produtores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtores` (
  `id_produtor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `nacionalidade` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_produtor`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtores`
--

LOCK TABLES `produtores` WRITE;
/*!40000 ALTER TABLE `produtores` DISABLE KEYS */;
INSERT INTO `produtores` VALUES (1,'indefinido',NULL,NULL),(2,'José da Silva',NULL,'Brasil'),(3,'Maria Oliveira',NULL,'Portugal'),(4,'Carlos Santos',NULL,'Brasil'),(5,'Fernanda Costa',NULL,'Brasil'),(6,'Paulo Lima',NULL,'Brasil'),(7,'Julia Pereira',NULL,'Angola'),(8,'Rodrigo Alves',NULL,'Brasil'),(9,'Luana Martins',NULL,'Moçambique'),(10,'Marcos Ribeiro',NULL,'Brasil'),(11,'Tatiane Rocha',NULL,'Brasil'),(12,'Gustavo Mendes',NULL,'Argentina'),(13,'Beatriz Fernandes',NULL,'Espanha'),(14,'Felipe Costa',NULL,'Brasil'),(15,'Isabela Oliveira',NULL,'Brasil'),(16,'Lucas Pereira',NULL,'Brasil'),(17,'Mariana Santos',NULL,'Brasil'),(18,'Ricardo Lima',NULL,'Portugal'),(19,'Carla Ribeiro',NULL,'Brasil'),(20,'Vinícius Rocha',NULL,'Brasil'),(21,'Fabiana Souza',NULL,'Brasil'),(22,'Rafael Costa',NULL,'Brasil'),(23,'Patricia Lima',NULL,'Brasil'),(24,'Fábio Oliveira',NULL,'Brasil'),(25,'Luciana Pereira',NULL,'Brasil'),(26,'Eduardo Santos',NULL,'Brasil'),(27,'Marcelo Ribeiro',NULL,'Brasil'),(28,'Eliane Fernandes',NULL,'França'),(29,'João Rocha',NULL,'Brasil'),(30,'Marina Souza',NULL,'Brasil'),(31,'Thiago Alves',NULL,'Brasil');
/*!40000 ALTER TABLE `produtores` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER before_produtor_delete
BEFORE DELETE ON produtores
FOR EACH ROW
BEGIN
    UPDATE produtos
    SET id_produtor = 1
    WHERE id_produtor = OLD.id_produtor;
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

-- Dump completed on 2025-04-24 19:15:52
