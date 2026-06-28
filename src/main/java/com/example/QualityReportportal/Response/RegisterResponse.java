package com.example.QualityReportportal.Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data; // Assuming you are also using @Data

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private boolean success;
    private String message;
    private String jwtToken;
    private int statusCode;
}