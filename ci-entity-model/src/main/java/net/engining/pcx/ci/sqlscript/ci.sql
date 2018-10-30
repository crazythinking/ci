SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX IDX_CUSTID ON CI_ADDRESS;
DROP INDEX IDX_TM_CUSTOMER_1 ON CI_CUSTOMER;
DROP INDEX IDX_TM_CUSTOMER_2 ON CI_CUSTOMER;



/* Drop Tables */

DROP TABLE IF EXISTS CI_ADDRESS;
DROP TABLE IF EXISTS CI_CONTACT;
DROP TABLE IF EXISTS CI_CUST_COM_INF;
DROP TABLE IF EXISTS CI_CUSTOMER;




/* Create Tables */

-- 地址信息表
CREATE TABLE CI_ADDRESS
(
	ADDR_ID INT NOT NULL AUTO_INCREMENT COMMENT '地址ID',
	-- 顺序号，无校验位
	CUST_ID VARCHAR(64) NOT NULL COMMENT '客户编号',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.AddressType
	ADDR_TYPE CHAR(1) COMMENT '地址类型',
	-- 国家参数Key
	COUNTRY_CD CHAR(3) COMMENT '国家代码',
	STATE VARCHAR(40) COMMENT '省份',
	CITY VARCHAR(40) COMMENT '城市',
	DISTRICT VARCHAR(40) COMMENT '区县',
	ZIP VARCHAR(10) COMMENT '邮政编码',
	PHONE VARCHAR(20) COMMENT '电话号码',
	ADDRESS VARCHAR(200) COMMENT '详细地址',
	DEFAULT_FLAG BOOLEAN COMMENT '是否默认收货地址',
	RECEIVER VARCHAR(80) COMMENT '收货人姓名',
	MOBILE_NO VARCHAR(20) COMMENT '移动电话',
	UPDATE_TIME TIMESTAMP NOT NULL COMMENT '上次更新时间',
	-- 用户表PROFILE_USER的主键
	UPDATE_USER_ID VARCHAR(40) NOT NULL COMMENT '上次更新用户',
	JPA_VERSION INT NOT NULL COMMENT 'JPA_VERSION',
	PRIMARY KEY (ADDR_ID)
) COMMENT = '地址信息表';


-- 关联人信息表
CREATE TABLE CI_CONTACT
(
	CONTACT_ID INT NOT NULL AUTO_INCREMENT COMMENT '联系人ID',
	-- ###uuid2###
	CUST_ID VARCHAR(64) NOT NULL COMMENT '客户编号',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.Relationship
	RELATIONSHIP CHAR(1) NOT NULL COMMENT '与客户关系',
	NAME VARCHAR(80) COMMENT '姓名',
	MOBILE_NO VARCHAR(20) COMMENT '移动电话',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.Gender
	GENDER CHAR(1) COMMENT '性别',
	BIRTHDAY DATE COMMENT '生日',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.IdType
	ID_TYPE CHAR(1) COMMENT '证件类型',
	ID_NO VARCHAR(30) COMMENT '证件号码',
	-- 关联人本身是系统客户时的客户ID
	RE_CUST_ID VARCHAR(64) NOT NULL COMMENT '关联人客户编号',
	UPDATE_TIME TIMESTAMP NOT NULL COMMENT '上次更新时间',
	-- 用户表PROFILE_USER的主键
	UPDATE_USER_ID VARCHAR(40) NOT NULL COMMENT '上次更新用户',
	JPA_VERSION INT NOT NULL COMMENT 'JPA_VERSION',
	PRIMARY KEY (CONTACT_ID)
) COMMENT = '关联人信息表';


