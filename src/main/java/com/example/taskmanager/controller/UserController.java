package com.example.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.taskmanager.service.*;
import com.example.taskmanager.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String listUsers(Model model) {
    model.addAttribute("users", userService.findAll());
    return "users";
  }

  @GetMapping("/user/create")
  public String showUserCreateTemplate(Model model) {
    model.addAttribute("user", new User());
    return "user-new";
  }

  @PostMapping("/user/create")
  public String createUser(@ModelAttribute User user) {
    userService.createUser(user);
    return "redirect:/users";
  }
}
