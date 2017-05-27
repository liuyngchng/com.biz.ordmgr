CREATE TABLE `t_app_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(16) DEFAULT '' COMMENT 'orderId',
  `user_id` varchar(16) DEFAULT '' COMMENT 'userId',
  `mobile` varchar(13) DEFAULT '' COMMENT 'mobile',
  `home_loc_id` varchar(16) DEFAULT '' COMMENT 'homeLocId',
  `work_loc_id` varchar(16) DEFAULT '' COMMENT 'workLocId',
  `location` varchar(16) DEFAULT '' COMMENT 'gps location',
  `desc` varchar(255) DEFAULT '' COMMENT 'desc',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0：有效 ；1：无效；',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8mb4;