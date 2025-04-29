package com.boccia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boccia.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
