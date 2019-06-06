package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Foods")
@Getter
@Setter
public class Food{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @OneToMany ()
  @Column(nullable = true)
  public List<Fox> foxes = new ArrayList<>();

  public Food() {

  }

  public Food(String name) {
    this.name = name;
  }

  public Food(String name, List<Fox> foxes) {
    this.name = name;
    this.foxes = foxes;
  }

  public void addFox(Fox fox) {
    foxes.add(fox);
  }
}

