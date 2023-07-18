package mainApplication.controllers;
import mainApplication.Database;
import mainApplication.Salams;
import mainApplication.Settings;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Settings settings = context.getBean("settings", Settings.class);

        model.addAttribute("title", settings.getMainTitle());
        model.addAttribute("addTitle", settings.getAddTitle());
        model.addAttribute("searchTitle", settings.getSearchTitle());
        context.close();
        return "main";
    }

    @GetMapping("/main/addSalam")
    public String addSalam(Model model) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Settings settings = context.getBean("settings", Settings.class);

        model.addAttribute("addTitle", settings.getAddTitle());
        context.close();

        return "add-salam";
    }

    @GetMapping("/main/searchSalam")
    public String searchSalam(Model model) {
        return "search-salam";
    }

    @PostMapping("/main/addSalam")
    public String postSalam(@RequestParam String salma, Model model) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Settings settings = context.getBean("settings", Settings.class);

        Database addToPostgre = new Database();

        File file = new File(settings.getDirectoryPath() + "salam.txt");

        try(FileWriter writer = new FileWriter(settings.getDirectoryPath() + "salam.txt", false))
        {
            if(file.createNewFile())
                System.out.println("File has been created");

            writer.write(salma);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


        addToPostgre.run(salma, file);

        return "redirect:/main";
    }

    @PostMapping("/main/searchSalam")
    public String searchSalam(@RequestParam String salma, Model model) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Settings settings = context.getBean("settings", Settings.class);

        Database searchInPostgre = new Database();

//        File file = new File(settings.getDirectoryPath() + "salam.txt");

        searchInPostgre.run(salma);

        return "redirect:/main";
    }
}