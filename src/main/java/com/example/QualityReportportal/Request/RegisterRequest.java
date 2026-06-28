package com.example.QualityReportportal.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    
    @NotBlank(message = "first Name is required field")
    private String firstName;

    @NotBlank(message = "Last name is a required field")
    private String lastName;

    @NotBlank(message = "Email is required field")
    @Email(message = "Email is not Valid")
    private String emailAddress;

    @NotBlank(message = " password must be present")
    private String password;

}
