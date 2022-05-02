# 指令创建表
-- 注意：创建表时，要根据需保存的数据创建相应的列，
-- 并根据数据的类型定义相应的列类型。
CREATE TABLE `user`(
	`id` INT COMMENT'id',
	`name` VARCHAR(30) COMMENT '姓名',
	`password` CHAR(6) COMMENT '密码',
	birthday DATE COMMENT'日期'
	)CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB
	
DESC TABLE `user`;