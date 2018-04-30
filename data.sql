CREATE DATABASE  IF NOT EXISTS `techstile` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `techstile`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: techstile
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id_branch` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_code` varchar(4) DEFAULT NULL,
  `branch_name` varchar(45) DEFAULT NULL,
  `branch_place` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `branch_cat` datetime DEFAULT NULL,
  `branch_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_branch`),
  UNIQUE KEY `branch_code_UNIQUE` (`branch_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'bc1','branchname1','branchplace1',0,NULL,NULL),(2,'bc2','branchname1','branchname2',0,NULL,NULL);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_mobile` bigint(20) DEFAULT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `customer_cat` datetime DEFAULT NULL,
  `customer_uat` datetime DEFAULT NULL,
  `customer_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `customer_mobile_UNIQUE` (`customer_mobile`),
  KEY `fk_customer_customer_type1_idx` (`customer_type_id`),
  CONSTRAINT `fk_customer_customer_type1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`id_customer_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,9900000000,'customer1',0,NULL,NULL,1),(2,8800000000,'customer2',0,NULL,NULL,1),(3,7700000000,'customer3',0,NULL,NULL,1),(4,6600000000,'customer4',0,NULL,NULL,1),(5,5500000000,'customer5',0,NULL,NULL,2),(6,4400000000,'customer6',0,NULL,NULL,2),(7,3300000000,'customer7',0,NULL,NULL,3),(8,2200000000,'customer8',0,NULL,NULL,4),(9,1100000000,'customer9',0,NULL,NULL,4);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_type` (
  `id_customer_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `customer_type_cat` datetime DEFAULT NULL,
  `customer_type_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_customer_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Regular',0,NULL,NULL),(2,'Business',0,NULL,NULL),(3,'VIP',0,NULL,NULL),(4,'Bulk',0,NULL,NULL);
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dyeing_color`
--

DROP TABLE IF EXISTS `dyeing_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dyeing_color` (
  `id_dyeing_color` bigint(20) NOT NULL AUTO_INCREMENT,
  `dyeing_color_number` int(11) DEFAULT NULL,
  `dyeing_color_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `dyeing_color_cat` datetime DEFAULT NULL,
  `dyeing_color_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_dyeing_color`),
  UNIQUE KEY `dyeing_color_number_UNIQUE` (`dyeing_color_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dyeing_color`
--

LOCK TABLES `dyeing_color` WRITE;
/*!40000 ALTER TABLE `dyeing_color` DISABLE KEYS */;
INSERT INTO `dyeing_color` VALUES (1,1,'Red',0,NULL,NULL),(2,2,'Blue',0,NULL,NULL),(3,3,'Black',0,NULL,NULL),(4,4,'Brown',0,NULL,NULL),(5,5,'Yellow',0,NULL,NULL);
/*!40000 ALTER TABLE `dyeing_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id_item` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_qr_code` varchar(45) DEFAULT NULL,
  `item_total_amount` int(11) DEFAULT NULL,
  `item_should_deliver_at` datetime DEFAULT NULL,
  `item_delivered_at` datetime DEFAULT NULL,
  `is_quick_delivery` tinyint(4) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_cat` datetime DEFAULT NULL,
  `item_uat` datetime DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  `item_type_id` bigint(20) NOT NULL,
  `item_status_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_item`),
  KEY `fk_item_order1_idx` (`order_id`),
  KEY `fk_item_item_type1_idx` (`item_type_id`),
  KEY `fk_item_status1_idx` (`item_status_id`),
  CONSTRAINT `fk_item_item_type1` FOREIGN KEY (`item_type_id`) REFERENCES `item_type` (`id_item_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_status1` FOREIGN KEY (`item_status_id`) REFERENCES `item_status` (`id_item_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'1000000',25,NULL,NULL,NULL,0,NULL,NULL,1,1,2);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_category` (
  `id_item_category` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_category_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_category_cat` datetime DEFAULT NULL,
  `item_category_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_category`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES (1,'Men',0,NULL,NULL),(2,'Women',0,NULL,NULL),(3,'Other',0,NULL,NULL);
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_dyeing_color`
--

DROP TABLE IF EXISTS `item_dyeing_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_dyeing_color` (
  `id_item_dyeing_color` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `dyeing_color_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_dyeing_color_cat` datetime DEFAULT NULL,
  `item_dyeing_color_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_dyeing_color`),
  KEY `fk_item_dyeing_color_dyeing_color1_idx` (`dyeing_color_id`),
  KEY `fk_item_dyeing_color_item1_idx` (`item_id`),
  CONSTRAINT `fk_item_dyeing_color_dyeing_color1` FOREIGN KEY (`dyeing_color_id`) REFERENCES `dyeing_color` (`id_dyeing_color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_dyeing_color_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_dyeing_color`
--

LOCK TABLES `item_dyeing_color` WRITE;
/*!40000 ALTER TABLE `item_dyeing_color` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_dyeing_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_remark`
--

DROP TABLE IF EXISTS `item_remark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_remark` (
  `id_item_remark` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `remark_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_remark_cat` datetime DEFAULT NULL,
  `item_remark_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_remark`),
  KEY `fk_item_remark_item1_idx` (`item_id`),
  KEY `fk_item_remark_remark1_idx` (`remark_id`),
  CONSTRAINT `fk_item_remark_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_remark_remark1` FOREIGN KEY (`remark_id`) REFERENCES `remark` (`id_remark`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_remark`
--

LOCK TABLES `item_remark` WRITE;
/*!40000 ALTER TABLE `item_remark` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_remark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_service_scan`
--

DROP TABLE IF EXISTS `item_service_scan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_service_scan` (
  `id_item_service_scan` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `service_individual_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `item_service_scan_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_service_scan_cat` datetime DEFAULT NULL,
  `item_service_scan_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_service_scan`),
  KEY `fk_item_service_scan_item1_idx` (`item_id`),
  KEY `fk_item_service_scan_service1_idx` (`service_individual_id`),
  KEY `fk_item_service_scan_user1_idx` (`user_id`),
  CONSTRAINT `fk_item_service_scan_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_service_scan_service1` FOREIGN KEY (`service_individual_id`) REFERENCES `service_individual` (`id_service_individual`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_service_scan_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_service_scan`
--

LOCK TABLES `item_service_scan` WRITE;
/*!40000 ALTER TABLE `item_service_scan` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_service_scan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_service_type`
--

DROP TABLE IF EXISTS `item_service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_service_type` (
  `id_item_service_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `service_type_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_service_type_cat` datetime DEFAULT NULL,
  `item_service_type_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_service_type`),
  KEY `fk_item_service_type_item1_idx` (`item_id`),
  KEY `fk_item_service_type_service_type1_idx` (`service_type_id`),
  CONSTRAINT `fk_item_service_type_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_service_type_service_type1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_service_type`
--

LOCK TABLES `item_service_type` WRITE;
/*!40000 ALTER TABLE `item_service_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_status`
--

DROP TABLE IF EXISTS `item_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_status` (
  `id_item_status` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_status_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_status_cat` datetime DEFAULT NULL,
  `item_status_uat` datetime DEFAULT NULL,
  `item_status_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item_status`),
  UNIQUE KEY `item_status_order_UNIQUE` (`item_status_order`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_status`
--

LOCK TABLES `item_status` WRITE;
/*!40000 ALTER TABLE `item_status` DISABLE KEYS */;
INSERT INTO `item_status` VALUES (1,'Tagging',0,NULL,NULL,1),(2,'Processing',0,NULL,NULL,2),(3,'Completed',0,NULL,NULL,3),(4,'Delivered',0,NULL,NULL,4),(5,'Removed',0,NULL,NULL,5);
/*!40000 ALTER TABLE `item_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_type`
--

DROP TABLE IF EXISTS `item_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_type` (
  `id_item_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(45) DEFAULT NULL,
  `item_type_image_link` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_type_cat` datetime DEFAULT NULL,
  `item_type_uat` datetime DEFAULT NULL,
  `item_category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_item_type`),
  KEY `fk_item_type_item_category1_idx` (`item_category_id`),
  CONSTRAINT `fk_item_type_item_category1` FOREIGN KEY (`item_category_id`) REFERENCES `item_category` (`id_item_category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_type`
--

LOCK TABLES `item_type` WRITE;
/*!40000 ALTER TABLE `item_type` DISABLE KEYS */;
INSERT INTO `item_type` VALUES (1,'Shirt',NULL,0,NULL,NULL,1),(2,'T-Shirt',NULL,0,NULL,NULL,1),(3,'Pant',NULL,0,NULL,NULL,1),(4,'Saree',NULL,0,NULL,NULL,2),(5,'T-Shirt',NULL,0,NULL,NULL,2),(6,'Kurta',NULL,0,NULL,NULL,2),(7,'Towel',NULL,0,NULL,NULL,3),(8,'Bedsheet',NULL,0,NULL,NULL,3),(9,'Pillow',NULL,0,NULL,NULL,3);
/*!40000 ALTER TABLE `item_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_type_service_price`
--

DROP TABLE IF EXISTS `item_type_service_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_type_service_price` (
  `id_item_type_service_price` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_type_service_price` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `item_type_service_price_cat` datetime DEFAULT NULL,
  `item_type_service_price_uat` datetime DEFAULT NULL,
  `item_type_id` bigint(20) NOT NULL,
  `service_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_item_type_service_price`),
  KEY `fk_service_price_item_type1_idx` (`item_type_id`),
  KEY `fk_service_price_service_type1_idx` (`service_type_id`),
  CONSTRAINT `fk_service_price_item_type1` FOREIGN KEY (`item_type_id`) REFERENCES `item_type` (`id_item_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_price_service_type1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_type_service_price`
--

LOCK TABLES `item_type_service_price` WRITE;
/*!40000 ALTER TABLE `item_type_service_price` DISABLE KEYS */;
INSERT INTO `item_type_service_price` VALUES (1,'50',0,NULL,NULL,1,1),(2,'100',0,NULL,NULL,1,2),(3,'60',0,NULL,NULL,1,3),(4,'150',0,NULL,NULL,2,2),(5,'20',0,NULL,NULL,2,3),(6,'30',0,NULL,NULL,2,4),(7,'50',0,NULL,NULL,4,3),(8,'70',0,NULL,NULL,4,4),(9,'200',0,NULL,NULL,4,5),(10,'50',0,NULL,NULL,5,4),(11,'75',0,NULL,NULL,5,5),(12,'100',0,NULL,NULL,5,6),(13,'200',0,NULL,NULL,7,6),(14,'300',0,NULL,NULL,7,7),(15,'400',0,NULL,NULL,7,8),(16,'200',0,NULL,NULL,8,7),(17,'300',0,NULL,NULL,8,8),(18,'400',0,NULL,NULL,8,9);
/*!40000 ALTER TABLE `item_type_service_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_total_amount` int(11) DEFAULT NULL,
  `order_recieved_at` datetime DEFAULT NULL,
  `order_should_deliver_at` datetime DEFAULT NULL,
  `order_delivered_at` datetime DEFAULT NULL,
  `order_bag_number` varchar(45) DEFAULT NULL,
  `is_quick_delivery` tinyint(4) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `order_cat` datetime DEFAULT NULL,
  `order_uat` datetime DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  `order_status_id` bigint(20) NOT NULL,
  `order_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_order_customer1_idx` (`customer_id`),
  KEY `fk_order_branch1_idx` (`branch_id`),
  KEY `fk_order_order_status1_idx` (`order_status_id`),
  KEY `fk_order_order_type1_idx` (`order_type_id`),
  CONSTRAINT `fk_order_branch1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id_branch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id_customer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_status1` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id_order_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_type1` FOREIGN KEY (`order_type_id`) REFERENCES `order_type` (`id_order_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,500,NULL,NULL,NULL,'1',0,0,NULL,NULL,1,1,3,1),(2,700,NULL,NULL,NULL,'2',1,0,NULL,NULL,1,1,1,1),(3,700,NULL,NULL,NULL,'3',0,0,NULL,NULL,2,1,4,1),(4,300,NULL,NULL,NULL,'4',0,0,NULL,NULL,3,1,5,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_status` (
  `id_order_status` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_status_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `order_status_cat` datetime DEFAULT NULL,
  `order_status_uat` datetime DEFAULT NULL,
  `order_status_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_order_status`),
  UNIQUE KEY `order_status_order_UNIQUE` (`order_status_order`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'Order Received',0,NULL,NULL,1),(2,'Tagging',0,NULL,NULL,2),(3,'Processing',0,NULL,NULL,3),(4,'Completed',0,NULL,NULL,4),(5,'Delivered',0,NULL,NULL,5),(6,'Cancelled',0,NULL,NULL,6);
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_type`
--

DROP TABLE IF EXISTS `order_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_type` (
  `id_order_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_type_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `order_type_cat` datetime DEFAULT NULL,
  `order_type_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_order_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_type`
--

LOCK TABLES `order_type` WRITE;
/*!40000 ALTER TABLE `order_type` DISABLE KEYS */;
INSERT INTO `order_type` VALUES (1,'Self',0,NULL,NULL),(2,'PickUp',0,NULL,NULL);
/*!40000 ALTER TABLE `order_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id_payment` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_recieved_amount` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `payment_cat` datetime DEFAULT NULL,
  `payment_uat` datetime DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  `payment_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `fk_payment_order1_idx` (`order_id`),
  KEY `fk_payment_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_payment_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id_payment_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,20,0,NULL,NULL,1,1);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_type`
--

DROP TABLE IF EXISTS `payment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_type` (
  `id_payment_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_type_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `payment_type_cat` datetime DEFAULT NULL,
  `payment_type_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_payment_type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_type`
--

LOCK TABLES `payment_type` WRITE;
/*!40000 ALTER TABLE `payment_type` DISABLE KEYS */;
INSERT INTO `payment_type` VALUES (1,'Cash',0,NULL,NULL),(2,'Card',0,NULL,NULL),(3,'Internet Banking',0,NULL,NULL),(4,'Paytm',0,NULL,NULL),(5,'UPI',0,NULL,NULL);
/*!40000 ALTER TABLE `payment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remark`
--

DROP TABLE IF EXISTS `remark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remark` (
  `id_remark` bigint(20) NOT NULL AUTO_INCREMENT,
  `remark_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `remark_cat` datetime DEFAULT NULL,
  `remark_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_remark`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remark`
--

LOCK TABLES `remark` WRITE;
/*!40000 ALTER TABLE `remark` DISABLE KEYS */;
INSERT INTO `remark` VALUES (1,'Color Faded',0,NULL,NULL),(2,'No Button',0,NULL,NULL),(3,'Torn',0,NULL,NULL);
/*!40000 ALTER TABLE `remark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `role_cat` datetime DEFAULT NULL,
  `role_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',0,NULL,NULL),(2,'DIRECTOR',0,NULL,NULL),(3,'MANAGER',0,NULL,NULL),(4,'WORKER',0,NULL,NULL),(5,'TRANSPORTER',0,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_individual`
--

DROP TABLE IF EXISTS `service_individual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_individual` (
  `id_service_individual` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_individual_order` int(11) DEFAULT NULL,
  `service_individual_name` varchar(45) DEFAULT NULL,
  `service_individual_code` varchar(4) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `service_individual_cat` datetime DEFAULT NULL,
  `service_individual_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_service_individual`),
  UNIQUE KEY `service_order_UNIQUE` (`service_individual_order`),
  UNIQUE KEY `service_code_UNIQUE` (`service_individual_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_individual`
--

LOCK TABLES `service_individual` WRITE;
/*!40000 ALTER TABLE `service_individual` DISABLE KEYS */;
INSERT INTO `service_individual` VALUES (1,1,'Drywash','D',0,NULL,NULL),(2,2,'Darning','dr',0,NULL,NULL),(3,3,'Dying','dye',0,NULL,NULL),(4,4,'Iron','i',0,NULL,NULL),(5,5,'Roll Iron','Ri',0,NULL,NULL),(6,6,'Starch','S',0,NULL,NULL);
/*!40000 ALTER TABLE `service_individual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_type` (
  `id_service_type` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '1. this table is for which type of service like "Dry clean (d)", "Dry clean + Starch (d + S)", "Iron (I)", "Roll Iron", "Dryclean + Darning (d + d/r)"\n',
  `service_type_name` varchar(45) DEFAULT NULL,
  `service_type_code` varchar(45) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `service_type_cat` datetime DEFAULT NULL,
  `service_type_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_service_type`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Drywash','d',0,NULL,NULL),(2,'DryWash + Iron','d+i',0,NULL,NULL),(3,'Iron only','i',0,NULL,NULL),(4,'Starch + Iron','S + i',0,NULL,NULL),(5,'Drywash + Starch + Iron','d + S',0,NULL,NULL),(6,'Roll Iron','Ri',0,NULL,NULL),(7,'Dying','dye',0,NULL,NULL),(8,'Darning','dr',0,NULL,NULL),(9,'Drywash + Darning','d +dr',0,NULL,NULL);
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type_split`
--

DROP TABLE IF EXISTS `service_type_split`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_type_split` (
  `id_service_type_split` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_type_id` bigint(20) NOT NULL,
  `service_individual_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `service_type_split_cat` datetime DEFAULT NULL,
  `service_type_split_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_service_type_split`),
  KEY `fk_service_type_split_service_type1_idx` (`service_type_id`),
  KEY `fk_service_type_split_service1_idx` (`service_individual_id`),
  CONSTRAINT `fk_service_type_split_service1` FOREIGN KEY (`service_individual_id`) REFERENCES `service_individual` (`id_service_individual`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_type_split_service_type1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type_split`
--

LOCK TABLES `service_type_split` WRITE;
/*!40000 ALTER TABLE `service_type_split` DISABLE KEYS */;
INSERT INTO `service_type_split` VALUES (1,1,1,0,NULL,NULL),(2,2,1,0,NULL,NULL),(3,2,4,0,NULL,NULL),(4,3,4,0,NULL,NULL),(5,4,4,0,NULL,NULL),(6,4,6,0,NULL,NULL),(7,5,1,0,NULL,NULL),(8,5,4,0,NULL,NULL),(9,5,6,0,NULL,NULL),(10,6,5,0,NULL,NULL),(11,7,3,0,NULL,NULL),(12,8,2,0,NULL,NULL),(13,9,1,0,NULL,NULL),(14,9,2,0,NULL,NULL);
/*!40000 ALTER TABLE `service_type_split` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp_order`
--

DROP TABLE IF EXISTS `temp_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp_order` (
  `id_temp_order` bigint(20) NOT NULL AUTO_INCREMENT,
  `temp_order_number` bigint(20) DEFAULT NULL,
  `temp_order_received_at` datetime DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `temp_order_cat` datetime DEFAULT NULL,
  `temp_order_uat` datetime DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_temp_order`),
  KEY `fk_temp_order_order1_idx` (`order_id`),
  CONSTRAINT `fk_temp_order_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_order`
--

LOCK TABLES `temp_order` WRITE;
/*!40000 ALTER TABLE `temp_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_mobile` bigint(20) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `user_cat` datetime DEFAULT NULL,
  `user_uat` datetime DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `user_device_identity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `user_device_id_UNIQUE` (`user_device_identity`),
  UNIQUE KEY `user_mobile_UNIQUE` (`user_mobile`),
  KEY `fk_user_branch1_idx` (`branch_id`),
  CONSTRAINT `fk_user_branch1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id_branch`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','123',1,0,'2018-04-22 00:05:50','2018-04-22 00:05:50',NULL,'userdevice1'),(2,'user2','123',2,0,'2018-04-22 00:05:55','2018-04-22 00:05:55',NULL,'userdevice2'),(3,'user3','123',3,0,'2018-04-22 00:05:59','2018-04-22 00:05:59',1,'userdevice3'),(4,'user4','123',4,0,'2018-04-22 00:06:05','2018-04-22 00:06:05',1,'userdevice4'),(5,'user5','123',5,0,'2018-04-22 00:06:10','2018-04-22 00:06:10',1,'userdevice5'),(6,'user6','123',6,0,'2018-04-22 00:06:12','2018-04-22 00:06:12',1,'userdevice6'),(7,'user7','123',7,0,'2018-04-22 00:06:20','2018-04-22 00:06:20',1,'userdevice7'),(8,'user8','123',8,0,'2018-04-22 00:06:25','2018-04-22 00:06:25',1,'userdevice8'),(9,'user9','123',9,0,'2018-04-22 00:06:35','2018-04-22 00:06:35',1,'userdevice9'),(10,'user10','123',10,0,'2018-04-22 00:06:44','2018-04-22 00:06:44',2,'userdevice10'),(11,'user11','123',11,0,'2018-04-22 00:06:50','2018-04-22 00:06:50',2,'userdevice11'),(12,'user12','123',12,0,'2018-04-22 00:06:51','2018-04-22 00:36:49',2,'userdevice12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id_user_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `user_role_cat` datetime DEFAULT NULL,
  `user_role_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_user_role`),
  KEY `fk_user_role_user1_idx` (`user_id`),
  KEY `fk_user_role_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,0,NULL,NULL),(2,2,2,0,NULL,NULL),(3,3,3,0,NULL,NULL),(4,4,3,0,NULL,NULL),(5,5,4,0,NULL,NULL),(6,6,4,0,NULL,NULL),(7,7,4,0,NULL,NULL),(8,8,4,0,NULL,NULL),(9,9,5,0,NULL,NULL),(10,10,3,0,NULL,NULL),(11,11,3,0,NULL,NULL),(12,12,5,0,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_service`
--

DROP TABLE IF EXISTS `worker_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker_service` (
  `id_worker_service` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `service_individual_id` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `worker_service_cat` datetime DEFAULT NULL,
  `worker_service_uat` datetime DEFAULT NULL,
  PRIMARY KEY (`id_worker_service`),
  KEY `fk_user_service_user1_idx` (`user_id`),
  KEY `fk_user_service_service1_idx` (`service_individual_id`),
  CONSTRAINT `fk_user_service_service1` FOREIGN KEY (`service_individual_id`) REFERENCES `service_individual` (`id_service_individual`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_service_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_service`
--

LOCK TABLES `worker_service` WRITE;
/*!40000 ALTER TABLE `worker_service` DISABLE KEYS */;
INSERT INTO `worker_service` VALUES (1,5,1,0,NULL,NULL),(2,6,2,0,NULL,NULL),(3,7,4,0,NULL,NULL),(4,8,4,0,NULL,NULL);
/*!40000 ALTER TABLE `worker_service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-30 13:59:25
