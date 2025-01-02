package com.example.AttachNet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Mandatory field - username")
    private String username;

    @NotBlank(message = "Mandatory field - email")
    @Email
    private String email;

    @NotBlank(message = "Mandatory field")
    private String password;
}
