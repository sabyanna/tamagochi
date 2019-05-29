package com.greenfox.tamagochi;

import com.greenfox.tamagochi.repository.IFoxRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TamagochiApplication implements CommandLineRunner {

  private IFoxRepository foxRepository;

  public TamagochiApplication(IFoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TamagochiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
