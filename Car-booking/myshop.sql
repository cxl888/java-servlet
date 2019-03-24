/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : myshop

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-01-20 10:17:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Mercedes-Benz');
INSERT INTO `category` VALUES ('2', 'Volkswagen');
INSERT INTO `category` VALUES ('3', 'BUICK');
INSERT INTO `category` VALUES ('4', 'BMW');
INSERT INTO `category` VALUES ('5', 'Audi');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `oiid` int(11) NOT NULL AUTO_INCREMENT,
  `pnum` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`oiid`),
  KEY `oid` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('2', '1', '10288', '39', '6eccdadb806e49988e1b016affe8cdb4');
INSERT INTO `orderitem` VALUES ('3', '1', '9899', '45', 'fd037812c77d4570a4b95a1cd0f3535d');
INSERT INTO `orderitem` VALUES ('4', '1', '6688', '32', '0c7a90cb6eb84bfd8578c5ea5bba5f48');
INSERT INTO `orderitem` VALUES ('5', '1', '6599', '40', '2479f66996d941febb5b7b5617a3c19b');
INSERT INTO `orderitem` VALUES ('6', '1', '6088', '26', '51ffb1cc57cc4da2b1841d73b0458051');
INSERT INTO `orderitem` VALUES ('7', '1', '5999', '42', 'fe890979433d425688adfce44966b056');
INSERT INTO `orderitem` VALUES ('8', '1', '9899', '45', 'f9d4faa0f17147209765be3f74b4f502');
INSERT INTO `orderitem` VALUES ('9', '1', '69', '56', '914ad2abb22d4937a516cf4421f2e5c0');
INSERT INTO `orderitem` VALUES ('10', '2', '138', '56', 'b145a3aa10c1488cbeb7e3cfd2d7fe31');
INSERT INTO `orderitem` VALUES ('11', '1', '69', '57', '86c72e784a78439c8e0ba10bd7a2fdec');
INSERT INTO `orderitem` VALUES ('12', '1', '69', '57', '41f5e7e5f0f34ad8864dc55775c59c76');
INSERT INTO `orderitem` VALUES ('13', '1', '69', '57', '215da2b802844e60bc8d84eefa23a682');
INSERT INTO `orderitem` VALUES ('14', '1', '69', '56', 'f472931d3a004a93a0dd0ddc3c19c762');
INSERT INTO `orderitem` VALUES ('16', '1', '69', '56', '8c52d4fcc100471d904459b077919829');
INSERT INTO `orderitem` VALUES ('17', '1', '69', '56', '08b9883258e949df88a9472be065b9bf');
INSERT INTO `orderitem` VALUES ('18', '1', '59', '11', '04cc418537b74caa843a2b0b26459ae2');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(32) NOT NULL,
  `totalmoney` double DEFAULT NULL,
  `ordertime` varchar(32) DEFAULT NULL,
  `orderstatus` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('04cc418537b74caa843a2b0b26459ae2', '59', '2018-5-24 13:32:03', '3', 'yt', '123456', 'China', '11');
INSERT INTO `orders` VALUES ('08b9883258e949df88a9472be065b9bf', '69', '2018-4-15 17:01:57', '3', '11', '11', '11', '8');
INSERT INTO `orders` VALUES ('0c7a90cb6eb84bfd8578c5ea5bba5f48', '6688', '2016-12-18 10:14:46', '2', '3', '3', '3', '9');
INSERT INTO `orders` VALUES ('215da2b802844e60bc8d84eefa23a682', '69', '2018-4-9 15:23:00', '3', 'sbzy', '1234567', 'zhengzhou', '8');
INSERT INTO `orders` VALUES ('2479f66996d941febb5b7b5617a3c19b', '6599', '2016-12-18 10:15:08', '2', '4', '4', '4', '9');
INSERT INTO `orders` VALUES ('41f5e7e5f0f34ad8864dc55775c59c76', '69', '2018-4-9 15:20:56', '3', 'sbzy', '1234567', 'zhengzhou', '8');
INSERT INTO `orders` VALUES ('51ffb1cc57cc4da2b1841d73b0458051', '6088', '2016-12-18 10:15:20', '2', '5', '5', '5', '9');
INSERT INTO `orders` VALUES ('6eccdadb806e49988e1b016affe8cdb4', '10288', '2016-12-18 10:13:57', '2', '1', '1', '1', '9');
INSERT INTO `orders` VALUES ('86c72e784a78439c8e0ba10bd7a2fdec', '69', '2018-4-6 13:42:03', '3', '12321', '12312', '124', '4');
INSERT INTO `orders` VALUES ('8c52d4fcc100471d904459b077919829', '69', '2018-4-12 15:30:21', '3', 'yt', '123456', 'China', '8');
INSERT INTO `orders` VALUES ('914ad2abb22d4937a516cf4421f2e5c0', '69', '2018-4-4 14:08:01', '2', 'yangtian', '18537995873', '1234567', '9');
INSERT INTO `orders` VALUES ('b145a3aa10c1488cbeb7e3cfd2d7fe31', '138', '2018-4-4 14:36:05', '3', 'yt', '18537995873', 'China', '9');
INSERT INTO `orders` VALUES ('f472931d3a004a93a0dd0ddc3c19c762', '69', '2018-4-12 15:20:54', '3', 'yt', '123456', 'China', '8');
INSERT INTO `orders` VALUES ('f9d4faa0f17147209765be3f74b4f502', '9899', '2018-4-3 20:45:09', '2', '123456', '123456', '123456', '10');
INSERT INTO `orders` VALUES ('fd037812c77d4570a4b95a1cd0f3535d', '9899', '2016-12-18 10:14:27', '2', '2', '2', '2', '9');
INSERT INTO `orders` VALUES ('fe890979433d425688adfce44966b056', '5999', '2016-12-18 10:15:36', '2', '6', '6', '6', '9');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `pdesc` text,
  `category` varchar(255) DEFAULT NULL,
  `oil` double DEFAULT NULL,
  `rank` int(4) DEFAULT NULL,
  `displacement` double DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '桑坦纳', '129', '59', 'products/1/c_0001.jpg', '全新桑塔纳', 'Volkswagen', '5.7', '4', '1.4');
