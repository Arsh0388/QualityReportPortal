package com.example.QualityReportportal.Modals;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/* 
This table contains information required for login purposes 
such as 
email - unique , not nullable
id - which is auto generated
hashed password - not nullable 
 */
@Entity
@Table(name="UserLogin") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor// table name
public class UserLoginModal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @Column(nullable = false, unique = true)
    private String emailId;

    @NotBlank
    @Column(nullable = false)
    private String hashedPassword;
    
}
