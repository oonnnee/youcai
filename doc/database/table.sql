

drop table if exists `guest`;
create table `guest`(
	`id` varchar(10),
	`pwd` varchar(20),
	`name` varchar(60),
	`addr` varchar(100),
	`phone` varchar(30),
	`mobile1` varchar(30) comment '客户负责人1手机号',
	`leader1` varchar(30) comment '客户负责人1姓名',
	`mobile2` varchar(30) comment '客户负责人2手机号',
	`leader2` varchar(30) comment '客户负责人2姓名',
	`note` varchar(100),

	primary key(`id`)
)comment='客户与后台管理人员表';

drop table if exists `category`;
create table `category`(
	`code` varchar(4),
	`name` varchar(20),
	`note` varchar(100),

	primary key(`code`)
)comment='产品大类编码表';


drop table if exists `product`;
create table `product`(
	`id` varchar(10),
	`name` varchar(30),
	`p_code` varchar(4) comment '产品大类编码',
	`unit` varchar(10),
	`price` decimal(12,2),
	`imgfile` varchar(100),
	`note` varchar(100),

	primary key(`id`)
)comment='产品信息表';


drop table if exists `pricelist`;
create table `pricelist`(
	`pdate` date comment '报价日期',
	`guest_id` varchar(10),
	`product_id` varchar(10),
	`price` decimal(12,2) comment '报价',
	`note` varchar(100),

	primary key(`pdate`, `guest_id`, `product_id`)
)comment='客户报价单';


drop table if exists `orders`;
create table `orders`(
	`odate` date comment '订货日期',
	`guest_id` varchar(10),
	`product_id` varchar(10),
	`price` decimal(12,2) comment '报价',
	`num` decimal(12,2) comment '下单量',
	`amount` decimal(20,2) comment '该货物订购总金额',
	`note` varchar(100),

	primary key(`odate`, `guest_id`, `product_id`)
)comment='客户采购单';


drop table if exists `driver`;
create table `driver`(
	`id` varchar(4),
	`name` varchar(30),
	`cardid` char(18) comment '司机身份证号',
	`mobile` varchar(30),
	`note` varchar(100),

	primary key(`id`)
)comment='送货司机表';


drop table if exists `d_list`;
create table `d_list`(
	`d_id` varchar(4) comment '送货司机编号',
	`guest_id` varchar(10) comment '客户编号',
	`ddate` datetime comment '送货时间',
	`product_id` varchar(10) comment '产品编号',
	`price` decimal(20,2) comment '产品单价',
	`num` decimal(12,2) comment '产品数量',
	`amount` decimal(20,2),
	`note` varchar(100),

	primary key(`d_id`, `guest_id`, `ddate`, `product_id`)
)comment='送货单';