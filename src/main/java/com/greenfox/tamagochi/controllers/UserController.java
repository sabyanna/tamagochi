package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.service.FoxService;
import com.greenfox.tamagochi.service.UserService;
import com.greenfox.tamagochi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  private UserService userService;
  private FoxService foxService;

  public UserController(UserService userService, FoxService foxService) {
    this.userService = userService;
    this.foxService = foxService;
  }

  @GetMapping("/createAccount")
  public String userCreater(Model model) {
    if (userService.getLoggedInUser() == null) {
      model.addAttribute("userTest", false);
      return "createAccount";
    }
    model.addAttribute("userTest", true);
    model.addAttribute("userFoxTest", userService.getLoggedInUser().getFoxList().size() != 0);
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    return "createAccount";
  }

  @PostMapping("/createAccount")
  public String Create(User user) {
    userService.createUser(user.getUsername(), user.getPassword());
    return "redirect:/userMainPage";
  }

  @GetMapping("/")
  public String getHomeAndLogin(Model model) {
    if (userService.getLoggedInUser() == null) {
      model.addAttribute("userTest", false);
      return "homePage";
    }
    model.addAttribute("userTest", true);
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    //model.addAttribute("foxName", currentFox);
    //model.addAttribute("title", foxService.findAll().size() != 0);
    //model.addAttribute("title", "Please log in!");
    return "homePage";
  }

  @PostMapping("/login")
  public String loginUser(User user, Model model) {
    if (userService.validateAndLoginUser(user)) {
      return "redirect:/userMainPage";
    }
    model.addAttribute("message", "Incorrect username or password");
    if (userService.getLoggedInUser() == null) {
      model.addAttribute("userTest", false);
      return "homePage";
    }
    model.addAttribute("userTest", true);
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    return "homePage";
  }

  @GetMapping("/userMainPage")
  public String userMainPageLoader(Model model) {
    model.addAttribute("userTest", true);
    model.addAttribute("user", userService.getLoggedInUser());
    model.addAttribute("userFoxTest", userService.getLoggedInUser().getFoxList().size() != 0);
    model.addAttribute("userFoxes", userService.getLoggedInUser().getFoxList());
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    return "userMainPage";
  }

  @GetMapping("/logout")
  public String logout() {
    userService.logout();
    return "redirect:/";
  }

}
