package com.greenfox.tamagochi;

import com.greenfox.tamagochi.Service.DrinkService;
import com.greenfox.tamagochi.Service.FoodService;
import com.greenfox.tamagochi.Service.TrickService;
import com.greenfox.tamagochi.model.Drink;
import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.repository.IDrinkRepository;
import com.greenfox.tamagochi.repository.IFoodRepository;
import com.greenfox.tamagochi.repository.IFoxRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TamagochiApplication implements CommandLineRunner {

  private IFoxRepository foxRepository;
  private IFoodRepository foodRepository;
  private IDrinkRepository drinkRepository;
  private FoodService foodService;
  private DrinkService drinkService;
  private TrickService trickService;

  public TamagochiApplication(IFoxRepository foxRepository, IFoodRepository foodRepository, IDrinkRepository drinkRepository, FoodService foodService, DrinkService drinkService, TrickService trickService) {
    this.foxRepository = foxRepository;
    this.drinkRepository = drinkRepository;
    this.foodRepository = foodRepository;
    this.foodService = foodService;
    this.drinkService = drinkService;
    this.trickService = trickService;
  }

  public static void main(String[] args) {
    SpringApplication.run(TamagochiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    foodService.save(new Food("husospalacsinta"));
    foodService.save(new Food("rakott karfiol"));
    foodService.save(new Food("gnochi"));
    foodService.save(new Food("caesar salad"));
    foodService.save(new Food("rantott sajt"));
    foodService.save(new Food("rantott csirkeszarnyak"));
    foodService.save(new Food("ramen"));
    foodService.save(new Food("dry bread"));
    foodService.save(new Food("husospalacsinta"));
    drinkService.save(new Drink("lemonade"));
    drinkService.save(new Drink("tea"));
    drinkService.save(new Drink("beer"));
    drinkService.save(new Drink("wine"));
    drinkService.save(new Drink("water"));
    drinkService.save(new Drink("beer"));
    drinkService.save(new Drink("water"));
  }
}
