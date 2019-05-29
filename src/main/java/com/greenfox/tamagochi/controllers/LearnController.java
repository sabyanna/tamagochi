package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearnController {

  private FoxServiceImpl foxService;

  public LearnController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/learn")
  public String Learn(@RequestParam(required = false) String name, Model model) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("foxName", name);
    model.addAttribute("tricks", foxService.getFoxByName(name).getPossibleTricks());
    //model.addAttribute("title", "Learn a new trick!");
    model.addAttribute("trickTest", foxService.getFoxByName(name).getPossibleTricks().size() != 0);
    return "learn";
  }

  @PostMapping("/learn")
  public String Learn(String name, Model model, String trick) {
    foxService.getFoxByName(name).addToTricks(trick);
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("trickText", "Known tricks");
    model.addAttribute("text", foxService.describe(foxService.getFoxByName(name)));
    //model.addAttribute("text", foxService.getFoxByName(name).describe());
    model.addAttribute("tricks", foxService.getFoxByName(name).getTricks());
    model.addAttribute("fulltext", foxService.getFoxByName(name).getFullness());
    foxService.addLog("Trick learned");
    model.addAttribute("foxName", name);
    return "redirect:/info?name=" + name;
  }
}


