-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: financeiro
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `tb_categoria_lancamento_caixa`
--

DROP TABLE IF EXISTS `tb_categoria_lancamento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_categoria_lancamento_caixa` (
  `Categoria_Lancamento_Caixa_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria_Lancamento_Caixa_Descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Categoria_Lancamento_Caixa_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria_lancamento_caixa`
--

LOCK TABLES `tb_categoria_lancamento_caixa` WRITE;
/*!40000 ALTER TABLE `tb_categoria_lancamento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_categoria_lancamento_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conta`
--

DROP TABLE IF EXISTS `tb_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_conta` (
  `Conta_id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Conta_Id` int(11) DEFAULT NULL,
  `Conta_Nome` varchar(45) DEFAULT NULL,
  `Conta_Banco` varchar(50) DEFAULT NULL,
  `Conta_Agencia` varchar(50) DEFAULT NULL,
  `Conta_Numero` varchar(50) DEFAULT NULL,
  `Conta_Status` tinyint(1) DEFAULT NULL,
  `Conta_Data_Inicial` date DEFAULT NULL,
  PRIMARY KEY (`Conta_id`),
  KEY `Tipo_Conta_Id_idx` (`Tipo_Conta_Id`),
  CONSTRAINT `Tipo_Conta_Id` FOREIGN KEY (`Tipo_Conta_Id`) REFERENCES `tb_tipo_conta` (`Tipo_Conta_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conta`
--

LOCK TABLES `tb_conta` WRITE;
/*!40000 ALTER TABLE `tb_conta` DISABLE KEYS */;
INSERT INTO `tb_conta` VALUES (4,1,'Lucas','Bradesco','09876','123',1,'2017-05-30');
/*!40000 ALTER TABLE `tb_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_lancamento_caixa`
--

DROP TABLE IF EXISTS `tb_lancamento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_lancamento_caixa` (
  `Lancamento_Caixa_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Lancamento_Caixa_Id` int(11) DEFAULT NULL,
  `Lancamento_Caixa_Valor` decimal(10,0) DEFAULT NULL,
  `Lancamento_Caixa_Data` date DEFAULT NULL,
  `Lancamento_Caixa_Descricao` varchar(60) DEFAULT NULL,
  `Conta_Id` int(11) DEFAULT NULL,
  `Categoria_Lancamento_Caixa_Id` int(11) DEFAULT NULL,
  `Forma_Pagamento_Id` int(11) DEFAULT NULL,
  `Lancamento_Caixa_Observacoes` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Lancamento_Caixa_Id`),
  KEY `Conta_Id_idx` (`Conta_Id`),
  KEY `Tipo_Lancamento_Caixa_Id_idx` (`Tipo_Lancamento_Caixa_Id`),
  KEY `Categoria_Lancamento_Caixa_Id_idx` (`Categoria_Lancamento_Caixa_Id`),
  KEY `Forma_Pagamento_Id_idx` (`Forma_Pagamento_Id`),
  CONSTRAINT `Categoria_Lancamento_Caixa_Id` FOREIGN KEY (`Categoria_Lancamento_Caixa_Id`) REFERENCES `tb_categoria_lancamento_caixa` (`Categoria_Lancamento_Caixa_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Conta_Id` FOREIGN KEY (`Conta_Id`) REFERENCES `tb_conta` (`Conta_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Forma_Pagamento_Id` FOREIGN KEY (`Forma_Pagamento_Id`) REFERENCES `tb_tipo_forma_pagamento` (`Forma_Pagamento_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Tipo_Lancamento_Caixa_Id` FOREIGN KEY (`Tipo_Lancamento_Caixa_Id`) REFERENCES `tb_tipo_lancamento_caixa` (`Tipo_Lancamento_Caixa_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_lancamento_caixa`
--

LOCK TABLES `tb_lancamento_caixa` WRITE;
/*!40000 ALTER TABLE `tb_lancamento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_lancamento_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_status_lancamento_caixa`
--

DROP TABLE IF EXISTS `tb_status_lancamento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_status_lancamento_caixa` (
  `Lancamento_Caixa_Id` int(11) NOT NULL,
  `Tipo_Status_Lancamento_Caixa_Id` int(11) NOT NULL,
  `Status_Lancamento_Caixa_Data` date DEFAULT NULL,
  PRIMARY KEY (`Tipo_Status_Lancamento_Caixa_Id`,`Lancamento_Caixa_Id`),
  KEY `Tipo_Status_Lancamento_Caixa_Id` (`Lancamento_Caixa_Id`),
  CONSTRAINT `Lancamento_Caixa_Id` FOREIGN KEY (`Lancamento_Caixa_Id`) REFERENCES `tb_lancamento_caixa` (`Lancamento_Caixa_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Tipo_Status_Lancamento_Caixa_Id` FOREIGN KEY (`Tipo_Status_Lancamento_Caixa_Id`) REFERENCES `tb_tipo_status_lancamento_caixa` (`Tipo_Status_Lancamento_Caixa_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_status_lancamento_caixa`
--

LOCK TABLES `tb_status_lancamento_caixa` WRITE;
/*!40000 ALTER TABLE `tb_status_lancamento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_status_lancamento_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_conta`
--

DROP TABLE IF EXISTS `tb_tipo_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_conta` (
  `Tipo_Conta_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Conta_Descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Tipo_Conta_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_conta`
--

LOCK TABLES `tb_tipo_conta` WRITE;
/*!40000 ALTER TABLE `tb_tipo_conta` DISABLE KEYS */;
INSERT INTO `tb_tipo_conta` VALUES (0,'CORRENTE'),(1,'POUPANCA');
/*!40000 ALTER TABLE `tb_tipo_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_forma_pagamento`
--

DROP TABLE IF EXISTS `tb_tipo_forma_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_forma_pagamento` (
  `Forma_Pagamento_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Forma_Pagamento_Descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Forma_Pagamento_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_forma_pagamento`
--

LOCK TABLES `tb_tipo_forma_pagamento` WRITE;
/*!40000 ALTER TABLE `tb_tipo_forma_pagamento` DISABLE KEYS */;
INSERT INTO `tb_tipo_forma_pagamento` VALUES (1,'CORRENTE'),(2,'POUPANCA');
/*!40000 ALTER TABLE `tb_tipo_forma_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_lancamento_caixa`
--

DROP TABLE IF EXISTS `tb_tipo_lancamento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_lancamento_caixa` (
  `Tipo_Lancamento_Caixa_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Lancamento_Caixa_Descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Tipo_Lancamento_Caixa_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_lancamento_caixa`
--

LOCK TABLES `tb_tipo_lancamento_caixa` WRITE;
/*!40000 ALTER TABLE `tb_tipo_lancamento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipo_lancamento_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_status_lancamento_caixa`
--

DROP TABLE IF EXISTS `tb_tipo_status_lancamento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipo_status_lancamento_caixa` (
  `Tipo_Status_Lancamento_Caixa_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Status_Lancamento_Caixa_Descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Tipo_Status_Lancamento_Caixa_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_status_lancamento_caixa`
--

LOCK TABLES `tb_tipo_status_lancamento_caixa` WRITE;
/*!40000 ALTER TABLE `tb_tipo_status_lancamento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipo_status_lancamento_caixa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-30 20:44:30
