-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: claire7
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` int(255) DEFAULT NULL,
  `postDate` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `headFig` varchar(255) DEFAULT NULL,
  `content` text,
  `tags` varchar(255) DEFAULT NULL,
  `summary` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,'在霓虹国走东闯西，与秋天不期而遇',1,'2018-03-22 00:00:00',77,'img/blog1.jpeg','日本，好像从来没有出现在我的清单上。一方面，我不是广大动漫迷或者剁手党中的一员...日本，好像从来没有出现在我的清单上。一方面，我不是广大动漫迷或者剁手党中的一员...\n日本，好像从来没有出现在我的清单上。一方面，我不是广大动漫迷或者剁手党中的一员...\n','2017, Japan','日本，好像从来没有出现在我的清单上。一方面，我不是广大动漫迷或者剁手党中的一员...'),(3,'#我的2017#拥抱大好河山正当时',1,'2017-12-27 23:40:43',22,'img/blog2.jpeg','想了很久不知道怎么开头，感觉离16年的总结没过多久，怎么17年就要这样子匆匆接近尾声。想了很久不知道怎么开头，感觉离16年的总结没过多久，怎么17年就要这样子匆匆接近尾声。想了很久不知道怎么开头，感觉离16年的总结没过多久，怎么17年就要这样子匆匆接近尾声。','2017, travel','想了很久不知道怎么开头，感觉离16年的总结没过多久，怎么17年就要这样子匆匆接近尾声。'),(4,'[南山Nathan]北方，是挪威的雨',1,'2017-10-31 00:00:00',3422,'img/blog2.jpeg','这是一篇很个人化的游记。\n如果想来找攻略的，请直接看游记最后部分。\n但我建议你从头读起，倒不是我的文字有多优美，而是随着我的情绪和心态一起看我拍的照片和所写的文字，兴许会带给你一个不一样的挪威。\n然后，\n也许你就马上去搜寻挪威的机票和酒店，\n怀揣着罗弗敦群岛和看极光的梦想，出发！','#2017','这是一篇很个人化的游记。\n如果想来找攻略的，请直接看游记最后部分。\n但我建议你从头读起，倒不是我的文字有多优美，而是随着我的情绪和心态一起看我拍的照片和所写的文字，兴许会带给你一个不一样的挪威。\n然后，\n也许你就马上去搜寻挪威的机票和酒店，\n怀揣着罗弗敦群岛和看极光的梦想，出发！'),(5,'这才是法国最美的地方——圣米歇尔山',1,'2017-04-25 00:00:00',33,'img/blog4.jpeg','我最早听说圣米歇尔山，是伴随着这样一句话：“没有到过圣米歇尔山，就不算真正到过法国”。这样的评价，几乎就是在说：圣米歇尔山才是法国的标志。','法国','我最早听说圣米歇尔山，是伴随着这样一句话：“没有到过圣米歇尔山，就不算真正到过法国”。这样的评价，几乎就是在说：圣米歇尔山才是法国的标志。'),(6,'东寨镇与情人谷',3,'2018-01-16 00:00:00',88,'img/blog4.jpeg','2017年夏山西、内蒙古避暑之旅（4）\n7月10日我们离开忻府区去宁武县的东寨镇，准备去爬管涔山的主峰——芦芽山',NULL,'2017年夏山西、内蒙古避暑之旅（4）\n7月10日我们离开忻府区去宁武县的东寨镇，准备去爬管涔山的主峰——芦芽山');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baby_info`
--

DROP TABLE IF EXISTS `baby_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baby_info` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `profile` varchar(255) DEFAULT NULL COMMENT '头像',
  `country` varchar(255) DEFAULT NULL COMMENT '国籍',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `partner` varchar(255) DEFAULT NULL COMMENT '伴侣',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baby_info`
--

LOCK TABLES `baby_info` WRITE;
/*!40000 ALTER TABLE `baby_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `baby_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `description` text,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'claire','1999-11-09 00:00:00','male','articleList/images/avatar.jpg','my name is claire.','12345'),(2,'Ted','1922-08-27 00:00:00','female','articleList/images/avatar.jpg',NULL,NULL),(3,'Jerry','1768-02-18 00:00:00','male','articleList/images/avatar.jpg',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-20 19:36:46
