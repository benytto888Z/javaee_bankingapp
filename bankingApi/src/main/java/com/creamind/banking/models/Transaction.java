package com.creamind.banking.models;


//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType ttype;

    private String destinationIban;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "accountowner_id")
    private User accountowner;

}
