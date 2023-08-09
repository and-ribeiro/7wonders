package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    @Query(value = "SELECT * FROM reservation where user_id = ?1", nativeQuery = true)
    List<Reservation> selectByUserId(Integer id);
}
