package com.blogApp.paylods;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty
    @Size(min = 4,max = 15, message = "user name must be 4 char and max upto 15 only")
    private String name;

    @Email(message = "email cant be empty")
    private String email;

    @NotEmpty(message = "password cant be empty")
    @Size(min =5,max = 12)
    private String password;

    @NotEmpty(message = "about cant be blank")
    private String about;
}
