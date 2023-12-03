package com.creamind.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Addresse {
    @Id
    @GeneratedValue
    private Integer id;


    private String street;
    private Integer houseNumber;
    private Integer zipCode;
    private String city;
    private String country;
}
