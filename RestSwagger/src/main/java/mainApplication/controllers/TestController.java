package mainApplication.controllers;

import mainApplication.Database;
import mainApplication.DatabaseNotFoundException;
import mainApplication.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
//@Api("realisation the restful service")

@RestController
@RequestMapping("/main")
public class TestController {

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


//    @GetMapping("/")
//    public ResponseEntity<List<Database>> getAllTutorials(@RequestParam(required = false) String title) {
//
//
//        try {
//            List<Database> databasese = new ArrayList<Database>();
//
//            if (title == null)
//                databasese.addAll(testInterface.findAll());
//            else
//                databasese.addAll(testInterface.findByTitle(title));
//
//            if (databasese.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(databasese, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Database> getTutorialById(@PathVariable("id") long id) {
//        Optional<Database> databaseData = testInterface.findById(id);
//
//        if (databaseData.isPresent()) {
//            System.out.println("OK");
//            System.out.println("OK");
//            System.out.println("OK");
//            return new ResponseEntity<>(databaseData.get(), HttpStatus.OK);
//        } else {
//            System.out.println("NOT_FOUND");
//            System.out.println("NOT_FOUND");
//            System.out.println("NOT_FOUND");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/salams")
//    public ResponseEntity<Database> createSalam(@RequestBody Database database) {
//        try {
//            Database _database = testInterface
//                    .save(new Database(database.getSalam()));
//
//            System.out.println("save");
//            System.out.println("save");
//            System.out.println("save");
//            return new ResponseEntity<>(_database, HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println("Exception");
//            System.out.println("Exception");
//            System.out.println("Exception");
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PutMapping()
//    public String put(Model model) {
//        return "put";
//    }
//
//    @DeleteMapping()
//    public String delete(Model model) {
//        return "delete";
//    }
}