package com.example.QualityReportportal.Response;

@Getter
@Setter
public class LoginResponse {
    
    // what kind of response the 
    private int statusCode; 

    private String message; 

    private String email; 

    private String token; 

}
