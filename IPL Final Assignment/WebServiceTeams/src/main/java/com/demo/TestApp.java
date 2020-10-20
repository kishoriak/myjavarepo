package com.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@EnableEurekaClient
public class TestApp {

	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}
	
	@Bean
	public DataSource getDataSource() {
		System.out.println("Data source created");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setUrl("jdbc:derby:P:\\HSBC_DB\\hsbcdb");
        dataSource.setUsername("hsbc");
        dataSource.setPassword("hsbc123");
        return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		System.out.println("JdbcTemplate created");	
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
