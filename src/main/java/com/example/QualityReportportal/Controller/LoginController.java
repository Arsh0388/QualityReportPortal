package com.example.QualityReportportal.Controller;
import com.example.QualityReportportal.Request.LoginRequest;
import com.example.QualityReportportal.Response.LoginResponse;

@RestController
@RequestMapping("/api/auth") // this is the base url of classs
public class LoginController {
    /* 
    what the controller class is going to do - 
    Accept request
    Validate input
    Call service
    Return response
    */
    // through annotations we are going to validate whether we are having a correct requestbody  
    // matching the details as per java RegisterRequest class 
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) { 
        // validate the request , register user and login as well 
    }

    @PostMapping("/login")
    public ResponseEntity<Loginresponse> loginUser(@Valid @RequestBody LoginRequest request) { 
        // validate credentials and login user 
    }
}
