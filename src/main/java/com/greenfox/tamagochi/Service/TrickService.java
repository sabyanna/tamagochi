package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.model.Drink;
import com.greenfox.tamagochi.model.Trick;
import com.greenfox.tamagochi.repository.ITrickRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrickService {
  private ITrickRepository trickRepository;
  public TrickService(ITrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  public List<Trick> findAll() {
    List<Trick> tricks = new ArrayList<>();
    trickRepository.findAll().forEach(tricks::add);
    return tricks;
  }

  public Trick findById(long id) {
    return trickRepository.findById(id).orElse(null);
  }

  public void save(Trick trick) {
    trickRepository.save(trick);
  }

  public void delete(long id) {
    trickRepository.deleteById(id);
  }

}