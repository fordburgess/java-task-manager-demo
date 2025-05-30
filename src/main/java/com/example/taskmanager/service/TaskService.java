package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import java.util.List;


public interface TaskService {
  void createTask(Task task);

  List<Task> findAll();
}
