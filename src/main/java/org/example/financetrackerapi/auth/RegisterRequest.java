package org.example.financetrackerapi.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Getter
@AllArgsConstructor
public class RegisterRequest {
    @Email(message = "Must be valid email format")
    @NotBlank(message = "Email Cannot be empty")
    private String email;
    @Length(min = 6,message = "Must be 6 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
