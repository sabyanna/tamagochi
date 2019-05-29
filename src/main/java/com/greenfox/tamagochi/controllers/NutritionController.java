package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NutritionController {

  private FoxServiceImpl foxService;

  public NutritionController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/nutrition")
  public String Nutrition(@RequestParam(required = false) String name, Model model) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("foxName", name);
    model.addAttribute("currentDrink", foxService.getFoxByName(name).getDrinks());
    model.addAttribute("foods", foxService.getFoxByName(name).getPossibleEats());
    model.addAttribute("drinks", foxService.getFoxByName(name).getPossibleDrinks());
    model.addAttribute("foodTitle", "What to eat?");
    model.addAttribute("drinkTitle", "What to drink?");
    return "nutrition";
  }

  @PostMapping("/nutrition")
  public String Nutrition(String name, Model model, String food, String drink) {
    foxService.getFoxByName(name).setEats(food);
    foxService.getFoxByName(name).setDrinks(drink);
    foxService.getFoxByName(name).feed();
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("foxName", name);
    model.addAttribute("text", foxService.getFoxByName(name).describe());
    model.addAttribute("trickText", "Known tricks");
    model.addAttribute("tricks", foxService.getFoxByName(name).getTricks());
    model.addAttribute("fulltext", foxService.getFoxByName(name).getFullness());
    //model.addAttribute("name", foxService.getFoxByName(currentFox).getFullness());
    foxService.addLog("Fox fed");
    return "redirect:/info?name=" + name;
  }
}


