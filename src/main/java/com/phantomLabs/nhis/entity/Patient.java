package com.phantomLabs.nhis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "patients_table"
)
public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(name = "Patient_Id")
    private Long patientId;
    @NotBlank(message = "First name field must be provided")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Last name field must be provided")
    private String lastName;
    @Column(name = "date_of_birth")
    @NotBlank(message = "Date of birth field must be provided")
    private Date dateOfBirth;
    @Column(name = "patient_gender")
    @NotBlank(message = "Gender field must be provided")
    private char gender;
    @Column(name = "patient_email")
    @NotBlank(message = "Email field must be provided")
    @Email
    private String email;
    @Column(name = "patient_phone_Number")
    @NotBlank(message = "Phone number field must be provided")
    private String phoneNumber;
    @Column(name="patient_address")
    @NotBlank(message = "Address field is required")
    private String address;
    @Column(name = "patient_password")
    @NotBlank(message = "Password field is required")
    @Length(min = 8, message = "Password field should contain at least 8 characters")
    private String password;
}
