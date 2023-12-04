package com.creamind.banking.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accountuser")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean active;

    @OneToMany(mappedBy = "accountowner")
    private List<Transaction> transactions;


    @OneToMany(mappedBy = "accountowner")
    private List<Contact> contacts;

    // ici on veut que l'netité propriétaire soit User .On peut créer un utilisateur sans compte
    @OneToOne
    private Account account;

    // ici on veut que l'netité propriétaire soit User . On peut créer un utilisateur sans addresse
    @OneToOne
    private Address address;

    @OneToOne
    private Role role;
}
