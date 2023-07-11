package mainApplication.controllers;
import mainApplication.Database;
import mainApplication.Salams;
import mainApplication.Settings;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import org.springframework.web.servlet;

@Controller
public class MainController {

//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
////        Settings settings = context.getBean("settings", Settings.class);
//
////        settings.setMainTitle();
//
//        context.close();
//    }


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
        Database addToPostgre = new Database(salma);

        addToPostgre.run(0);

//        Salams salam = new Salams(salma);

//        model.addAttribute("title", salam.getSalam());
//        model.addAttribute("addTitle", salam.getSalam());
//        model.addAttribute("searchTitle", salam.getSalam());
        return "redirect:/main";
    }

    @PostMapping("/main/searchSalam")
    public String searchSalam(@RequestParam String salma, Model model) {
        Database searchInPostgre = new Database(salma);

        searchInPostgre.run(1);

//        Salams salam = new Salams(salma);

//        model.addAttribute("title", salam.getSalam());
//        model.addAttribute("addTitle", salam.getSalam());
//        model.addAttribute("searchTitle", salam.getSalam());
        return "redirect:/main";
    }



//
//    @PostMapping("/addToPostgre")
//    public String submitForm(@ModelAttribute("salam") Salams salam) {
//
//        System.out.println(salam);
//
//        return "salamFormCompleate";
//    }

//    @RequestMapping(value = "/salam", method = RequestMethod.GET)
//    public ModelAndView showForm() {
//        return new ModelAndView("employeeHome", "employee", new Salams());
//    }
//
//    @RequestMapping(value = "/addSalam", method = RequestMethod.POST)
//    public String submit(@Valid @ModelAttribute("salam")Salams salam,
//                         BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//
//        model.addAttribute("salam", salam.getSalam());
////        model.addAttribute("contactNumber", salam.getContactNumber());
////        model.addAttribute("id", salam.getId());
//        return "main";
//    }
//


//
//    @GetMapping(path = "/")
//    public String getFeedbackForm(Model model) {
//        Salams salam = new Salams();
//        model.addAttribute("salam", salam);
//        return "main";
//    }
//
//    @PostMapping(
//            path = "/",
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//        public String handleBrowserSubmissions(Salams salam) throws Exception {
//
////        salam.setSalam();
//
//
//        return "redirect:/done";
//    }
//
//    @GetMapping("/done")
//    public ResponseEntity<String> getSuccess() {
//        return new ResponseEntity<String>("You submitting salam.", HttpStatus.OK);
//    }





//    @GetMapping
//    public String showForm(Model model) {
//        Salams salam = new Salams();
//
//        model.addAttribute("salam", salam);
//
//        return "salamForm";
//    }
}
