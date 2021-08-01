CREATE table `student`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `class_id`    int(11) NOT NULL,
    `name`        varchar(100) COLLATE utf8mb4_bin NOT NULL,
    `gender`      varchar(10)                      NOT NULL,
    `create_time` timestamp(6)                     NOT NULL DEFAULT current_timestamp(6),
    `update_time` timestamp(6)                     NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp (6),
    PRIMARY KEY (`id`),
    KEY           `name_index` (`name`),
    KEY           `class_id_name_index` (`class_id`,`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin