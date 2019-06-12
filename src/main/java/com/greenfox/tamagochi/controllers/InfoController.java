
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.service.FoxService;
import com.greenfox.tamagochi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

  private FoxService foxService;
  private UserService userService;

  public InfoController(FoxService foxService, UserService userService) {
    this.foxService = foxService;
    this.userService = userService;

  }

  /*

  @GetMapping("/info")
  public String Info(Model model) {
    model.addAttribute("fox", foxService.findById(userService.getLoggedInUser().getCurrentFox()));
    model.addAttribute("foxTest", true);
    model.addAttribute("userTest", true);

    //model.addAttribute("foxName", name);
    //model.addAttribute("color", "/" + foxService.findById(id).getColor() + ".png");
    //model.addAttribute("colordead", "/" + foxService.findById(id).getColor() + "-dead.png");
    //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
    //model.addAttribute("text", foxService.getFoxByName(name).describe());
    //model.addAttribute("trickText", foxService.getFoxByName(name).getTricks().size() == 0);
    //model.addAttribute("tricks", foxService.getFoxByName(name).getTricks());
    //model.addAttribute("fulltext", foxService.findById(id).getFullness());
    //model.addAttribute("isalive", foxService.findById(id).isAlive());
    return "info";
  }

   */
}




