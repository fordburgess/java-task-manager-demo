package com.example.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {

  @GetMapping("/about")
  public String getAboutPage() {
    return "about";
  }
}
