package com.digitalhouse.wonders.service;

import com.digitalhouse.wonders.model.AppUser;
import com.digitalhouse.wonders.model.Reservation;
import com.digitalhouse.wonders.model.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
    Reservation saveReservation(String username, Reservation reservation, Integer accommodationId);
    List<Reservation> getReservationsFromUser(Integer id);
    void deleteReservation(Integer id);
}
