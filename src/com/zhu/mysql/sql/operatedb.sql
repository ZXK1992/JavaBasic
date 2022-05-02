# 演示数据库的操作

#使用指令创建数据库
CREATE DATABASE zxk_db01;
#删除数据库指令
DROP DATABASE zxk_db01;
#创建一个使用 utf8 字符集的 zxk_db02 数据库
CREATE DATABASE zxk_db02 CHARACTER SET utf8;
#创建一个使用 utf8 字符集，并带校对规则的 zxk_db03 数据库
CREATE DATABASE zxk_db03 CHARACTER SET utf8 COLLATE utf8_bin;
#校对规则 utf8_bin 区分大小 默认 utf8_general_ci 不区分大小写
SELECT * FROM zxk_db02.t1 WHERE `name`='tom';
SELECT * FROM zxk_db03.t1 WHERE `name`='tom';

-- 1.查看当前数据库服务器中的所有数据库
SHOW DATABASES;
-- 2.查看前面创建的db1数据库的定义信息
SHOW CREATE DATABASE db1;
#老师说明 在创建数据库,表的时候，为了规避关键字，可以使用反引号解决
#删除前面创建的 db1 数据库
DROP DATABASE db1;