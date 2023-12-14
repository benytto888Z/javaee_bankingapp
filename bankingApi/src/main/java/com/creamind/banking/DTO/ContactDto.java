package com.creamind.banking.DTO;


import com.creamind.banking.models.Contact;
import com.creamind.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContactDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String iban;

    private Integer userId;

    public static ContactDto fromEntity(Contact contact){

        return ContactDto.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getAccountowner().getId())
                .build();

    }

    public static Contact toEntity(ContactDto contactdto){

        return Contact.builder()
                .id(contactdto.getId())
                .firstname(contactdto.getFirstname())
                .lastname(contactdto.getLastname())
                .email(contactdto.getEmail())
                .iban(contactdto.getIban())
                .accountowner(
                        User.builder()
                                .id(contactdto.getUserId())
                                .build()
                )
                .build();

    }
}
