package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "production_order")
public class ProductionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_order_id")
    private Integer productionOrderId;


    @Column
    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private String modifiedDate;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "production_order_state",
            joinColumns = @JoinColumn(name = "production_order_id"),
            inverseJoinColumns = @JoinColumn(name = "state_id"))
    private Set<State> states = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "production_order_status",
            joinColumns = @JoinColumn(name = "production_order_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<Status> statuses = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "production_order_jewelry",
            joinColumns = @JoinColumn(name = "production_order_id"),
            inverseJoinColumns = @JoinColumn(name = "jewelry_id"))
    private Set<Jewelry> jewelries = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "production_order_client",
            joinColumns = @JoinColumn(name = "production_order_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients = new HashSet<>();



}
