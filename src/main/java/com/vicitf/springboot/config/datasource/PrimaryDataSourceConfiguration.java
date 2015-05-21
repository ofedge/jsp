package com.vicitf.springboot.config.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // 不要也可以...
@EnableJpaRepositories(
		basePackages = {"com.vicitf.springboot.repository.primary"},
		entityManagerFactoryRef = "primaryEntityManagerFactory", //对应primaryEntityManagerFactory, 我就不给Bean指定name了
		transactionManagerRef = "primayrTransactionManager") //同上, 但是不要也可以...
public class PrimaryDataSourceConfiguration {
	
	@Autowired
    JpaVendorAdapter jpaVendorAdapter;
	
	@Bean
	@Primary // 不要的话会报NoUniqueBeanDefinitionException, 多个DataSource必须有一个为Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public EntityManagerFactory primaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(primaryDataSource());
		entityManager.setPackagesToScan("com.vicitf.springboot.domain.primray");
		entityManager.setPersistenceUnitName("primaryPersistentUnit");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.afterPropertiesSet(); // 不要的话会报NullPointerException
		return entityManager.getObject();
	}
	
	//不要也可以...
	@Bean
	public PlatformTransactionManager primayrTransactionManager() {
		return new JpaTransactionManager(primaryEntityManagerFactory());
	}
}
