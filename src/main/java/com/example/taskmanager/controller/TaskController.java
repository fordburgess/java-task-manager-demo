package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/tasks")
public class TaskController {
  @Autowired
  private TaskRepository taskRepository;

  @PostMapping("/task/create")
  public String createTask(@RequestBody String entity) {
      //TODO: process POST request

      return entity;
  }

}
