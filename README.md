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
1. 切换oracle要修改的东西, application.properties的数据库连接配置, User的注解类和PrimaryDataSourceConfiguration类中JpaVendorAdapterConfiguration的database. 
刚换成oracle时候连接报错了, 找原因, 找了一会儿没找到, 再试, 好了...
1. 继续增加字段, 新增country类, 折腾maven折腾了半天...
1. 分页findAll(Pageable pageable)方法加上缓存使用不正常了, 即使查询参数变了, 还是从缓存中读取数据
1. 自定义查询, 新建一个自定义Repository, 名字以对应Repository+Impl格式, 但不继承Repository, 在Repository写的方法在Impl类中实现, 框架会识别的,
查询结果返回自定义bean, 需要调用query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(Bean.class)), 挺好, hibernate还要自己去实现这个方法
1. filter和interceptor相互拦截的有点恶心, 不过还好可以了, 指定时间段内不能访问做成功了, 顺便整理一下类, 接下来研究spring mvc吧
1. 做spring mvc文件上传来着, 又要添加注册功能, 还添加了bootstrap, 突然忙不过来了
1. 未注册前的所有动作都要加到filter过滤列表里, 比如检查用户名时候, 会报302, 然后就重定向到首页了, 当然ajax方法是不会在当前页跳转的
1. 模仿spring mvc的分页做了个分页, 按自己想法实现的, 好麻烦啊, 自定义查询好像每次query.getResultList()之后EntityManager就关闭了
1. Transformers.aliasToBean(Class class)并不好, 我要的是Long型, 它非说出来是Integer型, 转不过去, 我数据库字段长度11转Long怎么了, 上次oracle里你给我转成BigDecimal还没跟你计较呢
(哦不对, sqlserver主键int, 没长度, 貌似也不能设置长度)
1. 重大问题, 修改时候会报异常: `javax.persistence.TransactionRequiredException: Executing an update/delete query`, 事务哪里出错了么
使用jpa风格的方式来写, 加@Modifying注解, 依然报错, 加@Transactional, 指明事务就好了, 这个@Transactional是springframework的那个, 加在repository里面和service里没区别

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