package com.mazzocchi.adming.persistance.dto;

import lombok.*;

import java.util.*;

@Data
@Getter
public class MaterialDTO {
    private Integer materialId;
    private String name;
    private String description;
    private String image;
    private Integer type;
    private Integer stock;

    private String unitMeasure;
}
