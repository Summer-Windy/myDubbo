/*
Navicat MySQL Data Transfer

Source Server         : 192.168.180.128
Source Server Version : 50546
Source Host           : 192.168.180.128:3306
Source Database       : edu_demo

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-12-28 23:59:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `edu_edmo_pms_user`
-- ----------------------------
DROP TABLE IF EXISTS `edu_edmo_pms_user`;
CREATE TABLE `edu_edmo_pms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_no` varchar(50) NOT NULL COMMENT '用户账号',
  `main_user_id` bigint(20) DEFAULT NULL,
  `user_pwd` varchar(256) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `mobile_no` varchar(15) DEFAULT NULL,
  `email` varbinary(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_type` varchar(1) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `is_changed_pwd` int(11) DEFAULT NULL COMMENT '是否改过密码',
  `pwd_error_count` int(11) NOT NULL DEFAULT '0' COMMENT '连续输错次数',
  `pwd_error_time` datetime DEFAULT NULL COMMENT '最后输入错误时间',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_KEY_2` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_edmo_pms_user
-- ----------------------------
INSERT INTO `edu_edmo_pms_user` VALUES ('1', '2', '2015-12-28 04:31:40', '1', '1', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'xbb', '12345', null, '1', '1', '2015-12-28 17:31:46', null, '0', '2015-12-02 17:48:41', null);
INSERT INTO `edu_edmo_pms_user` VALUES ('2', '10', '2015-12-28 04:31:27', 'admin', '2', '123456', 'admin', '123456', null, '1', '1', '2015-12-26 17:49:24', null, '3', '2015-12-28 17:31:34', null);
INSERT INTO `edu_edmo_pms_user` VALUES ('3', '0', '2015-12-28 04:33:58', 'summer', null, '347eaf2638e77850c01b4e1d7bcf3694e16c5582', 'summer', '13570848522', null, '100', '2', null, '0', '0', null, 'nihao sdlfjls ');
