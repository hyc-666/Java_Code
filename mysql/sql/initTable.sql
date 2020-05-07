--创建水浒英雄表
CREATE TABLE hero(
    `id` INT,
    `name` VARCHAR(40),
    `nickname` VARCHAR(60),
    `constellation` VARCHAR(80) comment '星宿'
);

--插入几条测试数据
INSERT INTO hero VALUES (1,'宋江','及时雨','天魁星');
INSERT INTO hero VALUES (2,'卢俊义','玉麒麟','天罡星');
INSERT INTO hero VALUES (3,'吴用','智多星','天机星');
INSERT INTO hero VALUES (4,'公孙胜','入云龙','天闲星');
INSERT INTO hero VALUES (5,'关胜','大刀','天勇星');
