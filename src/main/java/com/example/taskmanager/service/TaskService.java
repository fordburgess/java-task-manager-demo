package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import java.util.List;


public interface TaskService {
  void createTask(Task task);

  List<Task> findAll();

  Task findById(Long id);
}
