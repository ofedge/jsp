/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-05-25 22:45:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_country
-- ----------------------------
DROP TABLE IF EXISTS `t_country`;
CREATE TABLE `t_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_country
-- ----------------------------
INSERT INTO `t_country` VALUES ('1', 'Aruba', 'Caribbean', 'ABW');
INSERT INTO `t_country` VALUES ('2', 'Bahamas', 'Caribbean', 'BHS');
INSERT INTO `t_country` VALUES ('3', 'Brazil', 'South America', 'BRA');
INSERT INTO `t_country` VALUES ('4', 'Barbados', 'Caribbean', 'BRB');
INSERT INTO `t_country` VALUES ('5', 'China', 'Eastern Asia', 'CHN');
INSERT INTO `t_country` VALUES ('6', 'Greece', 'Southern Europe', 'GRC');
INSERT INTO `t_country` VALUES ('7', 'Grenada', 'Caribbean', 'GRD');
INSERT INTO `t_country` VALUES ('8', 'Haiti', 'Caribbean', 'HTI');
INSERT INTO `t_country` VALUES ('9', 'Israel', 'Middle East', 'ISR');
INSERT INTO `t_country` VALUES ('10', 'Italy', 'Southern Europe', 'ITA');
INSERT INTO `t_country` VALUES ('11', 'Jamaica', 'Caribbean', 'JAM');
INSERT INTO `t_country` VALUES ('12', 'Jordan', 'Middle East', 'JOR');
INSERT INTO `t_country` VALUES ('13', 'Japan', 'Eastern Asia', 'JPN');
INSERT INTO `t_country` VALUES ('14', 'Kenya', 'Eastern Africa', 'KEN');
INSERT INTO `t_country` VALUES ('15', 'Moldova', 'Eastern Europe', 'MDA');
INSERT INTO `t_country` VALUES ('16', 'Namibia', 'Southern Africa', 'NAM');
INSERT INTO `t_country` VALUES ('17', 'New Caledonia', 'Melanesia', 'NCL');
INSERT INTO `t_country` VALUES ('18', 'Niger', 'Western Africa', 'NER');
INSERT INTO `t_country` VALUES ('19', 'Nigeria', 'Western Africa', 'NGA');
INSERT INTO `t_country` VALUES ('20', 'Poland', 'Eastern Europe', 'POL');
INSERT INTO `t_country` VALUES ('21', 'Puerto Rico', 'Caribbean', 'PRI');
INSERT INTO `t_country` VALUES ('22', 'Suriname', 'South America', 'SUR');
