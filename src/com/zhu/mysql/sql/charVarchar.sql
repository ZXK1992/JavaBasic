# 演示字符串类型使用
#注释的快捷键 shift+ctrl+c , 注销注释 shift+ctrl+r
-- CHAR(size)
-- 固定长度字符串 最大 255 字符
-- VARCHAR(size) 0~65535 字节
-- 可变长度字符串 最大 65532 字节 【utf8 编码最大 21844 字符 1-3 个字节用于记录大小】-- 如果表的编码是 utf8 varchar(size) size = (65535-3) / 3 = 21844
-- 如果表的编码是 gbk varchar(size) size = (65535-3) / 2 = 32766
-- 超出长度范围 CREATE TABLE t08 (`name` CHAR(256));
CREATE TABLE t08 (`name` CHAR(255));

INSERT INTO t08 VALUES('a');
SELECT * FROM t08;
CREATE TABLE t09 (
`name` VARCHAR(32766)) CHARSET gbk;
DROP TABLE t09;
