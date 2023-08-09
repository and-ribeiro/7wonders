package com.digitalhouse.wonders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 2500)
    private String description;
    private String address;
    @Column(length = 2500)
    private String safetyRules;
    @Column(length = 2500)
    private String houseRules;
    @ElementCollection
    private Collection<String> attributes = new ArrayList<>();
    private Integer rooms;
    private Integer beds;
    private Integer guests;
    private Integer price;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Image> images = new HashSet<>();
    @OneToMany(mappedBy = "accommodation",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Reservation> reservations = new ArrayList<>();
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Rating> ratings = new ArrayList<>();
    private Double rate;

}
