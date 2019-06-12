package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.*;
import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.model.Fox;
import com.greenfox.tamagochi.model.User;
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
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    model.addAttribute("userTest", true);
    model.addAttribute("colors", foxColorService.findAll());
    model.addAttribute("foods", foodService.findAll());
    model.addAttribute("drinks", drinkService.findAll());
    model.addAttribute("title", "Create a new fox!");
    return "createFox";
  }

  @PostMapping("/createFox")
  public String Create(Model model, String name, String gender, Integer drink, Integer food, Integer color) {
    User user = userService.getLoggedInUser();
    foxService.save(new Fox(name, gender, foodService.findById(food), drinkService.findById(drink), foxColorService.findById(color)));

    foxService.findFoxByName(name).setUser(user);
    foxService.save(foxService.findFoxByName(name));
    user.setCurrentFox(foxService.findFoxByName(name).getId());
    user.addFox(foxService.findFoxByName(name));

    userService.save(user);
    model.addAttribute("fox", foxService.findFoxByName(name));
    model.addAttribute("foxTest", true);
    model.addAttribute("userTest", true);
    return "info";
  }
}
