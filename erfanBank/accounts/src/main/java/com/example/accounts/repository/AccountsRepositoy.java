package com.example.accounts.repository;

import com.example.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepositoy extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByCustomerId(Long CustomerId);
}