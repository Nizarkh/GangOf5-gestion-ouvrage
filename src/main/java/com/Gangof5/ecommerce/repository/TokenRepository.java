package com.Gangof5.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.AuthenticationToken;
import com.Gangof5.ecommerce.model.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
    
    int deleteByUser(Optional<User> user);
}
