package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.model.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FoxService {
  List<Fox> foxes;
  ArrayList<String> colors;
  ArrayList<String> log = new ArrayList<>();
  private String currentFox;
  //ArrayList<String> tricks;


  public FoxService() {
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("black");
    colors.add("pink");
    foxes = new ArrayList<>();
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }

  public ArrayList<String> getColors() {
    return colors;
  }

  public void setColors(ArrayList<String> colors) {
    this.colors = colors;
  }

  public ArrayList<String> getLog() {
    return log;
  }

  public void setLog(ArrayList<String> log) {
    this.log = log;
  }

  public void addLog(String logItem) {
    log.add(logItem);
  }

  public void addFox(Fox fox){
    foxes.add(fox);
  }

  public Fox getFoxByName(String name) {
    return foxes.stream()
            .filter(fox -> fox.getName().equals(name))
            .findAny()
            .orElse(null);
  }

  public boolean isThereFox(String name) {
    return getFoxByName(name) != null;
  }

  public String getCurrentFox() {
    return currentFox;
  }

  public void setCurrentFox(String currentFox) {
    this.currentFox = currentFox;
  }
}
