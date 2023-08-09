package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
