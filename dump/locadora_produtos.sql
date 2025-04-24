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
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `ano_lancamento` year(4) DEFAULT NULL,
  `duracao` int(11) DEFAULT NULL,
  `id_editora` int(11) NOT NULL DEFAULT 1,
  `id_produtor` int(11) NOT NULL DEFAULT 1,
  `preco` decimal(10,2) DEFAULT 0.00,
  `estoque` int(11) DEFAULT 0,
  PRIMARY KEY (`id_produto`),
  KEY `id_editora` (`id_editora`),
  KEY `id_produtor` (`id_produtor`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`id_editora`) REFERENCES `editoras` (`id_editora`),
  CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`id_produtor`) REFERENCES `produtores` (`id_produtor`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'O Senhor dos Anéis: A Sociedade do Anel',NULL,178,1,1,12.99,30),(2,'Vingadores: Ultimato',NULL,181,1,1,15.00,25),(3,'A Origem',NULL,148,1,1,10.00,40),(4,'Jurassic Park',NULL,127,1,1,8.50,50),(5,'O Rei Leão',NULL,88,1,1,7.99,60),(6,'Forrest Gump',NULL,142,1,1,11.99,20),(7,'Matrix',NULL,136,1,1,9.50,35),(8,'Titanic',NULL,195,1,1,13.50,15),(9,'Interestelar',NULL,169,1,1,14.00,30),(10,'Star Wars: O Império Contra-Ataca',NULL,124,1,1,10.50,45),(11,'De Volta para o Futuro',NULL,116,1,1,8.00,50),(12,'Os Incríveis',NULL,115,1,1,9.00,40),(13,'Os Vingadores',NULL,143,1,1,12.00,30),(14,'Piratas do Caribe: A Maldição do Pérola Negra',NULL,143,1,1,11.50,20),(15,'Gladiador',NULL,155,1,1,12.99,25),(16,'O Hobbit: Uma Jornada Inesperada',NULL,169,1,1,13.50,30),(17,'Mad Max: Estrada da Fúria',NULL,120,1,1,10.00,40),(18,'O Exterminador do Futuro 2: O Julgamento Final',NULL,137,1,1,9.99,30),(19,'Jogos Vorazes',NULL,142,1,1,11.00,35),(20,'Harry Potter e a Pedra Filosofal',NULL,152,1,1,14.00,50),(21,'Shrek',NULL,90,1,1,7.99,60),(22,'Avatar',NULL,162,1,1,15.00,10),(23,'O Lobo de Wall Street',NULL,180,1,1,13.00,20),(24,'Coringa',NULL,122,1,1,10.50,30),(25,'O Profissional',NULL,110,1,1,9.00,40),(26,'O Grande Lebowski',NULL,117,1,1,8.50,50),(27,'Kill Bill: Volume 1',NULL,111,1,1,10.00,25),(28,'Batman: O Cavaleiro das Trevas',NULL,152,1,1,12.99,30),(29,'Os Suspeitos',NULL,106,1,1,8.00,45),(30,'A Vida é Bela',NULL,116,1,1,7.50,50);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-23 22:18:02
