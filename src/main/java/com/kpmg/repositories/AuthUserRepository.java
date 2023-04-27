package com.kpmg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpmg.entities.ApplicationUser;

@Repository
public interface AuthUserRepository extends JpaRepository<ApplicationUser,Integer> {
Optional<ApplicationUser> findByUsername(String username);
}
