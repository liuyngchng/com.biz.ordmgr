CREATE TABLE `t_app_town` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loc_id` varchar(16) NOT NULL COMMENT 'loc_id',
  `loc_name` varchar(16) NOT NULL COMMENT 'loc_name',
  PRIMARY KEY (`id`,`loc_id`,`loc_name`),
  UNIQUE KEY `idx_loc_id` (`loc_id`),
  KEY `idx_loc_name` (`loc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4