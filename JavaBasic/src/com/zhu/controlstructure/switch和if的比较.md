#1.switch和if的比较
    1） 如果判断的具体数值不多，而且符合byte、short、int、char、enum、String这
        6种类型，虽然两个语句都可以使用，建议使用 swtich 语句。
    2) 其他情况：对区间判断，对结果为 boolean 类型判断，使用 if，if 的使用范围更广