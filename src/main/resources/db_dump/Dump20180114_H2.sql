DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `user_group` VALUES (1,'normal'),(2,'adminstrator');


DROP TABLE IF EXISTS `id_info`;
CREATE TABLE `id_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity_num` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
INSERT INTO `id_info` VALUES (100,'1234567890'),(101,'9876543210');


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `role` VALUES (1,'normal'),(2,'administrator'),(3,'level-1');


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `psw` varchar(45) DEFAULT NULL,
  `expired` datetime DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `identity_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_id_UNIQUE` (`identity_id`),
  CONSTRAINT `group_id` FOREIGN KEY (`group_id`) REFERENCES `user_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `identity_id` FOREIGN KEY (`identity_id`) REFERENCES `id_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `user` VALUES (1,'rick','abc','2017-01-01 00:00:00',1,100,NULL),(2,'tom','edf','2017-06-01 00:00:00',2,101,NULL);


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `user_role` VALUES (2,1),(1,2),(1,3);