INSERT INTO `product` VALUES ('2', '宝马1系', '129', '59', 'products/1/c_0002.jpg', '2018款 118i 时尚版', 'BMW', '5.5', '4', '1.5');
INSERT INTO `product` VALUES ('3', '宝马2系旅行车', '129', '59', 'products/1/c_0003.jpg', '华晨宝马', 'BMW', '5.9', '4', '1.5');
INSERT INTO `product` VALUES ('4', '宝马3系', '129', '59', 'products/1/c_0004.jpg', '华晨宝马', 'BMW', '5.8', '4', '1.5');
INSERT INTO `product` VALUES ('5', '昂科拉', '129', '59', 'products/1/c_0005.jpg', '2018 全新旗舰版', 'BUICK', '6.7', '4', '1.4');
INSERT INTO `product` VALUES ('6', '昂科威', '129', '59', 'products/1/c_0006.jpg', '2018 全新旗舰版', 'BUICK', '6.6', '5', '1.5');
INSERT INTO `product` VALUES ('7', '宝来', '129', '59', 'products/1/c_0007.jpg', '全新宝来', 'Volkswagen', '5.3', '4', '1.4');
INSERT INTO `product` VALUES ('8', '北京奔驰--C级', '129', '59', 'products/1/c_0008.jpg', '北京奔驰', 'Mercedes-Benz', '6.3', '4', '1.6');
INSERT INTO `product` VALUES ('9', '北京奔驰--GLC级', '129', '59', 'products/1/c_0009.jpg', '北京奔驰', 'Mercedes-Benz', '7.2', '5', '2');
INSERT INTO `product` VALUES ('10', '北京奔驰--GLA级', '129', '59', 'products/1/c_0010.jpg', '北京奔驰', 'Mercedes-Benz', '6.5', '5', '1.6');
INSERT INTO `product` VALUES ('11', '途观', '129', '59', 'products/1/c_0011.jpg', '全新途观', 'Volkswagen', '6.9', '5', '1.8');
INSERT INTO `product` VALUES ('56', 'Benz--Eclass', '129', '69', 'products/1/c_0051.jpg', 'very good!', 'Mercedes-Benz', '6.8', '4', '1.8');
INSERT INTO `product` VALUES ('57', 'Golf', '189', '69', 'products/1/c_0052.jpg', 'Good!', 'Volkswagen', '6.1', '5', '2.3');
INSERT INTO `product` VALUES ('58', 'BMW--X1', '119', '69', 'products/1/c_0053.jpg', 'so cool!', 'BMW', '6.1', '5', '1.5');
INSERT INTO `product` VALUES ('59', 'BUICK--VELITE 5', '129', '69', 'products/1/c_0054.jpg', 'electric car!', 'BUICK', '0.9', '4', '1.5');
INSERT INTO `product` VALUES ('60', 'Audi--A3', '129', '59', 'products/1/c_0055.jpg', '12qwe', 'Audi', '5.4', '4', '1.6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `realname` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` varchar(32) DEFAULT NULL,
  `history` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', 'admin@qq.com', '1', '1995-01-01', null);
INSERT INTO `user` VALUES ('2', 'wk', '1234567', 'qwe', '123', '1', '2016-02-08', null);
INSERT INTO `user` VALUES ('3', 'xj', '123', 'xj', '1233425', '1', '2017-01-01', null);
INSERT INTO `user` VALUES ('4', 'yt', '123', 'yt', '1232', '1', '2017-01-01', 'products/1/c_0052.jpg');
INSERT INTO `user` VALUES ('5', 'zx', '123', 'zx', '21442', '1', '2017-01-01', null);
INSERT INTO `user` VALUES ('6', 'zy', '123', 'zy', '1221421', '1', '2017-01-01', null);
INSERT INTO `user` VALUES ('7', 'zyl', '123', 'zyl', '1234', '1', '2017-01-01', null);
INSERT INTO `user` VALUES ('8', 'wsq', '123', 'wsq', '21321', '1', '2017-01-01', 'products/1/c_0051.jpg');
INSERT INTO `user` VALUES ('9', 'yang', '123', 'yt', '632553710@qq.com', '1', '1995-11-18', 'products/1/c_0052.jpg');
INSERT INTO `user` VALUES ('10', 'ly_yt', '123', 'Yt', '1234', '1', '2016-01-07', '');
INSERT INTO `user` VALUES ('11', 'wasd', '123456', 'qwe', '1234@qq.com', '1', '2018-05-01', 'products/1/c_0012.jpg-products/1/c_0011.jpg-products/1/c_0001.jpg-products/1/c_0006.jpg-products/1/c_0001.jpg-products/1/c_0011.jpg');
