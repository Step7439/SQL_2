package com.example.springjdbc.repository;

import com.example.springjdbc.model.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class RepositoryJDBC {
    private final NamedParameterJdbcTemplate template;

    public RepositoryJDBC(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    public Person getProductName(String name){
        //String sql = "SELECT * FROM customers WHERE customers.name = :name";
        String sql = read("schema.sql");
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", name);
        return template.queryForObject(sql, parameterSource, (rs, rowNum) ->
        {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setSurname(rs.getString("surname"));
            person.setAge(rs.getInt("age"));
            //person.setPhoneNumber(rs.getString("phoneNumber"));
           // person.setProduct_name(rs.getString("product_name"));
            return person;
        });
    }

    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
