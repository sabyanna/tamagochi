package com.greenfox.tamagochi.Service;
import com.greenfox.tamagochi.model.FoxColor;
import com.greenfox.tamagochi.repository.IFoxColorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxColorService {

  private IFoxColorRepository colorRepository;
  public FoxColorService(IFoxColorRepository colorRepository) {
    this.colorRepository = colorRepository;
  }

  public List<FoxColor> findAll() {
    List<FoxColor> colors = new ArrayList<>();
    colorRepository.findAll().forEach(colors::add);
    return colors;
  }

  public FoxColor findById(long id) {
    return colorRepository.findById(id).orElse(null);
  }

  public void save(FoxColor color) {
    colorRepository.save(color);
  }

  public void delete(long id) {
    colorRepository.deleteById(id);
  }
}

