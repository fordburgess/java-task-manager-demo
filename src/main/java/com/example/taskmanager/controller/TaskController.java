package com.example.taskmanager.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;

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
    List<Task> tasks = taskService.findAll();
    Collections.sort(tasks);
    model.addAttribute("tasks", tasks);
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
  public String editTask(@ModelAttribute Task task, @PathVariable("id") Long id) {
    taskService.updateTask(task, id);
    return "redirect:/tasks";
  }
}
