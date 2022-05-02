#演示整型的是一个
#使用 tinyint 来演示范围 有符号 -128 ~ 127 如果没有符号 0-255
#说明： 表的字符集，校验规则, 存储引擎，使用默认
#1. 如果没有指定 unsinged , 则 TINYINT 就是有符号
#2. 如果指定 unsinged , 则 TINYINT 就是无符号 0-255
-- 默认有符号
CREATE TABLE t2 (
id TINYINT);
-- 无符号
CREATE TABLE t3 (
id TINYINT UNSIGNED);
INSERT INTO t2 VALUES(127); #这是非常简单的添加语句
SELECT * FROM t2;
-- INSERT INTO t2 VALUES(128); # 超出范围 
-- INSERT INTO t2 VALUES(-129); # 超出范围  
SELECT * FROM t2;
INSERT INTO t3 VALUES(255);

-- INSERT INTO t3 VALUES(998);# 超出范围 
-- INSERT INTO t3 VALUES(-1);# 超出范围 

SELECT * FROM t3;