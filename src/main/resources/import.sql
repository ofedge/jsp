--选择不同主数据库时候要注意的地方:
--1. application.properties的数据库连接配置
--2. User的注解类
--3. PrimaryDataSourceConfiguration类中JpaVendorAdapterConfiguration方法里的database设置


--PrimaryDataSource

--SQL Server
drop table [test].[dbo].[t_user];
create table [test].[dbo].[t_user](
  id int primary key identity(1,1),
  username varchar(20) not null unique,
  password varchar(20),
  realname varchar(50),
  gender varchar(10),
  email varchar(50),
  avatar varchar(50),
  login_address varchar(20)
);

insert into [test].[dbo].[t_user](username, password, avatar) values ('admin','admin','default.png');

--Oracle
drop sequence user_seq;
drop table t_user;
create sequence user_seq;
create table t_user(
  id number(11) primary key,
  username varchar2(20) not null unique,
  password varchar2(20),
  realname varchar2(50),
  gender varchar2(10),
  email varchar2(50),
  avatar varchar2(50),
  login_address varchar2(20)
);
insert into t_user(id, username, password, avatar) values (user_seq.nextval, 'admin','admin','default.png');

--SecondaryDataSource

--MySQL
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_person` VALUES ('1', 'Jennifer', 'JDILLY', '29', 'female', '20');
INSERT INTO `t_person` VALUES ('2', 'Timothy', 'TGATES', '20', 'male', '18');
INSERT INTO `t_person` VALUES ('3', 'Randall', 'RPERKINS', '16', 'male', '8');
INSERT INTO `t_person` VALUES ('4', 'Sarah', 'SBELL', '24', 'female', '10');
INSERT INTO `t_person` VALUES ('5', 'Britney', 'BEVERETT', '20', 'male', '2');
INSERT INTO `t_person` VALUES ('6', 'Samuel', 'SMCCAIN', '13', 'female', '3');
INSERT INTO `t_person` VALUES ('7', 'Vance', 'VJONES', '14', 'male', '8');
INSERT INTO `t_person` VALUES ('8', 'Alana', 'AWALSH', '13', 'female', '6');
INSERT INTO `t_person` VALUES ('9', 'Kevin', 'KFEENEY', '20', 'male', '8');
INSERT INTO `t_person` VALUES ('10', 'Donald', 'DOCONNEL', '11', 'male', '22');
INSERT INTO `t_person` VALUES ('11', 'Douglas', 'DGRANT', '14', 'male', '20');
INSERT INTO `t_person` VALUES ('12', 'Jennifer', 'JWHALEN', '22', 'female', '12');
INSERT INTO `t_person` VALUES ('13', 'Michael', 'MHARTSTE', '13', 'male', '20');
INSERT INTO `t_person` VALUES ('14', 'Pat', 'PFAY', '26', 'male', '21');
INSERT INTO `t_person` VALUES ('15', 'Susan', 'SMAVRIS', '28', 'female', '1');
INSERT INTO `t_person` VALUES ('16', 'Hermann', 'HBAER', '22', 'male', '6');
INSERT INTO `t_person` VALUES ('17', 'Shelley', 'SHIGGINS', '20', 'female', '5');
INSERT INTO `t_person` VALUES ('18', 'William', 'WGIETZ', '27', 'male', '8');
INSERT INTO `t_person` VALUES ('19', 'Steven', 'SKING', '25', 'male', '22');
INSERT INTO `t_person` VALUES ('20', 'Neena', 'NKOCHHAR', '18', 'female', '22');
INSERT INTO `t_person` VALUES ('21', 'Lex', 'LDEHAAN', '16', 'male', '21');
INSERT INTO `t_person` VALUES ('22', 'Alexander', 'AHUNOLD', '18', 'male', '14');
INSERT INTO `t_person` VALUES ('23', 'Bruce', 'BERNST', '14', 'male', '9');
INSERT INTO `t_person` VALUES ('24', 'David', 'DAUSTIN', '26', 'male', '3');
INSERT INTO `t_person` VALUES ('25', 'Valli', 'VPATABAL', '24', 'male', '8');
INSERT INTO `t_person` VALUES ('26', 'Diana', 'DLORENTZ', '24', 'female', '10');
INSERT INTO `t_person` VALUES ('27', 'Nancy', 'NGREENBE', '20', 'female', '4');
INSERT INTO `t_person` VALUES ('28', 'Daniel', 'DFAVIET', '24', 'male', '9');
INSERT INTO `t_person` VALUES ('29', 'John', 'JCHEN', '21', 'male', '10');
INSERT INTO `t_person` VALUES ('30', 'Ismael', 'ISCIARRA', '15', 'female', '3');
INSERT INTO `t_person` VALUES ('31', 'Jose Manuel', 'JMURMAN', '11', 'male', '4');
INSERT INTO `t_person` VALUES ('32', 'Luis', 'LPOPP', '26', 'male', '13');
INSERT INTO `t_person` VALUES ('33', 'Den', 'DRAPHEAL', '25', 'male', '7');
INSERT INTO `t_person` VALUES ('34', 'Alexander', 'AKHOO', '22', 'male', '16');
INSERT INTO `t_person` VALUES ('35', 'Shelli', 'SBAIDA', '29', 'female', '16');
INSERT INTO `t_person` VALUES ('36', 'Sigal', 'STOBIAS', '17', 'female', '11');
INSERT INTO `t_person` VALUES ('37', 'Guy', 'GHIMURO', '20', 'male', '7');
INSERT INTO `t_person` VALUES ('38', 'Karen', 'KCOLMENA', '21', 'male', '2');
INSERT INTO `t_person` VALUES ('39', 'Matthew', 'MWEISS', '17', 'female', '11');
INSERT INTO `t_person` VALUES ('40', 'Adam', 'AFRIPP', '15', 'male', '2');
INSERT INTO `t_person` VALUES ('41', 'Payam', 'PKAUFLIN', '18', 'male', '21');
INSERT INTO `t_person` VALUES ('42', 'Shanta', 'SVOLLMAN', '26', 'female', '11');
INSERT INTO `t_person` VALUES ('43', 'Kevin', 'KMOURGOS', '20', 'male', '13');
INSERT INTO `t_person` VALUES ('44', 'Julia', 'JNAYER', '23', 'female', '11');
INSERT INTO `t_person` VALUES ('45', 'Irene', 'IMIKKILI', '14', 'male', '13');
INSERT INTO `t_person` VALUES ('46', 'James', 'JLANDRY', '15', 'male', '10');
INSERT INTO `t_person` VALUES ('47', 'Steven', 'SMARKLE', '13', 'male', '12');
INSERT INTO `t_person` VALUES ('48', 'Laura', 'LBISSOT', '27', 'female', '8');
INSERT INTO `t_person` VALUES ('49', 'Mozhe', 'MATKINSO', '26', 'male', '4');
INSERT INTO `t_person` VALUES ('50', 'James', 'JAMRLOW', '19', 'male', '16');
INSERT INTO `t_person` VALUES ('51', 'TJ', 'TJOLSON', '18', 'male', '1');
INSERT INTO `t_person` VALUES ('52', 'Jason', 'JMALLIN', '25', 'male', '2');
INSERT INTO `t_person` VALUES ('53', 'Michael', 'MROGERS', '29', 'male', '4');
INSERT INTO `t_person` VALUES ('54', 'Ki', 'KGEE', '15', 'male', '16');
INSERT INTO `t_person` VALUES ('55', 'Hazel', 'HPHILTAN', '18', 'male', '3');
INSERT INTO `t_person` VALUES ('56', 'Renske', 'RLADWIG', '24', 'male', '7');
INSERT INTO `t_person` VALUES ('57', 'Stephen', 'SSTILES', '14', 'male', '5');
INSERT INTO `t_person` VALUES ('58', 'John', 'JSEO', '26', 'male', '5');
INSERT INTO `t_person` VALUES ('59', 'Joshua', 'JPATEL', '19', 'female', '8');
INSERT INTO `t_person` VALUES ('60', 'Trenna', 'TRAJS', '12', 'male', '1');
INSERT INTO `t_person` VALUES ('61', 'Curtis', 'CDAVIES', '19', 'male', '4');
INSERT INTO `t_person` VALUES ('62', 'Randall', 'RMATOS', '16', 'male', '17');
INSERT INTO `t_person` VALUES ('63', 'Peter', 'PVARGAS', '10', 'male', '8');
INSERT INTO `t_person` VALUES ('64', 'John', 'JRUSSEL', '15', 'male', '8');
INSERT INTO `t_person` VALUES ('65', 'Karen', 'KPARTNER', '23', 'female', '17');
INSERT INTO `t_person` VALUES ('66', 'Alberto', 'AERRAZUR', '14', 'male', '17');
INSERT INTO `t_person` VALUES ('67', 'Gerald', 'GCAMBRAU', '10', 'male', '9');
INSERT INTO `t_person` VALUES ('68', 'Eleni', 'EZLOTKEY', '24', 'female', '17');
INSERT INTO `t_person` VALUES ('69', 'Peter', 'PTUCKER', '17', 'male', '12');
INSERT INTO `t_person` VALUES ('70', 'David', 'DBERNSTE', '15', 'male', '11');
INSERT INTO `t_person` VALUES ('71', 'Peter', 'PHALL', '28', 'male', '19');
INSERT INTO `t_person` VALUES ('72', 'Christopher', 'COLSEN', '29', 'female', '15');
INSERT INTO `t_person` VALUES ('73', 'Nanette', 'NCAMBRAU', '24', 'female', '19');
INSERT INTO `t_person` VALUES ('74', 'Oliver', 'OTUVAULT', '16', 'male', '3');
INSERT INTO `t_person` VALUES ('75', 'Janette', 'JKING', '11', 'female', '4');
INSERT INTO `t_person` VALUES ('76', 'Patrick', 'PSULLY', '21', 'male', '11');
INSERT INTO `t_person` VALUES ('77', 'Allan', 'AMCEWEN', '24', 'female', '18');
INSERT INTO `t_person` VALUES ('78', 'Lindsey', 'LSMITH', '18', 'male', '14');
INSERT INTO `t_person` VALUES ('79', 'Louise', 'LDORAN', '23', 'male', '13');
INSERT INTO `t_person` VALUES ('80', 'Sarath', 'SSEWALL', '21', 'female', '3');
INSERT INTO `t_person` VALUES ('81', 'Clara', 'CVISHNEY', '13', 'female', '18');
INSERT INTO `t_person` VALUES ('82', 'Danielle', 'DGREENE', '28', 'male', '13');
INSERT INTO `t_person` VALUES ('83', 'Mattea', 'MMARVINS', '20', 'female', '13');
INSERT INTO `t_person` VALUES ('84', 'David', 'DLEE', '21', 'male', '4');
INSERT INTO `t_person` VALUES ('85', 'Sundar', 'SANDE', '21', 'male', '22');
INSERT INTO `t_person` VALUES ('86', 'Amit', 'ABANDA', '20', 'male', '12');
INSERT INTO `t_person` VALUES ('87', 'Lisa', 'LOZER', '21', 'female', '16');
INSERT INTO `t_person` VALUES ('88', 'Harrison', 'HBLOOM', '29', 'male', '22');
INSERT INTO `t_person` VALUES ('89', 'Tayler', 'TFOX', '18', 'female', '14');
INSERT INTO `t_person` VALUES ('90', 'William', 'WSMITH', '19', 'male', '7');
INSERT INTO `t_person` VALUES ('91', 'Elizabeth', 'EBATES', '19', 'male', '14');
INSERT INTO `t_person` VALUES ('92', 'Sundita', 'SKUMAR', '10', 'female', '6');
INSERT INTO `t_person` VALUES ('93', 'Ellen', 'EABEL', '27', 'male', '8');
INSERT INTO `t_person` VALUES ('94', 'Alyssa', 'AHUTTON', '17', 'female', '1');
INSERT INTO `t_person` VALUES ('95', 'Jonathon', 'JTAYLOR', '20', 'male', '3');
INSERT INTO `t_person` VALUES ('96', 'Jack', 'JLIVINGS', '12', 'male', '9');
INSERT INTO `t_person` VALUES ('97', 'Kimberely', 'KGRANT', '11', 'female', '15');
INSERT INTO `t_person` VALUES ('98', 'Charles', 'CJOHNSON', '20', 'male', '3');
INSERT INTO `t_person` VALUES ('99', 'Winston', 'WTAYLOR', '17', 'male', '14');
INSERT INTO `t_person` VALUES ('100', 'Jean', 'JFLEAUR', '22', 'female', '17');
INSERT INTO `t_person` VALUES ('101', 'Martha', 'MSULLIVA', '21', 'female', '21');
INSERT INTO `t_person` VALUES ('102', 'Girard', 'GGEONI', '11', 'male', '7');
INSERT INTO `t_person` VALUES ('103', 'Nandita', 'NSARCHAN', '27', 'female', '16');
INSERT INTO `t_person` VALUES ('104', 'Alexis', 'ABULL', '20', 'male', '17');
INSERT INTO `t_person` VALUES ('105', 'Julia', 'JDELLING', '25', 'female', '12');
INSERT INTO `t_person` VALUES ('106', 'Anthony', 'ACABRIO', '20', 'male', '11');
INSERT INTO `t_person` VALUES ('107', 'Kelly', 'KCHUNG', '16', 'male', '17');

DROP TABLE IF EXISTS `t_country`;
CREATE TABLE `t_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_country` VALUES ('1', 'Aruba', 'Caribbean', 'ABW');
INSERT INTO `t_country` VALUES ('2', 'Bahamas', 'Caribbean', 'BHS');
INSERT INTO `t_country` VALUES ('3', 'Brazil', 'South America', 'BRA');
INSERT INTO `t_country` VALUES ('4', 'Barbados', 'Caribbean', 'BRB');
INSERT INTO `t_country` VALUES ('5', 'China', 'Eastern Asia', 'CHN');
INSERT INTO `t_country` VALUES ('6', 'Greece', 'Southern Europe', 'GRC');
INSERT INTO `t_country` VALUES ('7', 'Grenada', 'Caribbean', 'GRD');
INSERT INTO `t_country` VALUES ('8', 'Haiti', 'Caribbean', 'HTI');
INSERT INTO `t_country` VALUES ('9', 'Israel', 'Middle East', 'ISR');
INSERT INTO `t_country` VALUES ('10', 'Italy', 'Southern Europe', 'ITA');
INSERT INTO `t_country` VALUES ('11', 'Jamaica', 'Caribbean', 'JAM');
INSERT INTO `t_country` VALUES ('12', 'Jordan', 'Middle East', 'JOR');
INSERT INTO `t_country` VALUES ('13', 'Japan', 'Eastern Asia', 'JPN');
INSERT INTO `t_country` VALUES ('14', 'Kenya', 'Eastern Africa', 'KEN');
INSERT INTO `t_country` VALUES ('15', 'Moldova', 'Eastern Europe', 'MDA');
INSERT INTO `t_country` VALUES ('16', 'Namibia', 'Southern Africa', 'NAM');
INSERT INTO `t_country` VALUES ('17', 'New Caledonia', 'Melanesia', 'NCL');
INSERT INTO `t_country` VALUES ('18', 'Niger', 'Western Africa', 'NER');
INSERT INTO `t_country` VALUES ('19', 'Nigeria', 'Western Africa', 'NGA');
INSERT INTO `t_country` VALUES ('20', 'Poland', 'Eastern Europe', 'POL');
INSERT INTO `t_country` VALUES ('21', 'Puerto Rico', 'Caribbean', 'PRI');
INSERT INTO `t_country` VALUES ('22', 'Suriname', 'South America', 'SUR');