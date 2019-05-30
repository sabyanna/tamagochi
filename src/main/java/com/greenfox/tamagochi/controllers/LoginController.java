package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private FoxServiceImpl foxService;

  public LoginController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/login")
  public String LogIn(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("title", "Please log in!");
    model.addAttribute("foxName", name);
    return "login";
  }

  @PostMapping("/login")
  public String LoggedIn(Model model, String name) {
    if (foxService.isThereFox(name)) {
      //currentFox = name;
      //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      model.addAttribute("fulltext", foxService.getFoxByName(name).getFullness());
      foxService.addLog("Logged in");
      model.addAttribute("foxName", name);
      return "redirect:/info?name=" + name;

    } else {
      model.addAttribute("title", "Incorrect Fox name, please try again!");
      foxService.addLog("Fox name error during login");
      return "login";
    }
  }
}


