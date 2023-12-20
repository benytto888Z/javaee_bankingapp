package com.creamind.banking.DTO;


import com.creamind.banking.models.User;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "common.user.error.empty")
    @NotEmpty(message = "le prénom ne doit pas être null")
    @NotBlank(message = "le prénom ne doit pas être null")
    private String firstname;

    @NotNull
    @NotEmpty
    @NotBlank(message = "LASTNAME_IS_BLANK")
    private String lastname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8 , max = 16)
    private String password;

  /*  @Past
    private LocalDateTime birthdate;*/

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
