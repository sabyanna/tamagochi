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
  @ManyToOne(cascade = CascadeType.ALL)
  private Food food;
  @ManyToOne(cascade = CascadeType.ALL)
  private Drink drink;
  @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Trick> tricks = new ArrayList<>();

  public Fox() {}

  public Fox(String name) {
    this.name = name;
  }

  public Fox(String name, Food food, Drink drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    drink.addFox(this);
    food.addFox(this);
  }

  public void addTrick(Trick trick) {
    tricks.add(trick);
    trick.addFox(this);
  }

}