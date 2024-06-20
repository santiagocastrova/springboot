package com.crud.santiago.controllers;

import com.crud.santiago.entities.User;
import com.crud.santiago.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/users"})
    public String listOrGreeting(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "crud";
    }

    @GetMapping("users/search")
    public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
        List<User> users = userService.searchUsers(keyword);
        model.addAttribute("users", users);
        return "crud";
    }

    @GetMapping("users/register")
    public String showRegisterForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "hello";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){
        userService.createUser(user);
        model.addAttribute("message", "User registered succesfully");
        return "redirect:/users";
    }

    @GetMapping("users/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "EditUser";
    }

    @PostMapping("users/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

