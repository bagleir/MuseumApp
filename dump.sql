-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: localhost    Database: MuseumApp
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Art`
--

DROP TABLE IF EXISTS `Art`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Art` (
  `Identifier` int NOT NULL,
  `NAme` varchar(200) DEFAULT NULL,
  `Description` longtext,
  `Link` varchar(400) DEFAULT NULL,
  `Picture` varchar(255) DEFAULT NULL,
  `Museum` int NOT NULL,
  PRIMARY KEY (`Identifier`),
  KEY `Museum` (`Museum`),
  CONSTRAINT `Art_ibfk_1` FOREIGN KEY (`Museum`) REFERENCES `Museum` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Art`
--

LOCK TABLES `Art` WRITE;
/*!40000 ALTER TABLE `Art` DISABLE KEYS */;
INSERT INTO `Art` VALUES (1,'The Princess and the Monkey','Title: The Princess and the Monkey Date: 1913/1913 Painter: Janis Rozentāls Physical Dimensions: w71 x h147.5 cm Type: Paintings Rights: LNMA','https://en.wikipedia.org/wiki/Princess_with_a_Monkey','Picture/image_20230524181825.png',1),(2,'Open-air dance at the Kokmuiža','Title: Open-air dance at the Kokmuiža Date: 1855/1855 Painter: Kārlis Hūns Physical Dimensions: w27.3 x h21.7 cm Type: Drawings & Watercolours Rights: LNMA','https://artsandculture.google.com/asset/open-air-dance-at-the-kokmui%C5%BEa/zwHCxzbKvTxMjA','Picture/image_20230524181941.png',1),(3,'Drawing. Rocks','Title: Drawing. Rocks Date: 1915/1915 Painter: Rūdolfs Pērle Physical Dimensions: w17.6 x h14.7 cm Type: Drawings & Watercolours Rights: LNMA','https://artsandculture.google.com/asset/drawing-rocks/TQEy1UUeJ1o7-Q','Picture/image_20230524182042.png',1),(4,'After Church','Title: After Church Date: 1894/1894 Physical Dimensions: w103 x h173 cm Painter: Janis Rozentāls Type: Paintings Rights: LNMA ','https://commons.wikimedia.org/wiki/File:Janis_Rozent%C4%81ls_-_After_Church_-_Google_Art_Project.jpg','Picture/image_20230524182056.png',1),(5,'A Woman with a Fan','Title: A Woman with a Fan Date: 1896/1896 Physical Dimensions: w29 x h43.2 cm Painter: Janis Rozentāls Type: Watercolours Rights: LNMA','https://artsandculture.google.com/asset/a-woman-with-a-fan/YQGZzle8G7A_iQ','Picture/image_20230524193158.png',1),(6,'Self-Portrait','Title: Self-Portrait Date: 1926/1926 Physical Dimensions: w66 x h81 cm Painter: Uga Skulme Type: Paintings Rights: LNMA','https://commons.wikimedia.org/wiki/File:Self-Portrait_Pa%C5%A1portrets_1926_by_Uga_Skulme_(1895-1963)_Latvian_National_Museum_of_Arts.jpg','Picture/image_20230524193341.png',1),(7,'The Love Scene','Title: The Love Scene Date: 1877/1877 Physical Dimensions: w24.3 x h20.5 cm Painter: Kārlis Hūns Type: Watercolours Rights: LNMA','https://artsandculture.google.com/asset/the-love-scene/IwFAN0tnHw2XwQ','Picture/image_20230524193505.png',1),(8,'Era (Allegory. Old and New Rīga)','Title: Era (Allegory. Old and New Rīga) Date: 1937/1937 Physical Dimensions: w80 x h65 cm Painter: Jānis Tīdemanis Type: Etching Rights: LNMA','https://artsandculture.google.com/asset/era-allegory-old-and-new-r%C4%ABga/JgG96-_-O7fGHA','Picture/image_20230524193750.png',1),(9,'Madonna with a Machine Gun','Title: Madonna with a Machine Gun Date: 1932/1932 Physical Dimensions: w100 x h134 cm Painter: Kārlis Padegs Type: Paintings Rights: LNMA','https://en.wikipedia.org/wiki/Madonna_with_Machine_Gun','Picture/image_20230524193901.png',1),(10,'Man entering the room','Title: Man entering the room Date: 1927/1927 Physical Dimensions: w86 x h92 cm Painter: Niklāvs Strunke Type: Paintings Rights: LNMA','https://en.wikipedia.org/wiki/Man_Entering_a_Room','Picture/image_20230524193954.png',1),(11,'Under the banner of Lenin for socialist construction. Poster','Title: Under the banner of Lenin for socialist construction. Poster Date: 1930/1930 Physical Dimensions: w72.3 x h99.9 cm Painter: Gustavs Klucis Type: Litograph on paper Rights: LNMA','https://commons.wikimedia.org/wiki/File:Under_the_banner_of_Lenin_for_socialist_construction_Poster_-_Gustavs_Klucis.jpg','Picture/image_20230524194422.png',1),(12,'Shipwreck','Titre: Shipwreck Creator: Johann Christian Clausen Dahl (1788, Bergen–1857, Dresden) Date: 1832 Places of creation: Norway History: Acquired from the collection of Friedrich Wilhelm Brederlo (1905/1906) Physical Dimensions: 31.8 x 25.1 cm Type: Painting Rights: Latvian National Museum of ArtSupport: Oil on canvas','https://www.meisterdrucke.fr/fine-art-prints/Johan-Christian-Dahl/14068/Naufrage-sur-la-c%C3%B4te-de-la-Norv%C3%A8ge.html','Picture/image_20230525161115.png',2),(13,'Portrait of Charlotte Aglaé d\'Orléans','Title: Portrait of Charlotte Aglaé d\'Orléans Creator: Pierre Gobert (1662, Fontainebleau–1744, Paris) Date: ca 1716–1718 Places of creation: France History: Acquired from the State Hermitage (1952). Physical Dimensions: 69.7 x 80 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil on canvas','https://fr.wikipedia.org/wiki/Fichier:Pierre_Gobert_-_Charlotte_Agla%C3%A9_d%27Orl%C3%A9ans_-_Royal_Collection.jpg','Picture/image_20230525161551.png',2),(14,'The Death of Siegmund','Title: The Death of Siegmund Creator: Hans Makart (1840, Salzburg–1884, Vienna) Date: 1883 Place of creation : Austria History: Gift from Paul von Transehe-Roseneck (1904). Physical Dimensions : 99.5 x 149.7 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil on canvas','https://artsandculture.google.com/asset/the-death-of-siegmund-hans-makart-1840-salzburg%E2%80%931884-vienna/dgFOP23PaBA-pg','Picture/image_20230526011744.png',2),(15,'Adam and Eve','Title: Adam and Eve Creator: Bartholomeus Spranger (1546, Antwerp–1611, Prague) Date: Late 16th century – early 17th century Place of creation: Netherlands History: Acquired in 1937 Physical Dimensions : 81.3 x 137.8 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil and tempera on wood','https://www.meisterdrucke.uk/fine-art-prints/Bartholomaeus-Spranger/794615/Adam-and-Eve,-c1566-1611.--.html','Picture/image_20230526012740.png',2),(16,'Portrait of Scientist','Title: Portrait of Scientist Creator: Jacob van Loo (1641, Sluis–1670, Paris) Date: 1647 Place of creation : Holland History: Acquired from the collection of Friedrich Wilhelm Brederlo (1905/1906) Physical Dimensions : 76.1 x 88.3 cm Type: Painting Rights : Latvian National Museum of Art Support: Oil on canvas','https://artsandculture.google.com/asset/portrait-of-scientist-jacob-van-loo-1641-sluis%E2%80%931670-paris/uQH64kD_EbFX8Q','Picture/image_20230526012959.png',2),(17,'Solomon Praying to False Gods','Title: Solomon Praying to False Gods Creator: Luca Giordano (1634‒1705) Date : ca 1684 Place of creation : Italy History: Collection of Kārlis Jurjāns, acquired 1944 Physical Dimensions : 149 x 208 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil on canva','https://commons.wikimedia.org/wiki/File:Art_Museum_Riga_Bourse_077.jpg','Picture/image_20230526013108.png',2),(18,'Portrait of William II, Prince of Orange-Nassau','Title: Portrait of William II, Prince of Orange-Nassau Creator: Workshop of Anthonis van Dyck Date: 1632 Place of creation: Flanders History: Acquired from the collection of Friedrich Wilhelm Brederlo (1905/1906) Physical Dimensions: 102.5 x 123 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil on canvas','https://commons.wikimedia.org/wiki/File:Prince_William_II_of_Orange,_by_Anthony_van_Dyck.jpg','Picture/image_20230526013211.png',2),(19,'Bacchante','Title: Bacchante Creator: Luigi Bienaime (1795, Carrara–1878, Florence) Date: 1847 Place of creation: Italy History: From the Bukaiši Manor collection of the prince A. Lieven was later located in Kurzeme Province Museum (1940). Physical Dimensions : 165 x 92 x 55 cm (maximum height, width and depth with pedestal) Type: Sculptures Rights: Latvian National Museum of Art Support: Marble','https://commons.wikimedia.org/wiki/File:Luigi_Bienaime_-_Bacchante_-_Hermitage_-_01.jpg','Picture/image_20230526013329.png',2),(20,'Jan Hus at the Council of Constance','Title: Jan Hus at the Council of Constance Creator: Karl Friedrich Lessing (1808, Breslau–1880, Karlsruhe) Date: 1839 Place of creation : Germany History: Acquired from the collection of Friedrich Wilhelm Brederlo (1905/1906) Physical Dimensions : 67.8 x 46.5 cm Type: Painting Rights: Latvian National Museum of Art Support: Oil on canvas','https://sammlung.staedelmuseum.de/en/work/jan-hus-at-constance','Picture/image_20230526013530.png',2),(21,'Philemon and Baucis','Title: Philemon and Baucis Creator: Orest Kiprensky (Орест Адамович Кипренский, 1783‒1836) Date : 1802 Place of creation: Russia History: Acquired in 1965 Physical Dimensions: 124.7 x 101.8 cm Type: Painting Rights : Latvian National Museum of Art Support: Oil on canvas','https://www.wikiart.org/fr/oreste-kiprensky/jupiter-and-mercury-in-the-form-of-visiting-pilgrims-philemon-and-baucis-1802','Picture/image_20230526013702.png',2);
/*!40000 ALTER TABLE `Art` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Museum`
--

DROP TABLE IF EXISTS `Museum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Museum` (
  `Code` int NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Location` varchar(200) DEFAULT NULL,
  `Description` longtext,
  `Email` varchar(100) DEFAULT NULL,
  `Link` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Museum`
--

LOCK TABLES `Museum` WRITE;
/*!40000 ALTER TABLE `Museum` DISABLE KEYS */;
INSERT INTO `Museum` VALUES (1,'Latvian National Museum of Art','Jaņa Rozentāla laukums, Central District, Riga, Latvia','The Latvian National Museum of Art is the richest collection of national art in Latvia. It houses more than 52,000 works of art reflecting the development of professional art in the Baltic area and in Latvia from the middle of the 18th century until the present time.','ekskursijas@lnmm.lv','https://www.lnmm.lv/latvijas-nacionalais-makslas-muzejs'),(2,'The Art Museum RIGA BOURSE','Doma laukums 6, Centra rajons, Rīga, LV-1050, Lettonie','The Riga Stock Exchange Museum ( Latvian  : Mākslas muzejs Rīgas Birža , English  : Art Museum Riga Stock Exchange ) houses the foreign art collections. Between 1920 (when it opened) until 2011, it was located in the southern wing of Riga Castle . Then, the museum reopens in the old Stock Exchange, freshly renovated.','dmdm@lnmm.lv','https://www.lnmm.lv/makslas-muzejs-rigas-birza'),(3,'Museum of Romans Suta and Aleksandra Belcova','57a, Apt. 26 Elizabetes iela, Riga, LV-1050, Latvia','The museum devoted to the artists Romans Suta (1896-1944) and Aleksandra Beļcova (1892-1981) is an affiliate of the Latvian National Museum of Art which is based on the bequest of the two artists’ daughter, the ballet dancer, art historian and television journalist Tatjana Suta (1923-2004). The museum is located in the flat which the family owned after 1935. During her life, Tatjana Suta began to put together a museum dedicated to the two artists in her apartment, improving security, registering the various artworks, and presenting them to students and others who were interested.','jugendstils@riga.lv','https://www.lnmm.lv/en/romans-suta-and-aleksandra-belcova-museum');
/*!40000 ALTER TABLE `Museum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `ID` int NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Gab','Pass','e@gmail.com'),(2,'Jean','Toto','Jean@gmail.com'),(5,'Zara','Banakami','zaraaa@gmail.com');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserM`
--

DROP TABLE IF EXISTS `UserM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserM` (
  `ID` int NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Museum` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Museum` (`Museum`),
  CONSTRAINT `UserM_ibfk_1` FOREIGN KEY (`Museum`) REFERENCES `Museum` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserM`
--

LOCK TABLES `UserM` WRITE;
/*!40000 ALTER TABLE `UserM` DISABLE KEYS */;
INSERT INTO `UserM` VALUES (3,'Pierre','Pass','Pierre@gmail.com',1),(4,'Jack','Password','email@gmail.com',2);
/*!40000 ALTER TABLE `UserM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  2:51:41
