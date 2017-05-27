CREATE TABLE `t_app_loc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loc_id` varchar(16) NOT NULL COMMENT 'loc_id',
  `loc_name` varchar(16) NOT NULL COMMENT 'loc_name',
  PRIMARY KEY (`id`,`loc_id`,`loc_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3509 DEFAULT CHARSET=utf8mb4;

ALTER TABLE `t_app_loc`
ADD UNIQUE INDEX `idx_loc_id` (`loc_id` ASC)  COMMENT '',
ADD INDEX `idx_loc_name` (`loc_name` ASC)  COMMENT '';