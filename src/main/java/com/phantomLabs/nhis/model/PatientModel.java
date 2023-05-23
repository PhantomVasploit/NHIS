package com.phantomLabs.nhis.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientModel {
    private Long patientId;
    @NotBlank(message = "First name field must be provided")
    private String firstName;
    @NotBlank(message = "Last name field must be provided")
    private String lastName;
    @NotBlank(message = "Date of birth field must be provided")
    private Date dateOfBirth;
    @NotBlank(message = "Gender field must be provided")
    private char gender;
    @NotBlank(message = "Email field must be provided")
    @Email
    private String email;
    @NotBlank(message = "Phone number field must be provided")
    private String phoneNumber;
    @NotBlank(message = "Address field is required")
    private String address;
    @NotBlank(message = "Password field is required")
    @Length(min = 8, message = "Password field should contain at least 8 characters")
    private String password;
}
