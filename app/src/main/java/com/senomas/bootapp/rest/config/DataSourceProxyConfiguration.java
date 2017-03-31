package com.senomas.bootapp.rest.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.senomas.bootapp.rest.DataSourceStat;

@Configuration
public class DataSourceProxyConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	public DataSource proxyDataSource() {
		return DataSourceStat.proxyDataSource(dataSourceProperties());
	}

}
