package com.example.QualityReportportal.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String emailAddress;

    @NotBlank
    private String password;

}
