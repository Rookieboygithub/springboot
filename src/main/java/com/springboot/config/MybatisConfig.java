package com.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 配置mybatis
 */
//@org.springframework.context.annotation.Configuration
public class MybatisConfig implements ConfigurationCustomizer {
	@Bean
	public MybatisConfig mybatisConfig() {
		return new MybatisConfig();
	}

	@Override
	public void customize(Configuration configuration) {
		//设置驼峰辨别
		configuration.setMapUnderscoreToCamelCase(true);
	}

}
