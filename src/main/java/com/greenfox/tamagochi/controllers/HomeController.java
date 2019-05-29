package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private FoxServiceImpl foxService;

  public HomeController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String Colored(Model model) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    //model.addAttribute("foxName", currentFox);
    model.addAttribute("title", foxService.getFoxes().size() == 0);
    model.addAttribute("title", "Please log in!");
    return "login";
  }
}


