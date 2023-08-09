package com.digitalhouse.wonders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonManagedReference
    //private Collection<Reservation> reservations = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Accommodation> favorites = new ArrayList<>();

    public void addRole(Role role){
        this.roles.add(role);
    }
}
