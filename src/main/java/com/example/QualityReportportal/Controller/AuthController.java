package com.example.QualityReportportal.Controller;
import com.example.QualityReportportal.Request.LoginRequest;
import com.example.QualityReportportal.Request.RegisterRequest;
import com.example.QualityReportportal.Response.LoginResponse;
import com.example.QualityReportportal.Response.RegisterResponse;
import com.example.QualityReportportal.Service.AuthService;

import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth") // this is the base url of classs
public class AuthController {
    /* 
    what the controller class is going to do - 
    Accept request
    Validate input
    Call service
    Return response
    */
    // through annotations we are going to validate whether we are having a correct requestbody  
    // matching the details as per java RegisterRequest class 
    
    private final AuthService authService;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class); // provide class based logging mechanism for easy tracking and debugging 

    public AuthController(AuthService authService) { 
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) { 
        // validate the request , register user and login as well 
        RegisterResponse registerResponse = this.authService.register(request);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest request) { 
        // validate credentials and login user 
        log.info("entered - controller method");
        System.out.println("entered - controller login method"); 
        LoginResponse loginResponse = authService.login(request);
        return ResponseEntity.ok(loginResponse);
    }
}
