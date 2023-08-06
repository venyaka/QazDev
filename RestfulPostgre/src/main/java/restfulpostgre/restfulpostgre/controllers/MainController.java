package restfulpostgre.restfulpostgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulpostgre.restfulpostgre.Database;
import restfulpostgre.restfulpostgre.DatabaseNotFoundException;
import restfulpostgre.restfulpostgre.TestInterface;

import java.util.List;
import java.util.Optional;
//@Api("realisation the restful service")

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    TestInterface testInterface;

    @GetMapping("/")
    public List<Database> retrieveAllStudents() {
        return testInterface.findAll();
    }

    @GetMapping("/{id}")
    public Database retrieveStudent(@PathVariable long id) {
        Optional<Database> database = testInterface.findById(id);

        if (database.isEmpty())
            throw new DatabaseNotFoundException("id-" + id);

        return database.get();
    }
}