package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Integer> {
}
