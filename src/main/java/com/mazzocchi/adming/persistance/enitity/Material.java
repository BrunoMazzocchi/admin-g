package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column
    private String unitMeasure;

}
