package com.greenfox.tamagochi.repository;

import com.greenfox.tamagochi.model.FoxColor;
import org.springframework.data.repository.CrudRepository;

public interface IFoxColorRepository extends CrudRepository<FoxColor, Long> {
}
