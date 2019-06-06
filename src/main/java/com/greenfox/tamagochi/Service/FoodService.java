package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.model.Fox;
import com.greenfox.tamagochi.repository.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

  //List<Food> foodList = new ArrayList<>();
  private IFoodRepository foodRepository;

  public FoodService(IFoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public List<Food> findAll() {
    List<Food> foods = new ArrayList<>();
    foodRepository.findAll().forEach(foods::add);
    return foods;
  }

  public Food findById(long id) {
    return foodRepository.findById(id).orElse(null);
  }

  public void save(Food food) {
    foodRepository.save(food);
  }

  public void delete(long id) {
    foodRepository.deleteById(id);
  }

}
