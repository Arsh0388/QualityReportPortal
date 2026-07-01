package com.example.QualityReportportal.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @Email(message = "Email is Required")
    private String emailAddress;
    
    @NotBlank(message = " password must be present")
    private String password;
}
