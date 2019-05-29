package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.model.Fox;
import com.greenfox.tamagochi.repository.IFoxRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FoxServiceImpl implements IFoxService {

  private IFoxRepository foxRepository;

  public FoxServiceImpl(IFoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  List<Fox> foxes;
  ArrayList<String> colors;
  ArrayList<String> log = new ArrayList<>();
  private String currentFox;
  //ArrayList<String> tricks;


  public FoxServiceImpl() {
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("black");
    colors.add("pink");
    foxes = new ArrayList<>();
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }

  public ArrayList<String> getColors() {
    return colors;
  }

  public void setColors(ArrayList<String> colors) {
    this.colors = colors;
  }

  public ArrayList<String> getLog() {
    return log;
  }

  public void setLog(ArrayList<String> log) {
    this.log = log;
  }

  public void addLog(String logItem) {
    log.add(logItem);
  }

  public void addFox(Fox fox){
    foxes.add(fox);
  }

  public Fox getFoxByName(String name) {
    return foxes.stream()
            .filter(fox -> fox.getName().equals(name))
            .findAny()
            .orElse(null);
  }

  public boolean isThereFox(String name) {
    return getFoxByName(name) != null;
  }

  public String getCurrentFox() {
    return currentFox;
  }

  public void setCurrentFox(String currentFox) {
    this.currentFox = currentFox;
  }

  public void feed(Fox fox) {
    fox.setFullness(10);
  }

  public String describe(Fox fox) {
    if (fox.getTricks().size() == 0) {
      return "This is " + fox.getName() + ". " + "Currently living on " + fox.getEats() + " and " + fox.getDrinks() + ". " + fox.getGender() + " knows no tricks yet.";
    } else {
      return "This is " + fox.getName() + ". " + "Currently living on " + fox.getEats() + " and " + fox.getDrinks() + ". " + fox.getGender() + " knows " + fox.getTricks().size() + " tricks.";
    }
  }

  @Override
  public List<Fox> findAll() {
    List<Fox> foxList = new ArrayList<>();
    foxRepository.findAll().forEach(foxList::add);
    return foxList;
  }

  @Override
  public Fox findById(long id) {
    return foxRepository.findById(id).orElse(null);
  }

  @Override
  public void save(Fox fox) {
    foxRepository.save(fox);
  }

  @Override
  public void delete(long id) {
    foxRepository.deleteById(id);
  }
}
