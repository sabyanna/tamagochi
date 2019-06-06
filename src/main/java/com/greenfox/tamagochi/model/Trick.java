package com.greenfox.tamagochi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tricks")
@Getter
@Setter
public class Trick {

  public Trick() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  public Trick(String name) {
    this.name = name;
  }

  @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Fox> foxes = new ArrayList<>();
  //@OneToMany
  //public Fox fox;

  public void addFox(Fox fox) {
    foxes.add(fox);
  }
}
