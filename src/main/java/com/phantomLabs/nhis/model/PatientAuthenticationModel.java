package com.phantomLabs.nhis.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PatientAuthenticationModel {
    @NotBlank(message = "Email field must be provided")
    @Email
    private String email;
    @NotBlank(message = "Password field is required")
    @Length(min = 8, message = "Password field should contain at least 8 characters")
    private String password;
}
