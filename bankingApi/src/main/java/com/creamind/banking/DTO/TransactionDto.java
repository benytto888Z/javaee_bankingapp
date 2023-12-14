package com.creamind.banking.DTO;


import com.creamind.banking.models.Transaction;
import com.creamind.banking.models.TransactionType;
import com.creamind.banking.models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionDto {

    private Integer id;

    private BigDecimal amount;

    private TransactionType ttype;

    private String destinationIban;
    private Integer userId;

    public static TransactionDto fromEntity(Transaction trx){

       return TransactionDto.builder()
                .id(trx.getId())
                .amount(trx.getAmount())
                .ttype(trx.getTtype())
                .destinationIban(trx.getDestinationIban())
                .userId(trx.getAccountowner().getId())
               .build();
    }

    public static Transaction toEntity(TransactionDto trxdto){

        return Transaction.builder()
                .id(trxdto.getId())
                .amount(trxdto.getAmount())
                .ttype(trxdto.getTtype())
                .destinationIban(trxdto.getDestinationIban())
                .accountowner(
                        User.builder()
                                .id(trxdto.getUserId())
                                .build()
                )
                .build();
    }
}
