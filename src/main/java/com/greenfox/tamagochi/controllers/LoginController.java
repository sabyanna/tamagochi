
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private FoxService foxService;

  public LoginController(FoxService foxService) {
    this.foxService = foxService;
  }


  @GetMapping("/login")
  public String LogIn(Model model, @RequestParam(required = false) Long id) {
    //model.addAttribute("foxTest", foxService.findAll().size() != 0);
    //model.addAttribute("title", "Please log in!");
    //model.addAttribute("foxName", name);
    return "redirect:/";
  }

  @PostMapping("/login")
  public String LoggedIn(Model model, Long id) {
    if (foxService.findById(id) != null) {
      //currentFox = name;
      //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      model.addAttribute("fulltext", foxService.findById(id).getFullness());
      foxService.addLog("Logged in");
      model.addAttribute("foxName", name);
      return "redirect:/info?name=" + name;

    } else {
      model.addAttribute("title", "Incorrect Fox name, please try again!");
      foxService.addLog("Fox name error during login");
      return "login";



  }
}





