package com.example.QualityReportportal.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    
    // what kind of response the 
    private int statusCode; 

    private boolean success;

    private String message; 

    private String email; 

    private String token; 

    private String jwtToken;

}
