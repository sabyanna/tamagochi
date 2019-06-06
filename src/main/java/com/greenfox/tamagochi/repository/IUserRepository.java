package com.greenfox.tamagochi.repository;

import com.greenfox.tamagochi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
  User findByUsername(String username);
}
