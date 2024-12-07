package com.redis_poc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Value("${use.h2:true}")
    private boolean useH2;

    @Bean
    public DataSource dataSource() {
        if (useH2) {
            return DataSourceBuilder.create()
                    .url("jdbc:h2:mem:testdb")
                    .driverClassName("org.h2.Driver")
                    .username("sa")
                    .password("password")
                    .build();
        } else {
            return DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost:3306/testdb")
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .username("root")
                    .password("root")
                    .build();
        }
    }
}