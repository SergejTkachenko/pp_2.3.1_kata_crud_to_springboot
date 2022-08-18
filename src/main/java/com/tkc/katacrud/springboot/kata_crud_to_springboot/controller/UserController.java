package com.tkc.katacrud.springboot.kata_crud_to_springboot.controller;

import com.tkc.katacrud.springboot.kata_crud_to_springboot.entity.User;
import com.tkc.katacrud.springboot.kata_crud_to_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main-view");
        modelAndView.addObject("userList", users);

        return modelAndView;
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addNewUser-view";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping( "/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "updateUser-view";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);

        return "redirect:/";
    }
}