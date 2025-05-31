package com.example.taskmanager.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.taskmanager.service.*;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class TaskController {
  private final TaskService taskService;
  private final UserService userService;

  TaskController(TaskService taskService, UserService userService) {
    this.taskService = taskService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String redirectToTasks() {
    return "redirect:/tasks";
  }

  @GetMapping("/tasks")
  public String listTasks(Model model) {
    model.addAttribute("tasks", taskService.findAll());
    return "tasks";
  }

  @GetMapping("/task/create") // must have get request to show template
  public String showTaskCreateTemplate(Model model) {
    model.addAttribute("task", new Task());
    model.addAttribute("users", userService.findAll());
    return "task-new";
  }

  @PostMapping("/task/create")
  public String createTask(@ModelAttribute Task task) {
    taskService.createTask(task);
    return "redirect:/tasks";
  }

  @GetMapping("/task/{id}")
  public String showSpecificTask(@PathVariable Long id, Model model) {
    Task task = taskService.findById(id);
    model.addAttribute("task", task);

    User owner = task.getOwner();
    model.addAttribute("owner", owner);

    model.addAttribute("users", userService.findAll());

    return "task-show";
  }

  @PostMapping("/delete-task/{id}")
  public String deleteById(@PathVariable Long id, Model model) {
    taskService.deleteById(id);
    return "redirect:/tasks";
  }

  @PostMapping("/task/edit/{id}")
  public String editTask(@ModelAttribute Task task) {
    taskService.updateTask(task);
    return "redirect:/tasks";
  }
}
