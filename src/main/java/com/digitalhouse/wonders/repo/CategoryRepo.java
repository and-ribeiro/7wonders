package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
