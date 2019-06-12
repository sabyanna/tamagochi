
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.service.FoxService;
import com.greenfox.tamagochi.service.UserService;
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


}


