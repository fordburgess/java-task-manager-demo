package com.example.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.taskmanager.service.*;
import com.example.taskmanager.model.Task;



@Controller
public class TaskController {
  private final TaskService taskService;

  TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public String listTasks(Model model) {
    model.addAttribute("tasks", taskService.findAll());
    return "tasks";
  }

  @GetMapping("/task/create") // must have get request to show template
  public String showTaskCreateTemplate(Model model) {
    model.addAttribute("task", new Task());
    // model.addAttribute("users", userService.findAll())
    return "task-new";
  }


  @PostMapping("/task/create")
  public String createTask(@ModelAttribute Task task) {
    taskService.createTask(task);
    return "redirect:/tasks";
  }
}
