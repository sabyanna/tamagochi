/*
package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.service.FoxServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActionController {

  private FoxServiceImpl foxService;

  public ActionController(FoxServiceImpl foxService) {
    this.foxService = foxService;
  }



  @GetMapping("/actions")
  public String Actions(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("foxTest", foxService.findAll().size() != 0);
    model.addAttribute("title", "Create a new fox!");
    model.addAttribute("logs", foxService.getLog());
    model.addAttribute("foxName", name);
    return "actions";
  }
}

 */


