package com.example.springjdbc.control;

import com.example.springjdbc.model.Person;
import com.example.springjdbc.repository.RepositoryJDBC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlJDBC {

    private final RepositoryJDBC repositoryJDBC;

    public ControlJDBC(RepositoryJDBC repositoryJDBC) {
        this.repositoryJDBC = repositoryJDBC;
    }

    @GetMapping("/")
    public Person getSqlSetup(@RequestParam String name) {
        return repositoryJDBC.getProductName(name);
    }
}
