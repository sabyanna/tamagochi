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

  private Long foxId;

  @OneToMany()
  @Column(nullable = true)
  public List<Fox> foxes  = new ArrayList<>();

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User() {
  }

  public void addFox(Fox fox) {
    foxes.add(fox);
  }
}
