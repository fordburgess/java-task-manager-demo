package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
  private TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void createTask(Task task) {
    taskRepository.save(task);
  }

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }
}
