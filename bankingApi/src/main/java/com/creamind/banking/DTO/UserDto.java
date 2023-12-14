package com.creamind.banking.DTO;


import com.creamind.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public static UserDto fromEntity(User user){
        // null check
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto userdto){
        // null check
        return User.builder()
                .firstname(userdto.getFirstname())
                .lastname(userdto.getLastname())
                .email(userdto.getEmail())
                .password(userdto.getPassword())
                .build();
    }

}
