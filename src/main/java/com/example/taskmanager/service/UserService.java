package com.example.taskmanager.service;

import com.example.taskmanager.model.User;
import java.util.List;


public interface UserService {
  void createUser(User user);

  List<User> findAll();
}
