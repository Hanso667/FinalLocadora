-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: locadora
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `tipo` enum('admin','funcionario') DEFAULT 'funcionario',
  `data_criacao` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','adm@admin.com','admin','admin','2025-04-16'),(2,'João Silva','joao.silva1@email.com','senha123','admin','2025-04-22'),(3,'Maria Oliveira','maria.oliveira2@email.com','senha456','funcionario','2025-04-22'),(4,'Carlos Santos','carlos.santos3@email.com','senha789','funcionario','2025-04-22'),(5,'Fernanda Costa','fernanda.costa4@email.com','senha321','admin','2025-04-22'),(6,'Paulo Lima','paulo.lima5@email.com','senha654','funcionario','2025-04-22'),(7,'Julia Pereira','julia.pereira6@email.com','senha987','funcionario','2025-04-22'),(8,'Rodrigo Alves','rodrigo.alves7@email.com','senha135','admin','2025-04-22'),(9,'Luana Martins','luana.martins8@email.com','senha246','funcionario','2025-04-22'),(10,'Marcos Ribeiro','marcos.ribeiro9@email.com','senha369','funcionario','2025-04-22'),(11,'Tatiane Rocha','tatiane.rocha10@email.com','senha753','admin','2025-04-22'),(12,'Gustavo Mendes','gustavo.mendes11@email.com','senha159','funcionario','2025-04-22'),(13,'Beatriz Fernandes','beatriz.fernandes12@email.com','senha258','funcionario','2025-04-22'),(14,'Felipe Costa','felipe.costa13@email.com','senha357','funcionario','2025-04-22'),(15,'Isabela Oliveira','isabela.oliveira14@email.com','senha468','admin','2025-04-22'),(16,'Lucas Pereira','lucas.pereira15@email.com','senha579','funcionario','2025-04-22'),(17,'Mariana Santos','mariana.santos16@email.com','senha680','funcionario','2025-04-22'),(18,'Ricardo Lima','ricardo.lima17@email.com','senha791','admin','2025-04-22'),(19,'Carla Ribeiro','carla.ribeiro18@email.com','senha802','funcionario','2025-04-22'),(20,'Vinícius Rocha','vinicius.rocha19@email.com','senha913','funcionario','2025-04-22'),(21,'Fabiana Souza','fabiana.souza20@email.com','senha024','admin','2025-04-22'),(22,'Rafael Costa','rafael.costa21@email.com','senha135','funcionario','2025-04-22'),(23,'Patricia Lima','patricia.lima22@email.com','senha246','funcionario','2025-04-22'),(24,'Fábio Oliveira','fabio.oliveira23@email.com','senha357','admin','2025-04-22'),(25,'Luciana Pereira','luciana.pereira24@email.com','senha468','funcionario','2025-04-22'),(26,'Eduardo Santos','eduardo.santos25@email.com','senha579','funcionario','2025-04-22'),(27,'Marcelo Ribeiro','marcelo.ribeiro26@email.com','senha680','admin','2025-04-22'),(28,'Eliane Fernandes','eliane.fernandes27@email.com','senha791','funcionario','2025-04-22'),(29,'João Rocha','joao.rocha28@email.com','senha802','funcionario','2025-04-22'),(30,'Marina Souza','marina.souza29@email.com','senha913','admin','2025-04-22');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER set_data_criacao_before_insert
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    IF NEW.data_criacao IS NULL THEN
        SET NEW.data_criacao = CURDATE();
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER before_usuario_delete
BEFORE DELETE ON usuarios
FOR EACH ROW
BEGIN
    UPDATE vendas
    SET id_usuario = 1
    WHERE id_usuario = OLD.id_usuario;
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

-- Dump completed on 2025-04-23 22:18:02
