# spring boot

1. 尝试一下用spring boot来开发, spring data jpa感觉好神奇, spring mvc还是那个spring mvc, 没太大差别,
倒是第一次发现@Controller和@RestController的区别(实际上是第一次用@RestController, 要json我都@ResponseBody了...)
1. LoginFilter即使不在MyConfiguration中注册也可以, 不过注册上也不麻烦嘛, 而且想不用的时候enable掉就可以了
1. StartupListener执行的比我想象的早多了, Banner还没出来就执行了, (既然这样, 所以, 你就打酱油吧...) MyConfiguration里的那个Listener才是我要的
1. CacheConfiguration上的@EnableCaching让我有些顾虑, 不知道是不是不加它里面的东西就没用了, 本来想把MyConfiguration里的东西也写在CacheConfiguration里的
但是放弃了, 总觉得他们用不到@EnableCaching还呆在里面太不好意思了, 虽然执行没问题. 还有那个神奇的@Cacheable和@CacheEvict以及里面的value和key
1. favicon.ico, 原来以为不生效, 查了好久好久, 各种尝试, 最后换个浏览器一看, 出来了, 该死的Firefox缓存...
1. log4j不用也是可以的, spring boot自带了logging了, 就是在application.properties里写两句话就有了, 但是我只是想试试,
成功了, 比之前弄的还简单, 虽然那个log4j.properties里面写的东西看着头疼
1. 虽然说spring boot是可以把一个项目打包成一个jar文件的, 但是在WEB-INF下面的jsp就没法打包了(据说修改servlet访问jsp路径可以实现?),
但是也可以不用jsp全部用html, 同静态文件一起放进static里, 这样子的问题是访问[http://localhost:8014/]("http://localhost:8014/","")会404, 
必须指定访问index.html才行
1. 多数据源配置, 第二数据源都是MySQL, 第一数据源一个Oracle, 一个是Sql_Server(一个比一个安装起来麻烦), 参照[multids-demo]("https://github.com/gratiartis/multids-demo","")
报过各种各种错误, 最后还好出来了, 它的sample里很多代码都用不到
1. 打包war文件, 去掉pom里build, 两个tomcat依赖加上<scope>provided</scope>, Applicaton类继承SpringBootServletInitializer, 同时自定义条幅设置位置放在configure方法里
1. 去配置过程, 虽然可以把数据库连接都直接以字符串形式写在dataSource里, 但是还是写perperties里吧, 怎么可能零配置嘛...
1. 不同的数据源, HibernateJpaVendorAdapter要设置不同的数据库, 之前没用复杂的查询所以没发现我的secondary数据库用的也是primary数据库的设置
1. 用了spring data jpa的分页, 有点让人不舒服的, PageRequest(Pageable的一个实现类)的page属性, 是从0开始的

maven本地仓库安装oracle jdbc, 进入jdbc6.jar所在文件夹:

`mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar -Dfile=ojdbc6.jar`

maven本地仓库安装sqlserver jdbc, 进入 sqljdbc4.jar所在文件夹:

`mvn install:install-file -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar -Dfile=sqljdbc4.jar`

maven本地仓库安装proxool-0.9.1, 进入 proxool-0.9.1.jar所在文件夹:

`mvn install:install-file -DgroupId=proxool -DartifactId=proxool -Dversion=0.9.1 -Dpackaging=jar -Dfile=proxool-0.9.1.jar`

使用:

```
<dependency>
	<groupid>com.oracle</groupid>
	<artifactid>ojdbc14</artifactid>
	<version>10.2.0.4.0</version>
</dependency>

<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>sqljdbc4</artifactId>
    <version>4.0</version>
</dependency>

<dependency>
	<groupId>proxool</groupId>
	<artifactId>proxool</artifactId>
	<version>0.9.1</version>
</dependency>
```