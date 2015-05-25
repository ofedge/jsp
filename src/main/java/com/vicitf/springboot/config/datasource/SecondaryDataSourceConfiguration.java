package com.vicitf.springboot.config.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @see com.vicitf.springboot.config.datasource.PrimaryDataSourceConfiguration
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.vicitf.springboot.repository.secondary"},
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDataSourceConfiguration {
	
	@Value("${datasource.secondary.alias}")
	private String alias;
	
	@Value("${datasource.secondary.url}")
	private String url;
	
	@Value("${datasource.secondary.driver-class-name}")
	private String driver;
	
	@Value("${datasource.secondary.username}")
	private String username;
	
	@Value("${datasource.secondary.password}")
	private String password;
	
	@Value("${datasource.secondary.protoTypeCount}")
	private int protoTypeCount;
	
	@Value("${datasource.secondary.simultaneousBuildThrottle}")
	private int simultaneousBuildThrottle;
	
	@Value("${datasource.secondary.minimumConnectionCount}")
	private int minimumConnectionCount;
	
	@Value("${datasource.secondary.maximumConnectionCount}")
	private int maximumConnectionCount;
	
	@Value("${datasource.secondary.houseKeepingSleepTime}")
	private int houseKeepingSleepTime;
	
	@Autowired
    JpaVendorAdapter jpaVendorAdapter;
	
	@Bean
	public DataSource secondaryDataSource() {
		ProxoolDataSource dataSource = new ProxoolDataSource(alias);
		dataSource.setDriver(driver);
		dataSource.setDriverUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setPrototypeCount(protoTypeCount);
		dataSource.setSimultaneousBuildThrottle(simultaneousBuildThrottle);
		dataSource.setMinimumConnectionCount(minimumConnectionCount);
		dataSource.setMaximumConnectionCount(maximumConnectionCount);
		dataSource.setHouseKeepingSleepTime(houseKeepingSleepTime);
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory secondaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(secondaryDataSource());
		entityManager.setPackagesToScan("com.vicitf.springboot.domain.secondary");
		entityManager.setPersistenceUnitName("secondaryPersistentUnit");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.afterPropertiesSet();
		return entityManager.getObject();
	}
	
	@Bean
	public PlatformTransactionManager secondaryTransactionManager() {
		return new JpaTransactionManager(secondaryEntityManagerFactory());
	}
}