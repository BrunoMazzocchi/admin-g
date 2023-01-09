package com.mazzocchi.adming.persistance.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class CategoryDTO {
    private Integer categoryId;
    private String name;
    private String description;
    private String image;
    private Integer type;
}
