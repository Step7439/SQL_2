package com.example.springjdbc;

import com.example.springjdbc.repository.RepositoryJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);

    }
}