package com.example.taskmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.example.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.taskmanager.service.*;
import com.example.taskmanager.model.Task;



@Controller
public class TaskController {
  private final TaskService taskService;

  @Autowired
  TaskController(TaskService taskService) {
      this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public String listTasks(Model model) {
    model.addAttribute("tasks", taskService.findAll());
    return "tasks";
  }

  @PostMapping("/tasks/create")
  public String createTask(@ModelAttribute Task task) {
    taskService.createTask(task);
    return "test";
  }
}
