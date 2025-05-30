package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }
}
