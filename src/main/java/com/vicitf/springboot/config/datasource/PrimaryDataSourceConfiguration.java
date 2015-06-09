package com.vicitf.springboot.config.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.vicitf.springboot.repository.primary"},
		entityManagerFactoryRef = "primaryEntityManagerFactory", //对应primaryEntityManagerFactory
		transactionManagerRef = "primayrTransactionManager")
public class PrimaryDataSourceConfiguration {
	
	@Value("${datasource.primary.alias}")
	private String alias;
	
	@Value("${datasource.primary.url}")
	private String url;
	
	@Value("${datasource.primary.driver-class-name}")
	private String driver;
	
	@Value("${datasource.primary.username}")
	private String username;
	
	@Value("${datasource.primary.password}")
	private String password;
	
	@Value("${datasource.primary.protoTypeCount}")
	private int protoTypeCount;
	
	@Value("${datasource.primary.simultaneousBuildThrottle}")
	private int simultaneousBuildThrottle;
	
	@Value("${datasource.primary.minimumConnectionCount}")
	private int minimumConnectionCount;
	
	@Value("${datasource.primary.maximumConnectionCount}")
	private int maximumConnectionCount;
	
	@Value("${datasource.primary.houseKeepingSleepTime}")
	private int houseKeepingSleepTime;
	
	@Autowired
	HibernateJpaVendorAdapter jpaVendorAdapter;
	
	private JpaVendorAdapter jpaVendorAdapter() {
//        jpaVendorAdapter.setDatabase(Database.ORACLE);
        jpaVendorAdapter.setDatabase(Database.SQL_SERVER);
        return jpaVendorAdapter;
    }
	
	@Bean
	@Primary // 不要的话会报NoUniqueBeanDefinitionException, 多个DataSource必须有一个为Primary
	public DataSource primaryDataSource() {
		ProxoolDataSource dataSource = new ProxoolDataSource(alias);
		dataSource.setDriver(driver);
		dataSource.setDriverUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setPrototypeCount(protoTypeCount); // 最少保持的空闲连接数
		dataSource.setSimultaneousBuildThrottle(simultaneousBuildThrottle); // 同时最大连接数, 不设置时候报了个异常
		dataSource.setMinimumConnectionCount(minimumConnectionCount); // 最小连接数
		dataSource.setMaximumConnectionCount(maximumConnectionCount); // 最大连接数量，如果超过最大连接数量则会抛出异常。连接数设置过多，服务器CPU和内存性能消耗很大。
		dataSource.setHouseKeepingSleepTime(houseKeepingSleepTime); // house keeper 保留线程处于睡眠状态的最长时间
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory primaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(primaryDataSource());
		entityManager.setPackagesToScan("com.vicitf.springboot.domain.primray");
		entityManager.setPersistenceUnitName("primaryPersistentUnit");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter());
		entityManager.afterPropertiesSet(); // 不要的话会报NullPointerException
		return entityManager.getObject();
	}
	
	//不要也可以...
	@Bean
	public PlatformTransactionManager primayrTransactionManager() {
		return new JpaTransactionManager(primaryEntityManagerFactory());
	}
}
