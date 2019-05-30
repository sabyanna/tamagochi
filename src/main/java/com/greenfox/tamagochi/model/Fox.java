package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Foxes")
@Getter
@Setter
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String gender;
  private String color;
  private int fullness;
  private boolean isAlive;
  @ManyToOne
  private Food food;
  @ManyToOne
  private Drink drink;
  @ManyToMany (fetch = FetchType.LAZY)
  private List<Trick> tricks;

  //private Food eats;
  //private Drink drinks;

  public Fox() {}

  public Fox(String name, String color) {
    this.name = name;
    this.color = color;
    fullness = 10;
    isAlive = true;
    food = new Food("dry bread");
    drink = new Drink("water");
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

  /*

  public String describe() {
    if (tricks.size() == 0) {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows no tricks yet.";
    } else {
      return "This is " + getName() + ". " + "Currently living on " + eats + " and " + drinks + ". " + gender + " knows " + tricks.size() + " tricks.";
    }
  }

   */


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


/*
  public void feed() {
    fullness = 10;
  }

 */


}
