package com.demo.jal.model.repository;

import com.demo.jal.model.LoggingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<LoggingAccount, Long> {
    Optional<LoggingAccount> findByEmail(String email);
}
