package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepo extends JpaRepository<Accommodation, Integer> {
}
