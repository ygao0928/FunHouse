/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : funhouse

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 01/12/2020 13:56:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '权限:\r\n1:为超级权限\r\n2:普通管理员\r\n3:正常管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, '唐子钧', '123456', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1);

-- ----------------------------
-- Table structure for drama_library
-- ----------------------------
DROP TABLE IF EXISTS `drama_library`;
CREATE TABLE `drama_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `drama_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本名字',
  `script_form` int(255) NULL DEFAULT NULL COMMENT '剧本形式:盒装、城市限定、城市独家',
  `script_difficulty` int(255) NULL DEFAULT NULL COMMENT '剧本难度:新手、进阶、烧脑',
  `script_background` int(255) NULL DEFAULT NULL COMMENT '剧本背景:古装、民国、现代、科幻、欧式、日式、架空',
  `script_type` int(255) NULL DEFAULT NULL COMMENT '剧本类型:还原、开放、封闭、半封闭、本格、变格',
  `script_theme` int(255) NULL DEFAULT NULL COMMENT '剧本剧情:恐怖、欢乐、推理、校园、硬核、情感、机制',
  `drama_Introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本简介',
  `drama_image` varchar(6000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本首页图片',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `number_require` int(11) NULL DEFAULT NULL COMMENT '人数要求',
  `public_link` varchar(6000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公众号链接地址',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '是否删除',
  `on_shelf` tinyint(255) NULL DEFAULT NULL COMMENT '是否上架',
  `creation_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `statue` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drama_library
-- ----------------------------
INSERT INTO `drama_library` VALUES (1, '狼人杀', 1, 2, 2, 2, 2, '狼人杀，是一款多人参与的、以语言描述推动的、较量口才和分析判断能力的策略类桌面游戏，该游戏通常的版本需要4-18人参与互动', 'https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg', 146.00, 8, NULL, 0, 0, '2020-10-26 13:53:30', NULL, '0');
INSERT INTO `drama_library` VALUES (2, '舍离', 2, 1, 3, 1, 1, '不建议推理机器尝试。（比如我。全程无泪点甚至觉得有点尴尬）\r\n\r\n推凶很弱，情感有点玛丽苏……', 'https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg', 300.00, 6, NULL, 0, 0, '2020-11-25 22:03:29', NULL, '0');
INSERT INTO `drama_library` VALUES (3, '窗边的女人', 3, 2, 1, 1, 2, '很经典的本了，台词有点h，我拿的反串，公聊的时候还是挺欢脱的哈哈哈\r\n\r\n推理方面对于新手可能略有难度', 'https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg', 433.00, 7, NULL, 0, 0, '2020-11-25 22:04:09', NULL, '0');
INSERT INTO `drama_library` VALUES (4, '精神病院2', 1, 3, 1, 2, 3, '推理太太太弱了 而且没什么剧情 也不怎么欢乐', 'https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg', 122.00, 5, NULL, 0, 0, '2020-11-25 22:04:34', NULL, '0');
INSERT INTO `drama_library` VALUES (7, '测试', 1, 1, 2, 4, 6, '2323', '[{\"name\":\"image\",\"url\":\"/file/20201130232416.jpg\",\"uid\":1606749856198,\"status\":\"success\"}]', 10.00, 2, 'https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247488664&idx=2&sn=b383094aaba853ad6c00e69ce5a86a93&chksm=ebd62bb4dca1a2a250d4559180e4b57b123f14e5b79cddc6d8009f20554bbec29933b4996d64&scene=21#wechat_redirect', 0, NULL, '2020-11-30 23:24:26', NULL, NULL);

