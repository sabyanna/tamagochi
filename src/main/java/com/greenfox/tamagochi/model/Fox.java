package com.greenfox.tamagochi.model;

import java.util.ArrayList;
import java.util.List;

public class Fox {
  private String name;
  private String gender;
  private List<String> tricks;
  private String eats;
  private String drinks;
  private String color;
  private List<String> possibleTricks;
  private List<String> possibleEats;
  private List<String> possibleDrinks;
  private int fullness;
  private boolean isAlive;


  public Fox(String name, String gender, String color) {
    tricks = new ArrayList<>();
    possibleTricks = new ArrayList<>();
    possibleEats = new ArrayList<>();
    possibleDrinks = new ArrayList<>();
    possibleTricks.add("play");
    possibleTricks.add("inject dependencies");
    possibleTricks.add("paint");
    possibleTricks.add("snore");
    possibleTricks.add("handstand");
    possibleTricks.add("cook");
    possibleTricks.add("sleep");
    possibleEats.add("dry bread");
    possibleEats.add("watermelon");
    possibleEats.add("cake");
    possibleEats.add("pizza");
    possibleDrinks.add("water");
    possibleDrinks.add("lemonade");
    possibleDrinks.add("wine");
    possibleDrinks.add("milkshake");
    this.name = name;
    this.gender = gender;
    //this.eats = eats;
    eats = "dry bread";
    drinks = "water";
    //this.drinks = drinks;
    this.color = color;
    fullness = 10;
    isAlive = true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTricks() {
    return tricks;
  }

  public void setTricks(List<String> tricks) {
    tricks = tricks;
  }

  public void addToTricks(String trick) {
    tricks.add(trick);
    possibleTricks.remove(trick);
    fullness -= 3;
    if (fullness <= 0) {
      isAlive = false;
    }
  }

  public String getEats() {
    return eats;
  }

  public void setEats(String newEats) {
    possibleEats.remove(newEats);
    List<String> outputList = new ArrayList<>();
    outputList.add(newEats);
    possibleEats.stream()
            .forEach(x -> outputList.add(x.toString()));
    possibleEats = outputList;
    eats = newEats;
  }

  public String getDrinks() {
    return drinks;
  }

  public void setDrinks(String newDrinks) {
    possibleDrinks.remove(newDrinks);
    List<String> outputList = new ArrayList<>();
    outputList.add(newDrinks);
    possibleDrinks.stream()
            .forEach(x -> outputList.add(x.toString()));
    possibleDrinks = outputList;
    drinks = newDrinks;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String describe() {
    if (tricks.size() == 0) {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows no tricks yet.";
    } else {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows " + tricks.size() + " tricks.";
    }
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void learnTrick(String trick) {
    tricks.add(trick);
  }

  public boolean isThereTrick(String name) {
    return tricks.contains(name);
  }

  public List<String> getPossibleTricks() {
    return possibleTricks;
  }

  public void setPossibleTricks(List<String> possibleTricks) {
    this.possibleTricks = possibleTricks;
  }

  public List<String> getPossibleEats() {
    return possibleEats;
  }

  public void setPossibleEats(List<String> possibleEats) {
    this.possibleEats = possibleEats;
  }

  public List<String> getPossibleDrinks() {
    return possibleDrinks;
  }

  public void setPossibleDrinks(List<String> possibleDrinks) {
    this.possibleDrinks = possibleDrinks;
  }

  public int getFullness() {
    return fullness;
  }

  public void setFullness(int fullness) {
    this.fullness = fullness;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public void feed() {
    fullness = 10;
  }
}
