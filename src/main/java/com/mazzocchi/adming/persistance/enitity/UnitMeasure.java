package com.mazzocchi.adming.persistance.enitity;

import com.mazzocchi.adming.persistance.enitity.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "unit_measure")
@Data
public class UnitMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_measure_id")
    private Integer unitMeasureId;

    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private UnitMeasureName unitMeasureName;
}
