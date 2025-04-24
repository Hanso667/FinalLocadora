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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Ana Silva','12345678901','11987654321','Rua das Flores, 123','2025-04-22'),(2,'Carlos Oliveira','23456789012','11976543210','Avenida Brasil, 456','2025-04-22'),(3,'Maria Souza','34567890123','11323456789','Rua dos Lírios, 789','2025-04-22'),(4,'José Santos','45678901234','11234567890','Rua das Palmeiras, 101','2025-04-22'),(5,'Fernanda Costa','56789012345','11999887766','Rua do Sol, 202','2025-04-22'),(6,'Paulo Lima','67890123456','11876543210','Avenida das Américas, 303','2025-04-22'),(7,'Julia Pereira','78901234567','11765432109','Praça da República, 404','2025-04-22'),(8,'Rodrigo Alves','89012345678','11654321098','Rua da Paz, 505','2025-04-22'),(9,'Luana Martins','90123456789','11543210987','Avenida dos Três, 606','2025-04-22'),(10,'Marcos Ribeiro','10234567890','11432109876','Rua do Rio, 707','2025-04-22'),(11,'Tatiane Rocha','21345678902','11321098765','Rua do Porto, 808','2025-04-22'),(12,'Gustavo Mendes','32456789013','11210987654','Rua das Acácias, 909','2025-04-22'),(13,'Beatriz Fernandes','43567890124','11987654321','Rua do Campo, 1010','2025-04-22'),(14,'Felipe Costa','54678901235','11976543210','Avenida Central, 1111','2025-04-22'),(15,'Isabela Oliveira','65789012346','11865432109','Rua da Liberdade, 1212','2025-04-22'),(16,'Lucas Pereira','76890123457','11754321098','Rua da Serra, 1313','2025-04-22'),(17,'Mariana Santos','87901234568','11643210987','Avenida das Palmeiras, 1414','2025-04-22'),(18,'Ricardo Lima','98012345679','11532109876','Rua do Vale, 1515','2025-04-22'),(19,'Carla Ribeiro','09123456780','11421098765','Praça das Águas, 1616','2025-04-22'),(20,'Vinícius Rocha','10234567891','11310987654','Avenida Brasil, 1717','2025-04-22'),(21,'Fabiana Souza','21345678903','11987654321','Rua dos Lírios, 1818','2025-04-22'),(22,'Rafael Costa','32456789014','11976543210','Avenida do Sol, 1919','2025-04-22'),(23,'Patricia Lima','43567890125','11865432109','Rua das Acácias, 2020','2025-04-22'),(24,'Fábio Oliveira','54678901236','11754321098','Avenida dos Três, 2121','2025-04-22'),(25,'Luciana Pereira','65789012347','11643210987','Rua da Liberdade, 2222','2025-04-22'),(26,'Eduardo Santos','76890123458','11532109876','Rua da Paz, 2323','2025-04-22'),(27,'Marcelo Ribeiro','87901234569','11421098765','Rua do Sol, 2424','2025-04-22'),(28,'Eliane Fernandes','98012345680','11310987654','Avenida Central, 2525','2025-04-22'),(29,'João Rocha','09123456781','11987654321','Rua do Rio, 2626','2025-04-22'),(30,'Marina Souza','10234567892','11976543210','Rua das Flores, 2727','2025-04-22'),(31,'Thiago Alves','21345678904','11865432109','Praça da República, 2828','2025-04-22'),(32,'Sílvia Costa','32456789015','11754321098','Avenida das Palmeiras, 2929','2025-04-22'),(33,'Guilherme Pereira','43567890126','11643210987','Rua dos Lírios, 3030','2025-04-22'),(34,'Célia Santos','54678901237','11532109876','Rua do Vale, 3131','2025-04-22'),(35,'Leandro Lima','65789012348','11421098765','Rua do Porto, 3232','2025-04-22'),(36,'Monique Ribeiro','76890123459','11310987654','Rua das Palmeiras, 3333','2025-04-22'),(37,'Tânia Rocha','87901234570','11987654321','Rua do Rio, 3434','2025-04-22'),(38,'Ricardo Mendes','98012345681','11976543210','Avenida Brasil, 3535','2025-04-22'),(39,'Ana Paula Silva','09123456782','11865432109','Rua do Campo, 3636','2025-04-22'),(40,'Caio Oliveira','10234567893','11754321098','Praça das Águas, 3737','2025-04-22'),(41,'Aline Souza','21345678905','11643210987','Avenida dos Três, 3838','2025-04-22'),(42,'Vera Costa','32456789016','11532109876','Rua do Sol, 3939','2025-04-22'),(43,'Juliano Santos','43567890127','11421098765','Rua das Flores, 4040','2025-04-22'),(44,'Eduarda Ribeiro','54678901238','11310987654','Rua do Vale, 4141','2025-04-22'),(45,'Gustavo Oliveira','65789012349','11987654321','Rua do Rio, 4242','2025-04-22'),(46,'Catarina Lima','76890123460','11976543210','Rua da Liberdade, 4343','2025-04-22'),(47,'Fábia Costa','87901234571','11865432109','Avenida Central, 4444','2025-04-22'),(48,'Lucas Rocha','98012345682','11754321098','Rua do Sol, 4545','2025-04-22'),(49,'Simone Santos','09123456783','11643210987','Rua das Acácias, 4646','2025-04-22'),(50,'Ricardo Pereira','10234567894','11532109876','Rua do Campo, 4747','2025-04-22'),(51,'Bruna Ribeiro','21345678906','11421098765','Rua das Palmeiras, 4848','2025-04-22'),(52,'Renata Lima','32456789017','11310987654','Praça da República, 4949','2025-04-22'),(53,'Rogério Costa','43567890128','11987654321','Avenida Brasil, 5050','2025-04-22');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER set_data_criacao_before_insert_clientes
BEFORE INSERT ON clientes
FOR EACH ROW
BEGIN
    IF NEW.data_cadastro IS NULL THEN
        SET NEW.data_cadastro = CURDATE();
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER before_cliente_delete
BEFORE DELETE ON clientes
FOR EACH ROW
BEGIN
    UPDATE vendas
    SET id_cliente = 1
    WHERE id_cliente = OLD.id_cliente;
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
