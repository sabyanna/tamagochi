/*
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.UserService;
import com.greenfox.tamagochi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

  private final UserService userService;

  public UserLoginController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String renderLoginForm(){
    return "form";
  }

  @PostMapping("/login")
  public String loginUser(User user) {
    if(userService.validateAndLoginUser(user)) {
      return "redirect:/";
    }
    userService.createUser(user.getUsername(), user.getPassword());
    return "redirect:/";
  }

  @GetMapping("/logout")
  public String logut() {
    userService.logout();
    return "redirect:/login";
  }
}

 */
