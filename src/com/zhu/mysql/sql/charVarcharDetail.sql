#演示字符串类型的使用细节
#char(4) 和 varchar(4) 这个 4 表示的是字符，而不是字节, 不区分字符是汉字还是字母
CREATE TABLE t09(
`name` CHAR(4));
INSERT INTO t09 VALUES('韩顺平好');
-- 超出字符串的字符数4
INSERT INTO t09 VALUES('abc123');
SELECT * FROM t09;

CREATE TABLE t10(
`name` VARCHAR(4));
INSERT INTO t10 VALUES('朱小康好');
INSERT INTO t10 VALUES('ab 北京');
SELECT * FROM t10;
#如果 varchar 不够用，可以考试使用 mediumtext 或者 longtext, #如果想简单点，可以使用直接使用 text
CREATE TABLE t11( content TEXT, content2 MEDIUMTEXT , content3 LONGTEXT);
INSERT INTO t11 VALUES('韩顺平教育', '韩顺平教育 100', '韩顺平教育 1000~~');
SELECT * FROM t11;
