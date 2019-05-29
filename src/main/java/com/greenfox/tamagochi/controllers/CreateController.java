package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateController {

  private FoxServiceImpl foxService;

  public CreateController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/create")
  public String Create(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    //model.addAttribute("foxName", currentFox);
    model.addAttribute("colors", foxService.getColors());
    model.addAttribute("title", "Create a new fox!");
    model.addAttribute("foxName", name);
    return "create";
  }

  @PostMapping("/create")
  public String Create(Model model, String name, String color, String gender) {
    if (!foxService.isThereFox(name)) {
      //currentFox = name;
      Fox newFox = new Fox(name, gender, color);
      foxService.addFox(newFox);
      model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      model.addAttribute("fulltext", foxService.getFoxByName(name).getFullness());
      foxService.addLog("New fox created");
      //model.addAttribute("foxName", name);
      return "redirect:/info?name=" + name;
    } else {
      model.addAttribute("colors", foxService.getColors());
      model.addAttribute("title", "There is already a fox with that name, please choose a different one!");
      foxService.addLog("Creating new fox failed");
      model.addAttribute("foxName", name);
      return "create";
    }
  }
}


