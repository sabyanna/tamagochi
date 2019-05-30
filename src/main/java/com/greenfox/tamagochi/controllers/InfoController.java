package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {

  private FoxServiceImpl foxService;

  public InfoController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/info")
  public String Info(@RequestParam String name, Model model) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("foxName", name);
    model.addAttribute("color", "/" + foxService.getFoxByName(name).getColor() + ".png");
    model.addAttribute("colordead", "/" + foxService.getFoxByName(name).getColor() + "-dead.png");
    //model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
    //model.addAttribute("text", foxService.getFoxByName(name).describe());
    //model.addAttribute("trickText", foxService.getFoxByName(name).getTricks().size() == 0);
    //model.addAttribute("tricks", foxService.getFoxByName(name).getTricks());
    model.addAttribute("fulltext", foxService.getFoxByName(name).getFullness());
    model.addAttribute("isalive", foxService.getFoxByName(name).isAlive());
    return "info";
  }
}


