package com.example.QualityReportportal.Repository;
import com.example.QualityReportportal.Modals.UserLoginModal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepository extends JpaRepository<UserLoginModal,Long> {

    Optional<UserLoginModal> findByEmailId(String emailId);
    
}
