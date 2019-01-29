/*
MySQL Backup
Source Server Version: 5.6.35
Source Database: warehouse
Date: 2018/3/23 09:47:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `material_id` char(50) NOT NULL,
  `material_name` char(50) NOT NULL,
  `c_name` char(50) DEFAULT NULL,
  `information` char(255) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `material_name` (`material_name`),
  KEY `material_id` (`material_id`),
  KEY `c_name` (`c_name`)
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` char(50) NOT NULL,
  `upwd` char(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `material` VALUES ('1','0001','物料1','类别1','物料信息1','10','10.00'), ('2','0002','物料2','类别2','物料信息2','10','10.00'), ('3','0003','物料3','类别1','物料信息3','10','10.00'), ('4','0003','物料3','类别1','物料信息3','10','10.00'), ('5','0003','物料3','类别1','物料信息3','10','10.00'), ('6','0002','物料2','类别2','物料信息2','10','10.00'), ('7','0001','物料1','类别1','物料信息1','10','10.00'), ('8','0002','物料2','类别2','物料信息2','10','10.00'), ('9','0001','物料1','类别1','物料信息1','10','10.00'), ('10','0004','物料4','类别4','物料信息4','20','20.00'), ('11','0005','物料5','类别5','物料信息5','20','20.00'), ('12','0006','物料6','类别6','物料信息6','20','20.00'), ('13','0007','物料7','类别7','物料信息7','30','30.00'), ('14','0008','物料8','类别8','物料信息8','30','30.00');
INSERT INTO `users` VALUES ('1','root','root'), ('2','00','00');
