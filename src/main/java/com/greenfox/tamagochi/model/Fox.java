package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
  private int hunger;
  private int thirst;
  private boolean isAlive;
  private String gender;

  @ManyToOne(cascade = CascadeType.ALL)
  private Food food;

  @ManyToOne(cascade = CascadeType.ALL)
  private FoxColor foxColor;

  @ManyToOne(cascade = CascadeType.ALL)
  private Drink drink;

  @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Trick> tricks = new ArrayList<>();

  public Fox() {
    hunger = 10;
    thirst = 10;
    isAlive = true;
  }

  public Fox(String name, String gender, Food food, Drink drink, FoxColor foxColor) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.gender = gender;
    this.foxColor = foxColor;
    drink.addFox(this);
    food.addFox(this);
    foxColor.addFox(this);
    hunger = 10;
    thirst = 10;
    isAlive = true;
  }

  public void addTrick(Trick trick) {
    tricks.add(trick);
    trick.addFox(this);
  }

  public void setFood(Food food) {
    food.addFox(this);
    this.food = food;
  }

  public void setFoxColor(FoxColor foxColor) {
    foxColor.addFox(this);
    this.foxColor = foxColor;
  }

  public void setDrink(Drink drink) {
    drink.addFox(this);
    this.drink = drink;
  }
}