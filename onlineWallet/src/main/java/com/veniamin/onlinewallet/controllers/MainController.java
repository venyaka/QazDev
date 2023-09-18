//package com.veniamin.onlinewallet.controllers;
//
//import com.veniamin.onlinewallet.entity.User;
//import com.veniamin.onlinewallet.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//public class MainController {
//
//    private final UserService userService;
//
//    @GetMapping("/users")
//    public List<User> findAllUsers() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//}
