# 练习insert 语句
 -- 创建一张商品表goods （id int , goods_name varchar(10),price double);
-- 添加两条记录
use zxk_db02;
 create table goods (
     id int,
     goods_name varchar(10),
     price double NOT NULL DEFAULT 100
 );
INSERT INTO `goods` (id, goods_name, price)
VALUES(10, '华为手机', 2000);
INSERT INTO `goods` (id, goods_name, price)
VALUES(20, '苹果手机', 3000);

select * from zxk_db02.goods;