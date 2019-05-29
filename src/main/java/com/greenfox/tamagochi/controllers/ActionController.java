package com.greenfox.tamagochi.controllers;

import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.stream.events.Attribute;
import java.util.jar.Attributes;

@Controller
public class ActionController {

  private FoxService foxService;

  public ActionController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/actions")
  public String Actions(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("foxTest", foxService.getFoxes().size() != 0);
    model.addAttribute("title", "Create a new fox!");
    model.addAttribute("logs", foxService.getLog());
    model.addAttribute("foxName", name);
    return "actions";
  }
}


