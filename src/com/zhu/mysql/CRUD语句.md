# 数据库C[create]R[read]U[update]D[delete]语句
## 1. insert添加数据
        []代表可省略
    INSERT INTO table_name [(column[,column...])]
    VALUES (value [,value...]);
    使用细节：
    -- 1，插入的数据应与字段数据类型相同
    -- 比如 把 'abc' 添加到 int 类型会错误
    INSERT INTO `goods` (id, goods_name, price)
    VALUES('韩顺平', '小米手机', 2000);
    
    -- 2. 数据的长度应在列的规定范围内，例如：不能将一个长度为80的字符串加入到长度为40的列中
    -- 3. 在 values 中列出的数据位置必须与被加入的列的排列位置相对应。
    -- 4. 字符和日期型数据应包含在单引号中。
    -- 5. 列可以插入空值[前提是该字段允许为空]，insert into table value(null)
    -- 6. insert into tab_name (列名..) values (),(),() 形式添加多条记录
    -- 7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称
    -- 8. 默认值的使用，当不给某个字段值时，如果有默认值就会添加默认值，否则报错
    -- 如果某个列 没有指定 not null ,那么当添加数据时，没有给定值，则会默认给null
    -- 如果我们希望指定某个列的默认值，可以在创建表时指定

## 2.update 修改
    UPDATE table_name
        SET col_name1= expr1[, col_name2= expr2 ...]
        [WHERE where_definition]
    使用细节
    1.update语法可以用新值更新原有表行中的各列
    2.set子句指示要修改哪些列和要给予哪些值
    3.where子句指定应更新哪些行，如果没有where子句，则更新所有的
    行(记录)
    4.如果需要修改多个字段，可以通过set 字段1=值1,字段2=值2...

## 3. delete
    delete from table_name [where where_definition]
    
    使用细节
    1.如果不使用where子句，将删除表中所有数据
    2.delete 语句不能删除某一列的值(可使用update 设为 null 或者'')
    3.使用delete语句仅删除记录，不删除表本身。如果要删除表，使用drop
    table语句。drop table 表名;
    
## 4.select []省略，|或者
    1 基本语法
    select [distinct] *|{column1,column2,column3... } from table_name;
    注意事项
    select指定查询那些列
    column1指定列名
    *号代表查询所有列
    from指定查询哪张表
    distinct可选，指显示结果时，是否去掉重复数据

    2.使用表达式对查询的列进行运算
        select *|{column1|expression ,column2|expression,column3... } from table_name;
    3.在 select 语句中可使用 as 语句
    select column_name as 别名 from table_name;

    4. 在 where 子句中经常使用的运算符
        比较运算符
        > < <= >= = <> !=   大于、小于、大于（小于）等于、不等于
        BETWEEN...AND... 显示在某一区间值
        in(set) 显示在in列表中的值，例如：in(100,200)
        like '张pattern' 模糊查询
        not like '' 模糊查询
        is null 判断是否为空
        逻辑运算符
        and 多个条件同时成立
        or 多个条件任一成立
        not 不成立 例如： where not(salary>100)
        
    5.使用 order by 子句排序查询结果
        SELECT column1,column1,column1... FROM table ORDER BY column1 asc|desc ....
        1.ORDER by 指定排序顺序的列，排序的列既可以是表中的列名、也可以是select 语句指定的列名
        2，asc 升序【默认】、desc 降序
        3.order by 子句应位于select语句的结尾
    
    6.合计，统计函数
        count 返回行的总数
        

