package com.vicitf.springboot.config.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(primaryDataSource())
				.packages("com.vicitf.springboot.domain.primary")
				.persistenceUnit("primaryPersistentUnit")
				.build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(secondaryDataSource())
				.packages("com.vicitf.springboot.domain.secondary")
				.persistenceUnit("secondaryPersistentUnit")
				.build();
	}
}
