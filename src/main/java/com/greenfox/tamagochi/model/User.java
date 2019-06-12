package com.greenfox.tamagochi.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  @Transient
  private String password;

  private String passwordHash;

  private Long currentFox;

  @OneToMany(targetEntity = Fox.class, fetch = FetchType.EAGER, mappedBy = "owner")
  private List<Fox> foxList;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    foxList = new ArrayList<>();
  }

  public User() {
    foxList = new ArrayList<>();
  }

  public void addFox(Fox fox) {
    foxList.add(fox);
  }
}
