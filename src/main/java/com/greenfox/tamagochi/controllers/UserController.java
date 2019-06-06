package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.UserService;
import com.greenfox.tamagochi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/createAccount")
  public String userCreater(Model model) {
    if (userService.getLoggedInUser() == null){
      model.addAttribute("userTest", false);
      return "createAccount";
    }
    model.addAttribute("userTest", true);
    model.addAttribute("userFoxTest", userService.getLoggedInUser().getFoxes().size() != 0);
    model.addAttribute("foxTest", userService.getLoggedInUser().getFoxId() != null);
    return "createAccount";
  }

  @PostMapping("/createAccount")
  public String Create(User user) {
    userService.createUser(user.getUsername(), user.getPassword());
    return "redirect:/userMainPage";
  }

  @GetMapping("/userMainPage")
  public String userMainPageLoader(Model model) {
    model.addAttribute("userTest", true);
    model.addAttribute("user", userService.getLoggedInUser());
    model.addAttribute("userFoxTest", userService.getLoggedInUser().getFoxes().size() == 0);
    model.addAttribute("userFoxes", userService.getLoggedInUser().getFoxes());
    model.addAttribute("foxTest", userService.getLoggedInUser().getFoxId() != null);
    return "userMainPage";
  }

}
