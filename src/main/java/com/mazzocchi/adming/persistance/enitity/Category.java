package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private Integer type;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jewelry>  jewelry;
}
