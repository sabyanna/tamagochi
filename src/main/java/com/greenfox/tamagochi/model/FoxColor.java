package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Colors")
@Getter
@Setter
public class FoxColor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany (fetch = FetchType.LAZY)
  public List<Fox> foxes;

  public FoxColor() {
  }

  public FoxColor(String name) {
    foxes = new ArrayList<>();
    this.name = name;
  }

  public FoxColor(String name, List<Fox> foxes) {
    foxes = new ArrayList<>();
    this.name = name;
    this.foxes = foxes;
  }

  public void addFox(Fox fox) {
    foxes.add(fox);
  }
}

