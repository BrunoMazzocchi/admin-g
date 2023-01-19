package com.mazzocchi.adming.persistance.enitity;

import com.mazzocchi.adming.persistance.enitity.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Column(name = "client_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    @Column(name = "department")
    private String department;

    @Column(name = "city")
    private String city;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "client_state",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "state_id"))
    private Set<State> states = new HashSet<>();
}
