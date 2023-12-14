package com.creamind.banking.DTO;


import com.creamind.banking.models.Account;
import com.creamind.banking.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AccountDto {

    private Integer id;
    private String iban;
    private UserDto user;
    // ou private Integer accountownerid;
    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getAccountowner()))
                .build();
    }

    public static Account toEntity(AccountDto accountdto){
        return Account.builder()
                .id(accountdto.getId())
                .iban(accountdto.getIban())
                .accountowner(UserDto.toEntity(accountdto.getUser()))
                .build();
    }

}
