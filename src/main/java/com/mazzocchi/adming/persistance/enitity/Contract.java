package com.mazzocchi.adming.persistance.enitity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Contract {
   @Column(name = "contract_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    @Column(name = "contract_number")
    private String contractNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


}
