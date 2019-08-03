package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.service.*;
import com.greenfox.tamagochi.model.Fox;
import com.greenfox.tamagochi.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoxController {
  private UserService userService;
  private FoxService foxService;
  private FoxColorService foxColorService;
  private FoodService foodService;
  private DrinkService drinkService;
  private TrickService trickService;


  public FoxController(UserService userService, FoxService foxService, FoxColorService foxColorService, FoodService foodService, DrinkService drinkService, TrickService trickService) {
    this.userService = userService;
    this.foxService = foxService;
    this.foxColorService = foxColorService;
    this.foodService = foodService;
    this.drinkService = drinkService;
    this.trickService = trickService;
  }

  @GetMapping("/createFox")
  public String Create(Model model) {
    model.addAttribute("foxTest", userService.getLoggedInUser().getCurrentFox() != null);
    model.addAttribute("userTest", true);
    model.addAttribute("colors", foxColorService.findAll());
    model.addAttribute("foods", foodService.findAll());
    model.addAttribute("drinks", drinkService.findAll());
    model.addAttribute("title", "Create a new fox!");
    model.addAttribute("user", userService.getLoggedInUser());
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
    //model.addAttribute("fox", foxService.findFoxByName(name));
    //model.addAttribute("foxTest", true);
    //model.addAttribute("userTest", true);
    //model.addAttribute("user", userService.getLoggedInUser());
    return "redirect:/info";
  }

  @GetMapping("/info")
  public String foxInfo(Model model) {
    model.addAttribute("fox", foxService.findById(userService.getLoggedInUser().getCurrentFox()));
    model.addAttribute("user", userService.getLoggedInUser());
    model.addAttribute("userTest", true);
    return "info";
  }

  @PostMapping("/chooseFox")
  public String chooseFox(long foxId, Model model) {
    userService.getLoggedInUser().setCurrentFox(foxId);
    //model.addAttribute("fox", foxService.findById(foxId));
    //model.addAttribute("foxTest", true);
    //model.addAttribute("userTest", true);
    return "redirect:/info";
  }

  @PostMapping("/newFox")
  public String newFox() {
    return "redirect:/createFox";
  }

  @GetMapping("/nutrition")
  public String nutritionPage(Model model) {
    model.addAttribute("fox", foxService.findById(userService.getLoggedInUser().getCurrentFox()));
    model.addAttribute("user", userService.getLoggedInUser());
    model.addAttribute("foods", foodService.findAll());
    model.addAttribute("drinks", drinkService.findAll());
    model.addAttribute("userTest", true);
    return "nutrition";
  }

  @PostMapping("/nutrition")
  public String setNutrition(long food, long drink) {
    foxService.findById(userService.getLoggedInUser().getCurrentFox()).setFood(foodService.findById(food));
    foxService.findById(userService.getLoggedInUser().getCurrentFox()).setDrink(drinkService.findById(drink));
    return "redirect:/info";
  }

  @GetMapping("/learn")
  public String learnPage(Model model) {
    model.addAttribute("fox", foxService.findById(userService.getLoggedInUser().getCurrentFox()));
    model.addAttribute("user", userService.getLoggedInUser());
    model.addAttribute("tricks", trickService.findAll());
    model.addAttribute("userTest", true);
    model.addAttribute("trickTest",  foxService.findById(userService.getLoggedInUser().getCurrentFox()).getTricks().size() != trickService.findAll().size());
    return "learn";
  }

}
