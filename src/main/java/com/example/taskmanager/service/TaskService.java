package com.example.taskmanager.service;

import java.util.List;

import com.example.taskmanager.model.Task;


public interface TaskService {
  void createTask(Task task);

  List<Task> findAll();

  Task findById(Long id);

  void deleteById(Long id);

  Task updateTask(Task task, Long id);
}
