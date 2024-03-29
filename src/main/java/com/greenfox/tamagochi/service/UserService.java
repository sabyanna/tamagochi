package com.greenfox.tamagochi.service;

import com.greenfox.tamagochi.model.User;

public interface UserService {
  User getLoggedInUser();
  void logout();
  boolean validateAndLoginUser(User user);
  User createUser(String username, String password);
  void logInUser(User user);
  User findByUsername(String username);
  void save(User user);
}