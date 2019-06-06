package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.*;
import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FoxController {
  private UserService userService;
  private FoxService foxService;
  private FoxColorService foxColorService;
  private FoodService foodService;
  private DrinkService drinkService;

  public FoxController(UserService userService, FoxService foxService, FoxColorService foxColorService, FoodService foodService, DrinkService drinkService) {
    this.userService = userService;
    this.foxService = foxService;
    this.foxColorService = foxColorService;
    this.foodService = foodService;
    this.drinkService = drinkService;
  }

  @GetMapping("/createFox")
  public String Create(Model model) {
    model.addAttribute("foxTest", userService.getLoggedInUser().getFoxId() != null);
    model.addAttribute("userTest", true);
    model.addAttribute("colors", foxColorService.findAll());
    model.addAttribute("foods", foodService.findAll());
    model.addAttribute("drinks", drinkService.findAll());
    model.addAttribute("title", "Create a new fox!");
    return "createFox";
  }

  @PostMapping("/createFox")
  public String Create(String name, String gender, Integer drink, Integer food, Integer color) {
    Fox newFox = new Fox(name, gender, foodService.findById(food), drinkService.findById(drink), foxColorService.findById(color), userService.getLoggedInUser());
    foxService.save(newFox);
    userService.getLoggedInUser().setFoxId(newFox.getId());
    //userService.save(userService.getLoggedInUser());
    return "redirect:/info";
  }
}
