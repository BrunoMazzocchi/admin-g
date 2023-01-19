package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "jewerly")
public class Jewelry {
    @Column(name = "jewelry_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jewelryId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private Double price;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column
    private Integer kilate;


    @ManyToMany
    @JoinTable(
            name = "jewelry_category",
            joinColumns = @JoinColumn(name = "jewelry_id", referencedColumnName = "jewelry_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "material_jewelry",
            joinColumns = @JoinColumn(name = "jewelry_id", referencedColumnName = "jewelry_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    )
    private List<Material> materials;

}
