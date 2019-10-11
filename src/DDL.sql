CREATE TABLE `auth_user` (
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobileno` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `stateid` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;