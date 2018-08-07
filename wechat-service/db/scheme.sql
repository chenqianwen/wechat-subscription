/** 创建数据库 */
DROP DATABASE if EXISTS `wechat-subscription`;
CREATE DATABASE `wechat-subscription` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `wechat-subscription`;
/** 创建表 */
DROP TABLE if EXISTS `wechat_user`;
CREATE TABLE `wechat_user`(
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `subscribe` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否订阅',
  `openid` varchar(64)  NOT NULL COMMENT '用户标识',
  `nickname` varchar(64)  NOT NULL COMMENT '昵称',
  `sex` tinyint(1)  DEFAULT 0 COMMENT '性别',
  `city` varchar(64)   COMMENT '城市',
  `country` varchar(64)   COMMENT '国家',
  `province` varchar(64)   COMMENT '省份',
  `language` varchar(16)   COMMENT '语言',
  `headimgurl` varchar(512)   COMMENT '头像',
  `subscribe_time` integer NOT NULL COMMENT '关注时间',
  `unionid` varchar(64) COMMENT '用户绑定',
  `remark` varchar(64) COMMENT '备注',
  `groupid` varchar(64) COMMENT '分组ID',
  `tagid_list` varchar(64) COMMENT '标签ID列表',
  `subscribe_scene` varchar(32) COMMENT '关注的渠道来源',
   PRIMARY KEY (`id`) USING BTREE
)COMMENT='微信用户' ENGINE = Innodb  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE if EXISTS `wechat_user_integral`;
CREATE TABLE `wechat_user_integral`(
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `user_id` varchar(64)  NOT NULL COMMENT '用户ID',
  `integral` varchar(64)  NOT NULL DEFAULT '0' COMMENT '用户积分',
PRIMARY KEY (`id`) USING BTREE
)COMMENT='微信用户积分' ENGINE = Innodb  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


