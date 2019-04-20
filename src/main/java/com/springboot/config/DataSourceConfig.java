package com.springboot.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 通过java配置数据源
 */
//@Configuration
public class DataSourceConfig {
	//方式一
	@Value("${spring.datasource.driver-class-name}")
	private String jdbcDriver;
	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	@Value("${spring.datasource.username}")
	private String jdbcUser;
	@Value("${spring.datasource.password}")
	private String jdbcPassword;

	@Bean
	public DataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(jdbcDriver);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		// 关闭连接后不自动提交
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
	}

	@Autowired
	Environment env;

	@Bean
	public DataSource createDataSourceByIOC() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		//设置初始线程数
		dataSource.setInitialPoolSize(5);
		//设置线程池中空闲最少线程
		dataSource.setMinPoolSize(5);
		//连接池保持最大空闲数
		dataSource.setMaxPoolSize(20);
		//部分数据未配置
		// 关闭连接后不自动提交
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
	}
}
