package com.greenfox.tamagochi.repository;

import com.greenfox.tamagochi.model.Drink;
import org.springframework.data.repository.CrudRepository;

public interface IDrinkRepository extends CrudRepository<Drink, Long> {
}
