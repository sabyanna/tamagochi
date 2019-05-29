package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.stream.events.Attribute;
import java.util.jar.Attributes;

@Controller
public class HomeController {

  private FoxService foxService;

  public HomeController(FoxService foxService) {
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


