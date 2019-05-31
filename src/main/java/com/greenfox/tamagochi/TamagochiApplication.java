package com.greenfox.tamagochi;

import com.greenfox.tamagochi.Service.DrinkService;
import com.greenfox.tamagochi.Service.FoodService;
import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.Service.TrickService;
import com.greenfox.tamagochi.model.Drink;
import com.greenfox.tamagochi.model.Food;
import com.greenfox.tamagochi.model.Fox;
import com.greenfox.tamagochi.model.Trick;
import com.greenfox.tamagochi.repository.IDrinkRepository;
import com.greenfox.tamagochi.repository.IFoodRepository;
import com.greenfox.tamagochi.repository.IFoxRepository;
import com.greenfox.tamagochi.repository.ITrickRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TamagochiApplication implements CommandLineRunner {


  private IFoxRepository foxRepository;
  private IFoodRepository foodRepository;
  private FoodService foodService;
  private FoxService foxService;
  private IDrinkRepository drinkRepository;
  private DrinkService drinkService;
  private TrickService trickService;
  private ITrickRepository trickRepository;


  public TamagochiApplication(IFoxRepository foxRepository, IFoodRepository foodRepository, FoodService foodService, FoxService foxService, IDrinkRepository drinkRepository, DrinkService drinkService, TrickService trickService, ITrickRepository trickRepository) {
    this.foxRepository = foxRepository;
    this.foodRepository = foodRepository;
    this.foodService = foodService;
    this.foxService = foxService;
    this.drinkRepository = drinkRepository;
    this.drinkService = drinkService;
    this.trickService = trickService;
    this.trickRepository = trickRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TamagochiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    //Food pali = new Food("husospalacsinta");
    //Drink lemonade = new Drink("lemonade");
    //Trick sleep = new Trick("sleep");
    //Fox fox = new Fox("anna", pali, lemonade);
    //fox.addTrick(sleep);
  }
}
