/*
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
  public String Create(Model model, @RequestParam(required = false) long id) {
    model.addAttribute("foxTest", foxService.findAll().size() != 0);
    //model.addAttribute("foxName", currentFox);
    model.addAttribute("colors", foxService.getColors());
    model.addAttribute("title", "Create a new fox!");
    model.addAttribute("fox", new Fox());
    return "create";
  }

  @PostMapping("/create")
  public String Create(Model model, @RequestParam(required = true) long id, Fox fox) {
    if (!(foxService.findById(id)==null)) {
      //currentFox = name;
      //Fox newFox = new Fox(name, color);
      foxService.save(fox);
      //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      //model.addAttribute("fulltext", foxService.findById(id).getFullness());
      foxService.addLog("New fox created");
      //model.addAttribute("foxName", name);
      return "redirect:/info?name=" + id;
    } else {
      model.addAttribute("colors", foxService.getColors());
      model.addAttribute("title", "There is already a fox with that name, please choose a different one!");
      foxService.addLog("Creating new fox failed");
      //model.addAttribute("foxName", name);
      return "create";
    }
  }
}

 */


