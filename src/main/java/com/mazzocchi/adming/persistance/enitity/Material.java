package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "material")
public class Material {
    @Column(name = "material_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private Integer type;
    @Column
    private Integer stock;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "material_unit_measure",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_measure_id"))
    private Set<UnitMeasure> unitMeasures = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "material_state",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "state_id"))
    private Set<State> states = new HashSet<>();

}
