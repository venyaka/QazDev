package mainApplication.controllers;//package mainApplication.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import mainApplication.Settings;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import mainApplication.Database;
//import mainApplication.Salams;
//import mainApplication.Settings;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Optional;
//
//
////@RestController
////@RequestMapping("/main")
////public class MainController {
////
////    @GetMapping
////    public ModelAndView main(Model model) {
////        ClassPathXmlApplicationContext context =
////                new ClassPathXmlApplicationContext("applicationContext.xml");
////
////        Settings settings = context.getBean("settings", Settings.class);
////
////        model.addAttribute("title", settings.getMainTitle());
////        model.addAttribute("userTitle1", settings.getUserTitle1());
////        model.addAttribute("userTitle2", settings.getUserTitle2());
////        context.close();
////
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("main.html");
////        return modelAndView;
////    }
////
////    @GetMapping("/{user}")
////    public ModelAndView user1(Model model) {
////
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("venyaka.html");
////        return modelAndView;
////    }
////
////    @GetMapping("/add-salam/{user}")
////    public ModelAndView add(@PathVariable(value = "user") String user, Model model) {
////        ArrayList<>
////
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("main.html");
////        return modelAndView;
////    }
////}
//
//
//
//
//
//@Controller
//public class MainController {
//
//    @GetMapping("/main")
//    public String main(Model model) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Settings settings = context.getBean("settings", Settings.class);
//
//        model.addAttribute("title", settings.getMainTitle());
//        model.addAttribute("userTitle1", settings.getUserTitle1());
//        model.addAttribute("userTitle2", settings.getUserTitle2());
//        context.close();
//        return "main";
//    }
//
//
//    @GetMapping("/main/addSalam")
//    public String addSalam(Model model) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Settings settings = context.getBean("settings", Settings.class);
//
//        model.addAttribute("addTitle", settings.getAddTitle());
//        context.close();
//
//        return "add-salam";
//    }
//
//    @GetMapping("/main/searchSalam")
//    public String searchSalam(Model model) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Settings settings = context.getBean("settings", Settings.class);
//
//        model.addAttribute("searchTitle", settings.getSearchTitle());
//        context.close();
//
//        return "search-salam";
//    }
//
//    @PostMapping("/main/addSalam")
//    public String postSalam(@RequestParam String salma, Model model) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        Settings settings = context.getBean("settings", Settings.class);
//
////        Database addToPostgre = new Database();
//
//        File file = new File(settings.getDirectoryPath() + "salam.txt");
//
//        try(FileWriter writer = new FileWriter(settings.getDirectoryPath() + "salam.txt", false))
//        {
//            if(file.createNewFile())
//                System.out.println("File has been created");
//
//            writer.write(salma);
//
//            writer.flush();
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }
//
//
////        addToPostgre.run(salma, file);
//
//        return "redirect:/main";
//    }
//
//    @PostMapping("/main/searchSalam")
//    public String searchSalam(@RequestParam String salma, Model model) {
////        ClassPathXmlApplicationContext context =
////                new ClassPathXmlApplicationContext("applicationContext.xml");
////
////        Settings settings = context.getBean("settings", Settings.class);
//
////        Database searchInPostgre = new Database();
//
////        File file = new File(settings.getDirectoryPath() + "salam.txt");
//
////        searchInPostgre.run(salma);
//
//        return "redirect:/main";
//    }
//}