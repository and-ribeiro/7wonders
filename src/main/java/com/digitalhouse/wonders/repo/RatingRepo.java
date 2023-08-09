package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT avg(number) FROM rating where accommodation_id = ?1", nativeQuery = true)
    public Double ratingAverage(Integer accommodation_id);
}
