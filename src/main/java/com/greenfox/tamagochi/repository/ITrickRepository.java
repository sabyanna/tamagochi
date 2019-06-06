package com.greenfox.tamagochi.repository;

import com.greenfox.tamagochi.model.Trick;
import org.springframework.data.repository.CrudRepository;

public interface ITrickRepository  extends CrudRepository<Trick, Long> {
}
