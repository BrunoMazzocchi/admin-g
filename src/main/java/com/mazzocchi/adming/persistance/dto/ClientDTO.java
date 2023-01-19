package com.mazzocchi.adming.persistance.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class ClientDTO {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private String department;

    private String city;
}
