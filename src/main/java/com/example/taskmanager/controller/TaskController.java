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
import org.springframework.web.bind.annotation.RequestParam;
import com.example.taskmanager.service.*;
import com.example.taskmanager.model.Task;



@Controller
@RequestMapping("/tasks")
public class TaskController {
  @Autowired
  private TaskRepository taskRepository;

  @GetMapping("/tasks")
  public String listTasks(Model model) {
      model.addAttribute("tasks", taskRepository.findAll());
      return "tasks";
  }

  private void prepareTasksListModel(Model model, Principal principal) {

  }

  @PostMapping("/tasks/create")
  public String createTask(Task task) {
    taskService.create(task);
    return "test";
  }

}
