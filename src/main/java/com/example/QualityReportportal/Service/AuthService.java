package com.example.QualityReportportal.Service;

import com.example.QualityReportportal.Response.LoginResponse;
import com.example.QualityReportportal.Request.LoginRequest;
import com.example.QualityReportportal.Repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    private final AuthRepository UserRepository; // database access 
    private final PasswordEncoder passwordEncoder; 

    private LoginResponse login(LoginRequest loginRequest) { 
        UserModal user = userRepository.findByEmailId(request.getEmail())
        .else
    }


}
