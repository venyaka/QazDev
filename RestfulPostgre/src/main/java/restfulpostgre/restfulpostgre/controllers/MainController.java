package restfulpostgre.restfulpostgre.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulpostgre.restfulpostgre.Database;
import restfulpostgre.restfulpostgre.DatabaseNotFoundException;
import restfulpostgre.restfulpostgre.TestInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Api("realisation the restful service")

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    TestInterface testInterface;

    MainController(TestInterface testInterface) {this.testInterface = testInterface;}

    @GetMapping("/")
    public List<Database> getAllSalams() {
        return testInterface.findAll();
    }
//
//    @GetMapping("/{id}")
//    public Database retrieveStudent(@PathVariable long id) {
//        Optional<Database> database = testInterface.findById(id);
//
//        if (database.isEmpty())
//            throw new DatabaseNotFoundException("id-" + id);
//
//        return database.get();
//    }

    @GetMapping("/{string}")
    public List<Database> getSalam(@PathVariable String string) {
        List<Database> database = testInterface.findBySalamContainingIgnoreCase(string);

        if (database.isEmpty())
            throw new DatabaseNotFoundException("There is no Salam with " + string);

        return database;
    }

    @PostMapping("/{salam}")
    public Database newSalam(@RequestBody Database newDatabase, @PathVariable String salam) {
        newDatabase.setSalam(salam);
        return testInterface.save(newDatabase);
    }



}