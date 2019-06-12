package com.greenfox.tamagochi.service;

import com.greenfox.tamagochi.model.User;
import com.greenfox.tamagochi.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService {

  private final HttpSession session;
  private static final String sessionKey ="user";
  private final PasswordEncoder passwordEncoder;
  private final IUserRepository userRepository;

  public UserServiceImp(HttpSession session, PasswordEncoder passwordEncoder, IUserRepository userRepository) {
    this.session = session;
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @Override
  public User getLoggedInUser() {
    return (User) session.getAttribute(sessionKey);
  }

  @Override
  public void logout() {
    session.setAttribute(sessionKey, null);
  }

  @Override
  public boolean validateAndLoginUser(User user) {
    User userFromDb = userRepository.findByUsername(user.getUsername());
    if(userFromDb == null) return false;
    if(passwordEncoder.matches(user.getPassword(), userFromDb.getPasswordHash())) {
      logInUser(user);
      return true;
    }

    return false;
  }

  @Override
  public User createUser(String username, String password) {
    User newUser = new User(username, password);
    newUser.setPasswordHash(passwordEncoder.encode(password));
    userRepository.save(newUser);

    User userFromDb = userRepository.findByUsername(newUser.getUsername());
    logInUser(userFromDb);
    return userFromDb;
  }

  @Override
  public void logInUser(User user) {
    User userFromDb = userRepository.findByUsername(user.getUsername());
    session.setAttribute(sessionKey, userFromDb);
  }

  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }


}