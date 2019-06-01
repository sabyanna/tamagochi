package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.DrinkService;
import com.greenfox.tamagochi.Service.FoodService;
import com.greenfox.tamagochi.Service.FoxColorService;
import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.model.Drink;
import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@Controller
public class CreateController {


  private FoxService foxService;
  private FoxColorService foxColorService;
  private DrinkService drinkService;
  private FoodService foodService;

  public CreateController(FoxService foxService, FoxColorService foxColorService, DrinkService drinkService, FoodService foodService) {
    this.foxService = foxService;
    this.foxColorService = foxColorService;
    this.drinkService = drinkService;
    this.foodService = foodService;
  }

  @GetMapping("/create")
  public String Create(Model model, @RequestParam(required = false) Long id) {
    model.addAttribute("foxTest", foxService.findAll().size() != 0);
    model.addAttribute("fox", new Fox());
    model.addAttribute("colors", foxColorService.findAll());
    model.addAttribute("foods", foodService.findAll());
    model.addAttribute("drinks", drinkService.findAll());
    model.addAttribute("title", "Create a new fox!");

    return "create";
  }

  @PostMapping("/create")
  public String Create(Model model, @RequestParam(required = true) Long id, Fox fox, Drink drink, Food food, Color color, String gender) {
    if (!(foxService.findById(id)==null)) {
      //currentFox = name;
      //Fox newFox = new Fox(name, color);
      foxService.save(fox);
      //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      //model.addAttribute("fulltext", foxService.findById(id).getFullness());
      //model.addAttribute("foxName", name);
      return "redirect:/info?name=" + id;
    } else {
      model.addAttribute("colors", foxColorService.findAll());
      model.addAttribute("title", "There is already a fox with that name, please choose a different one!");
      //model.addAttribute("foxName", name);
      return "create";
    }
  }

}






