package com.example.taskmanager.repository;

import java.time.LocalDateTime;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
  List<Task> findByOwnerId(User owner);
}