-- ----------------------------
-- Table structure for member_info
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '网名',
  `open_id` int(11) NULL DEFAULT NULL COMMENT 'openid',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号码',
  `appsecret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `app_id` int(11) NULL DEFAULT NULL,
  `gender` int(255) NULL DEFAULT NULL COMMENT '性别',
  `member_level` int(255) NULL DEFAULT NULL COMMENT '会员等级',
  `is_admin` tinyint(4) NULL DEFAULT NULL COMMENT '是否是管理员\r\n0:不是管理员\r\n1:是管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_info
-- ----------------------------

-- ----------------------------
-- Table structure for script_background_library
-- ----------------------------
DROP TABLE IF EXISTS `script_background_library`;
CREATE TABLE `script_background_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `script_background` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本背景',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_background_library
-- ----------------------------
INSERT INTO `script_background_library` VALUES (1, '古装', 0);
INSERT INTO `script_background_library` VALUES (2, '民国', 0);
INSERT INTO `script_background_library` VALUES (3, '现代', 0);
INSERT INTO `script_background_library` VALUES (4, '科幻', 0);
INSERT INTO `script_background_library` VALUES (5, '欧式', 0);
INSERT INTO `script_background_library` VALUES (6, '日式', 0);
INSERT INTO `script_background_library` VALUES (7, '架空', 0);

-- ----------------------------
-- Table structure for script_difficulty_library
-- ----------------------------
DROP TABLE IF EXISTS `script_difficulty_library`;
CREATE TABLE `script_difficulty_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `degree_difficulty` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度程度',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_difficulty_library
-- ----------------------------
INSERT INTO `script_difficulty_library` VALUES (1, '新手', 0);
INSERT INTO `script_difficulty_library` VALUES (2, '进阶', 0);
INSERT INTO `script_difficulty_library` VALUES (3, '烧脑', 0);

-- ----------------------------
-- Table structure for script_form_library
-- ----------------------------
DROP TABLE IF EXISTS `script_form_library`;
CREATE TABLE `script_form_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scriptForm` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本形式',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_form_library
-- ----------------------------
INSERT INTO `script_form_library` VALUES (1, '盒装', 0);
INSERT INTO `script_form_library` VALUES (2, '城市限定', 0);
INSERT INTO `script_form_library` VALUES (3, '城市独家', 0);

-- ----------------------------
-- Table structure for script_theme_library
-- ----------------------------
DROP TABLE IF EXISTS `script_theme_library`;
CREATE TABLE `script_theme_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `script_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本剧情',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_theme_library
-- ----------------------------
INSERT INTO `script_theme_library` VALUES (1, '恐怖', 0);
INSERT INTO `script_theme_library` VALUES (2, '欢乐', 0);
INSERT INTO `script_theme_library` VALUES (3, '推理', 0);
INSERT INTO `script_theme_library` VALUES (4, '校园', 0);
INSERT INTO `script_theme_library` VALUES (5, '硬核', 0);
INSERT INTO `script_theme_library` VALUES (6, '情感', 0);
INSERT INTO `script_theme_library` VALUES (7, '机制', 0);

-- ----------------------------
-- Table structure for script_type_library
-- ----------------------------
DROP TABLE IF EXISTS `script_type_library`;
CREATE TABLE `script_type_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `script_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '剧本类型',
  `delete_flage` tinyint(255) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_type_library
-- ----------------------------
INSERT INTO `script_type_library` VALUES (1, '还原', 0);
INSERT INTO `script_type_library` VALUES (2, '开放', 0);
INSERT INTO `script_type_library` VALUES (3, '封闭', 0);
INSERT INTO `script_type_library` VALUES (4, '本格', 0);
INSERT INTO `script_type_library` VALUES (5, '变格', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `open_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'open_id',
  `skey` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'skey',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `last_visit_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  `session_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'session_key',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` tinyint(11) NULL DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网名',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`open_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '微信用户信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('o7bNs5aIuCFvUvb-0JGLtpFkTW5k', '9d7804fb-be90-4686-9456-8a940b86edf4', '2020-11-19 16:20:40', '2020-11-22 23:05:49', 'eokFXiZT8qQppdLXtJ9jPg==', '', '', 'China', 'https://thirdwx.qlogo.cn/mmopen/vi_32/yEN1r2ibdsGcPV19GDO6QVeMlibEgmj4gic46fXhbUoibwq9uGA4BZLw1LASkl4r9MwqrOSEhQM03RzJp9ekxjcTJw/132', 1, '　　　　　　', NULL);

SET FOREIGN_KEY_CHECKS = 1;
