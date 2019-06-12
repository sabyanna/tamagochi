
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private FoxService foxService;
  private UserService userService;

  public HomeController(FoxService foxService, UserService userService) {
    this.foxService = foxService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String getHome(Model model) {
    if (userService.getLoggedInUser() == null){
      model.addAttribute("userTest", false);
      return "homePage";
    }
    model.addAttribute("userTest", true);
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    //model.addAttribute("foxName", currentFox);
    model.addAttribute("title", foxService.findAll().size() != 0);
    model.addAttribute("title", "Please log in!");
    return "homePage";

  }
}


