package com.mazzocchi.adming.persistance.enitity;

import com.mazzocchi.adming.persistance.enitity.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer stateId;

    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private StateName stateName;
}
