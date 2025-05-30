package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskServiceImpl implements TaskService {
  private TaskRepository taskRepository;

  @Autowired
  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void createTask(Task task) {
    taskRepository.save(task);
  }
}
