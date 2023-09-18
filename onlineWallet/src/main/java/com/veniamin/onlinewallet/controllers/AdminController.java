//package com.veniamin.onlinewallet.controllers;
//
//import com.veniamin.onlinewallet.entity.User;
//import com.veniamin.onlinewallet.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/admin")
//public class AdminController {
//
//    private final UserService userService;
//
//    @GetMapping("/users")
//    public List<User> findAllUsers() {
//        return userService.findAll();
//    }
//}
