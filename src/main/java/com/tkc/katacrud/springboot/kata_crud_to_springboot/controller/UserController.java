package com.tkc.katacrud.springboot.kata_crud_to_springboot.controller;

import com.tkc.katacrud.springboot.kata_crud_to_springboot.entity.User;
import com.tkc.katacrud.springboot.kata_crud_to_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("userList", users);

        return "main";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @PutMapping( "/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "updateUser";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);

        return "redirect:/";
    }
}