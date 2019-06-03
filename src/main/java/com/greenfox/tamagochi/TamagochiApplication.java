package com.greenfox.tamagochi;

import com.greenfox.tamagochi.Service.*;
import com.greenfox.tamagochi.model.*;
import com.greenfox.tamagochi.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

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
  private IFoxColorRepository colorRepository;
  private FoxColorService colorService;


  public TamagochiApplication(IFoxRepository foxRepository, IFoodRepository foodRepository, FoodService foodService, FoxService foxService, IDrinkRepository drinkRepository, DrinkService drinkService, TrickService trickService, ITrickRepository trickRepository, IFoxColorRepository colorRepository, FoxColorService colorService) {
    this.foxRepository = foxRepository;
    this.foodRepository = foodRepository;
    this.foodService = foodService;
    this.foxService = foxService;
    this.drinkRepository = drinkRepository;
    this.drinkService = drinkService;
    this.trickService = trickService;
    this.trickRepository = trickRepository;
    this.colorRepository = colorRepository;
    this.colorService = colorService;
  }

  public static void main(String[] args) {
    SpringApplication.run(TamagochiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    FoxColor lime = new FoxColor("lime");
    FoxColor red = new FoxColor("red");
    FoxColor blue = new FoxColor("blue");
    FoxColor black = new FoxColor("black");
    FoxColor pink = new FoxColor("pink");
    colorService.save(lime);
    colorService.save(red);
    colorService.save(blue);
    colorService.save(black);
    colorService.save(pink);

    Food pali = new Food("husospalacsinta");
    foodService.save(pali);

    Drink lemonade = new Drink("lemonade");
    drinkService.save(lemonade);

    Trick sleep = new Trick("sleep");
    trickService.save(sleep);


/*
    Food pali = new Food("husospalacsinta");
    Drink lemonade = new Drink("lemonade");
    Trick sleep = new Trick("sleep");
    Fox fox = new Fox("anna", "She",  pali, lemonade, lime);
    fox.addTrick(sleep);
    foxService.save(fox);

 */
  }
}
