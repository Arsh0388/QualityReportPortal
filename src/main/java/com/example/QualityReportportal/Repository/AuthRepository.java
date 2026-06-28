package com.example.QualityReportportal.Repository;

import com.example.QualityReportportal.Modals.UserLoginModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<UserLoginModal, Long> {

    Optional<UserLoginModal> findByEmailId(String emailId);
}