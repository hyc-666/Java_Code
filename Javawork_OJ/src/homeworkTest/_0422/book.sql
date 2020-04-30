--设计一张图书表，包含以下字段：图书名称，图书作者、图书价格、图书分类

CREATE TABLE books(
    name VARCHAR(100),
    author VARCHAR(100),
    price DECIMAL(13,2);
    type VARCHAR(40)
);


--设计一张老师表，包含以下字段：姓名、年龄、身高、体重、性别、学历、生日、身份证号

CREATE TABLE teachers(
    name VARCHAR(100),
    age SMALLINT,
    height INT, --单位为cm
    weight DECIMAL(5,2), --单位为kg
    sex VARCHAR(2),
    degree VARCHAR(140),--学历
    birthday DATE,
    ID_number VARCHAR(20)
);

--设计一张商品表，包含以下字段：商品名称、商品价格、商品库存、商品描述

CREATE TABLE merchandise(
    name VARCHAR(120),
    price DECIMAL(13,2),
    inventory INT,--库存
    description VARCHAR(400) --描述
);

--在以上创建的商品表中插入一条数据：名称为“学生书包”、价格18.91、库存101、描述为空

INSERT INTO merchandise VALUE('学生书包',18.91,101,NULL);

--在图书表中新增一条记录：Java核心技术、作者“Cay S. Horstman”，价格56.43，分类为“计算机技术”

INSERT INTO books VALUE('Java核心技术','Cay S.Horstman',56.43,'计算机技术');

--student学生表中，字段有姓名name，年龄age，要求查询姓张，并且年龄在18到25岁之间的学生

SELECT name FROM student where name LIKE '张%' AND age BETWEEN 18 AND 25;

--查询article文章表中，发表日期create_date在2019年1月1日上午10点30分至2019年11月10日下午4点2分的文章

--我不清楚这个日期区间应该怎么描述

--查询article文章表中，文章标题title为空，或者满足发表日期create_date在2019年1月1日之后

--同样不知道日期怎么排查
