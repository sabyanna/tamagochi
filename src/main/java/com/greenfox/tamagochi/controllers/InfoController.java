
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {

  private FoxService foxService;

  public InfoController(FoxService foxService) {
    this.foxService = foxService;
  }


  @GetMapping("/info")
  public String Info(@RequestParam long id, Model model) {
    model.addAttribute("foxTest", foxService.findAll().size() != 0);
    model.addAttribute("fox", foxService.findById(id));
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
}




