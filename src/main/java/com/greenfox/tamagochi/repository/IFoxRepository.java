package com.greenfox.tamagochi.repository;


import com.greenfox.tamagochi.model.Fox;
import org.springframework.data.repository.CrudRepository;

public interface IFoxRepository  extends CrudRepository<Fox, String> {
}