-- 客户基本信息表
CREATE TABLE CI_CUSTOMER
(
	-- ###uuid2###
	CUST_ID VARCHAR(64) NOT NULL COMMENT '客户编号',
	MOBILE_NO VARCHAR(20) NOT NULL COMMENT '移动电话',
	ID_NO VARCHAR(30) COMMENT '证件号码',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.IdType
	ID_TYPE CHAR(1) COMMENT '证件类型',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.EmpPositionAttrType
	TITLE CHAR(1) COMMENT '称谓',
	NAME VARCHAR(80) COMMENT '姓名',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.Gender
	GENDER CHAR(1) COMMENT '性别',
	BIRTHDAY DATE COMMENT '生日',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.OccupationType
	OCCUPATION CHAR(1) COMMENT '职业',
	NATIONALITY VARCHAR(50) COMMENT '国籍',
	LOCATION VARCHAR(50) COMMENT '所在地区',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.MaritalStatus
	-- 
	MARITAL_STATUS CHAR(1) COMMENT '婚姻状况',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.EducationType
	QUALIFICATION CHAR(1) COMMENT '教育状况',
	EMAIL VARCHAR(80) COMMENT '电子邮箱',
	-- !!!java.lang.Boolean!!!
	EMP_STATUS CHAR(1) COMMENT '就业状态',
	LANGUAGE_IND VARCHAR(4) COMMENT '语言代码',
	UPDATE_TIME TIMESTAMP NOT NULL COMMENT '上次更新时间',
	-- 用户表PROFILE_USER的主键
	UPDATE_USER_ID VARCHAR(40) NOT NULL COMMENT '上次更新用户',
	JPA_VERSION INT NOT NULL COMMENT 'JPA_VERSION',
	PRIMARY KEY (CUST_ID)
) COMMENT = '客户基本信息表';


-- 客户所属企业信息表
CREATE TABLE CI_CUST_COM_INF
(
	COMP_NO INT NOT NULL AUTO_INCREMENT COMMENT '企业编号',
	-- ###uuid2###
	CUST_ID VARCHAR(64) NOT NULL COMMENT '客户编号',
	COMP_NAME VARCHAR(100) COMMENT '企业名称',
	ORG_ID VARCHAR(20) COMMENT '企业机构代码',
	BIZ_CERT_NO VARCHAR(20) COMMENT '营业执照注册号',
	BIZ_CERT_ADD VARCHAR(40) COMMENT '营业执照注册地',
	COMP_PHONE VARCHAR(20) COMMENT '企业电话',
	FROM_DATE DATE COMMENT '成立日期',
	TRADE_RANGE VARCHAR(500) COMMENT '经营范围',
	REG_AMT DECIMAL(15,3) COMMENT '注册资本',
	CONTACTER VARCHAR(60) COMMENT '企业联系人姓名',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.EmpPositionAttrType
	CONTACTER_POS CHAR(1) COMMENT '企业联系人职务',
	CONTACT_TEL VARCHAR(11) COMMENT '企业联系人手机号',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.CorpSic
	CORP_SIC CHAR(3) COMMENT '行业代码',
	TAX_NO VARCHAR(30) COMMENT '税务证号',
	BUSINESS_LIMIT DATE COMMENT '营业期限',
	COM_INCOME DECIMAL(15,3) COMMENT '营业收入',
	WORK_YEAR INT COMMENT '行业从事年限',
	EARN_AMT DECIMAL(15,3) COMMENT '利润总额',
	ASSET_AMT DECIMAL(15,3) COMMENT '资产总额',
	-- ///
	-- @net.engining.pcx.ci.infrastructure.shared.enums.CorpStructure
	COM_TYPE CHAR(2) COMMENT '公司性质',
	DEBT_RATIO DECIMAL(5,3) COMMENT '资产负债率',
	-- 法人姓名
	LEGAL_PERSON_NAME VARCHAR(30) COMMENT '法人姓名',
	-- 法人身份证
	LP_IDNO VARCHAR(30) COMMENT '法人身份证',
	UPDATE_TIME TIMESTAMP NOT NULL COMMENT '上次更新时间',
	-- 用户表PROFILE_USER的主键
	UPDATE_USER_ID VARCHAR(40) NOT NULL COMMENT '上次更新用户',
	JPA_VERSION INT NOT NULL COMMENT 'JPA_VERSION',
	PRIMARY KEY (COMP_NO)
) COMMENT = '客户所属企业信息表';



/* Create Indexes */

CREATE INDEX IDX_CUSTID ON CI_ADDRESS (CUST_ID ASC);
-- 证件号/组织/证件类型
CREATE UNIQUE INDEX IDX_TM_CUSTOMER_1 ON CI_CUSTOMER (ID_NO ASC, ID_TYPE ASC);
-- 客户编号
CREATE INDEX IDX_TM_CUSTOMER_2 ON CI_CUSTOMER (CUST_ID ASC);



