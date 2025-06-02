package com.example.taskmanager.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
  private TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void createTask(Task task) {
    task.setDateCreated(LocalDate.now());
    taskRepository.save(task);
  }

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  @Override
  public Task findById(Long id) {
    return taskRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Long id) {
    taskRepository.deleteById(id);
  }

  @Override
  public Task updateTask(Task task, Long id) {
    Task taskDB = taskRepository.findById(id).get();

    if (Objects.nonNull(taskDB)) {
      taskDB.setTitle(task.getTitle());
      taskDB.setDescription(task.getDescription());
      taskDB.setOwner(task.getOwner());
      taskDB.setDueDate(task.getDueDate());
      taskDB.setIsCompleted(task.getIsCompleted());
    }

    return taskRepository.save(taskDB);
  }
}
