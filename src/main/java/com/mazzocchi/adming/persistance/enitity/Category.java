package com.mazzocchi.adming.persistance.enitity;

import com.mazzocchi.adming.persistance.enitity.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private CategoryName categoryName;
}
