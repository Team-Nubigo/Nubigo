package com.teamprj.nubigo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



@Configuration
public class DBConfiguration {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/nubigo?serverTimezone=Asia/Seoul")
                .username("nubigo")
                .password("nubigo1234")
                .build();
    }

}
