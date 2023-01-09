package com.mazzocchi.adming.persistance.dto;

import lombok.*;

import java.util.*;

@Data
@Setter
@Getter
public class JewelryDTO {
    private Integer jewelryId;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer categoryId;
    private Integer subcategoryId;
    private Integer kilate;

    private List<MaterialDTO> materials;
}
