package com.example.QualityReportportal.Service;

// my package imports 
import com.example.QualityReportportal.Response.LoginResponse;
import com.example.QualityReportportal.Response.RegisterResponse;
import com.example.QualityReportportal.Request.LoginRequest;
import com.example.QualityReportportal.Request.RegisterRequest;
import com.example.QualityReportportal.Repository.AuthRepository;
import com.example.QualityReportportal.Modals.UserLoginModal;

// spring boot imports 
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Service
public class AuthService {

    private final AuthRepository authRepository; // database access 
    private final PasswordEncoder passwordEncoder; 

    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest loginRequest) { 
        String emailId = loginRequest.getEmailAddress();
        String password = loginRequest.getPassword();
        System.out.println("email is " + emailId);
        Optional<UserLoginModal> userOptional = authRepository.findByEmailId(emailId);

        LoginResponse response = new LoginResponse();
        System.out.println("entered login method ");
        if (userOptional.isEmpty()) {
            response.setSuccess(false);
            response.setStatusCode(404);
            response.setMessage("Invalid Email or Password");
            System.out.println("user not present right now ");
            return response;
        }
        System.out.println("user is present");
        UserLoginModal user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getHashedPassword())) {
            response.setSuccess(false);
            response.setStatusCode(401);
            response.setMessage("Invalid Email or Password");
            return response;
        }
        //create a jwt  Token then 
        System.out.println("need to create jwt token  ");
        
        response.setSuccess(true);
        response.setStatusCode(200);
        response.setMessage("Login successful");
        return response;
    }

    public RegisterResponse register(RegisterRequest request) { 
        // now process this request 
        // check if the user with this email address exists or not , if user exists then return differnet response  - 409  conflict 
        System.out.println("entered register method");
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String emailId = request.getEmailAddress();
        String password = request.getPassword();

        Optional<UserLoginModal> user = authRepository.findByEmailId(emailId);
        RegisterResponse response = new RegisterResponse();
        if (user.isPresent()) { 
            // return status code and message - 409 conflict , user already present 
            response.setSuccess(false);
            response.setStatusCode(409);
            response.setMessage("Email already exist, please use another Email");
            return response;
        }
        System.out.println("user is not present");
        // user is not present continue forward 
        // validate password if password meet all required checks then move forward 
        if (!(validatePassword(password))) { 
            response.setSuccess(false);
            response.setMessage("Password must be of length 9 to 16 characthers long and must contain UpperCase , LowerCase, digits and Special Character");
            System.out.println("password error ");
            return response;
        }
        // validate length of first Name and last Name must be less than 50 characters
        if (firstName.length() >= 50 || lastName.length() >= 50) { 
            response.setSuccess(false);
            response.setMessage("First Name and Last Name must be less than 50 Characters long");
            System.out.println("Input error, greater than 50 characters ");
            return response; 
        }

        // password is validated store the data in database and then work on jwt token and session creation 
        // create a  hash for password and store it 
        System.out.println("password hashing taking place ");
        String hasedPassword = passwordEncoder.encode(password);
        UserLoginModal newUser = new UserLoginModal();
        newUser.setEmailId(emailId);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setHashedPassword(hasedPassword);
        authRepository.save(newUser);
        System.out.println("user saved");
        response.setStatusCode(201);
        response.setMessage("user successfully created");
        response.setSuccess(true);
        return response;
    }

    public boolean validatePassword(String password) { 
        if (password.length() < 9 || password.length() > 16) return false;
        // check if password cotains upper case , lowercase and a special character 
        boolean isNumeric = false;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isSpecialCharacter = false;
        for (int i = 0; i < password.length(); i++) {   
            char pass = password.charAt(i); 
            
            if (Character.isDigit(pass)) {
                isNumeric = true;
            } else if (Character.isUpperCase(pass)) {
                isUpperCase = true;
            } else if (Character.isLowerCase(pass)) {
                isLowerCase = true;
            } else {
                
                isSpecialCharacter = true;
            }
        }
        return isNumeric && isUpperCase && isLowerCase && isSpecialCharacter;
    }

}
