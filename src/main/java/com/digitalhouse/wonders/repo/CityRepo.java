package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
    City findByName(String name);
}
