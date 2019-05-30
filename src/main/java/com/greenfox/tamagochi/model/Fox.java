package com.greenfox.tamagochi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String gender;
  private String color;
  private int fullness;
  private boolean isAlive;
  //private Food eats;
  //private Drink drinks;

  public Fox() {}

  public Fox(String name, String gender, String color) {
    this.name = name;
    this.gender = gender;
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

  /*
  public List<String> getTricks() {
    return tricks;
  }

   */

  public void setTricks(List<String> tricks) {
    tricks = tricks;
  }
  /*

  public void addToTricks(String trick) {
    tricks.add(trick);
    possibleTricks.remove(trick);
    fullness -= 3;
    if (fullness <= 0) {
      isAlive = false;
    }
  }

   */

  /*

  public String getEats() {
    return eats;
  }

   */

/*
  public void setEats(String newEats) {
    possibleEats.remove(newEats);
    List<String> outputList = new ArrayList<>();
    outputList.add(newEats);
    possibleEats.stream()
            .forEach(x -> outputList.add(x.toString()));
    possibleEats = outputList;
    eats = newEats;
  }

 */

/*

  public String getDrinks() {
    return drinks;
  }

 */

/*

  public void setDrinks(String newDrinks) {
    possibleDrinks.remove(newDrinks);
    List<String> outputList = new ArrayList<>();
    outputList.add(newDrinks);
    possibleDrinks.stream()
            .forEach(x -> outputList.add(x.toString()));
    possibleDrinks = outputList;
    drinks = newDrinks;
  }

 */

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  /*

  public String describe() {
    if (tricks.size() == 0) {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows no tricks yet.";
    } else {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows " + tricks.size() + " tricks.";
    }
  }

   */

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  /*

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

   */

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

/*
  public void feed() {
    fullness = 10;
  }

 */


}
