package com.greenfox.tamagochi;

import com.greenfox.tamagochi.service.*;
import com.greenfox.tamagochi.model.*;
import com.greenfox.tamagochi.repository.*;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
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

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
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

    Food bread = new Food("Dry bread");
    Food sausage = new Food("Sausage");
    Food pizza = new Food("Pizza");
    Food muffin = new Food("Muffin");
    Food hamburger = new Food("Hamburger");
    Food soup = new Food("Soup");
    Food salad = new Food("Salad");

    foodService.save(bread);
    foodService.save(sausage);
    foodService.save(pizza);
    foodService.save(muffin);
    foodService.save(hamburger);
    foodService.save(soup);
    foodService.save(salad);

    Drink water = new Drink("Water");
    Drink lemonade = new Drink("Lemonade");
    Drink tea = new Drink("Tea");
    Drink shake = new Drink("Milk shake");
    Drink wine = new Drink("Wine");
    Drink beer = new Drink("Beer");

    drinkService.save(water);
    drinkService.save(lemonade);
    drinkService.save(tea);
    drinkService.save(shake);
    drinkService.save(wine);
    drinkService.save(beer);

    Trick sleep = new Trick("Sleep");
    Trick play = new Trick("Play");
    Trick ball = new Trick("Catch a ball");
    Trick code = new Trick("Code");
    Trick handstand = new Trick("Hand stand");
    Trick cook = new Trick("Cook");

    trickService.save(sleep);
    trickService.save(play);
    trickService.save(ball);
    trickService.save(code);
    trickService.save(handstand);
    trickService.save(cook);
  }
}
