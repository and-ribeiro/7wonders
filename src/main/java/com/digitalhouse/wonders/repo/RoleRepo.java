package com.digitalhouse.wonders.repo;

import com.digitalhouse.wonders.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
