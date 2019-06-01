
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.repository.IFoxRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private FoxService foxService;
  private IFoxRepository foxRepository;

  public LoginController(FoxService foxService, IFoxRepository foxRepository) {
    this.foxService = foxService;
    this.foxRepository = foxRepository;
  }


  @GetMapping("/login")
  public String LogIn(Model model, @RequestParam(required = false) Long id) {
    //model.addAttribute("foxTest", foxService.findAll().size() != 0);
    model.addAttribute("title", "Please log in!");
    //model.addAttribute("foxName", name);
    return "redirect:/";
  }

  @PostMapping("/login")
  public String LoggedIn(Model model, String name) {
    if (foxRepository.findFoxByName(name) != null) {
      Long id = foxRepository.findFoxByName(name).getId();
      //currentFox = name;
      //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
      //model.addAttribute("text", foxService.getFoxByName(name).describe());
      //model.addAttribute("fulltext", foxService.findById(id).getFullness());
      model.addAttribute("foxName", name);
      return "redirect:/info?name=" + id;

    } else {
      model.addAttribute("title", "Incorrect Fox name, please try again!");
      return "/login";
    }
  }
}





