package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Drinks")
@Getter
@Setter
public class Drink {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany (fetch = FetchType.LAZY)
  public List<Fox> foxes = new ArrayList<>();

  public Drink() {
  }

  public Drink(String name) {
    this.name = name;
  }

  public Drink(String name, List<Fox> foxes) {
    this.name = name;
    this.foxes = foxes;
  }

  public void addFox(Fox fox) {
    foxes.add(fox);

  }
}
