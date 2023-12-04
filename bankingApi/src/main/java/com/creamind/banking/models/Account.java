package com.creamind.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    private String iban;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdated;


    @OneToOne
    @JoinColumn(name = "accountowner_id")
    private User accountowner;

}
