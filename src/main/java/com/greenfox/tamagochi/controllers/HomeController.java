
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private FoxService foxService;

  public HomeController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String getHome(Model model) {
    model.addAttribute("foxTest", foxService.findAll().size() != 0);
    //model.addAttribute("foxName", currentFox);
    model.addAttribute("title", foxService.findAll().size() != 0);
    model.addAttribute("title", "Please log in!");
    return "login";
  }
}


