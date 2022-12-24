package com.example.springjdbc.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ConfigJDBC {
    @Bean
    public NamedParameterJdbcTemplate template(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
