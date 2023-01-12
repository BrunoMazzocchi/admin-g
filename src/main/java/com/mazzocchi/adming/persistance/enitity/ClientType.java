package com.mazzocchi.adming.persistance.enitity;

import com.mazzocchi.adming.persistance.enitity.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "client_type")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_type_id")
    private Integer clientTypeId;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ClientTypeName clientTypeName;
}
