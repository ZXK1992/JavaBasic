# 修改表的操作
-- 员工表 emp 的上增加一个 image 列，varchar 类型(要求在 resume 后面)。
ALTER TABLE emp ADD image VARCHAR(300) NOT NULL DEFAULT '' AFTER `resume`;


ALTER TABLE emp MODIFY image VARCHAR(32);
-- 修改 job 列，使其长度为 60。
ALTER TABLE emp MODIFY job VARCHAR(60) NOT NULL DEFAULT '';

DESC emp;

-- 删除sex列
ALTER TABLE emp DROP sex;

-- 表名改为 employee。
RENAME TABLE emp TO employee;
-- 显示表结构，可以查看表的所有列
DESC employee;


-- 改字符集
ALTER TABLE employee CHARACTER SET utf8;

-- 修改列名name为user_name
ALTER TABLE employee CHANGE COLUMN `name`  user_name VARCHAR(20);
ALTER TABLE employee MODIFY user_name VARCHAR(64)  NOT NULL DEFAULT '';

ALTER TABLE employee MODIFY image  VARCHAR(32)  NOT NULL DEFAULT '';