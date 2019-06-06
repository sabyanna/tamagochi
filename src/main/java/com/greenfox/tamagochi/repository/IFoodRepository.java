package com.greenfox.tamagochi.repository;

import com.greenfox.tamagochi.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface IFoodRepository extends CrudRepository<Food, Long> {
}
