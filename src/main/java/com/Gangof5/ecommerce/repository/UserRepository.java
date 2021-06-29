package com.Gangof5.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.enums.Role;
import com.Gangof5.ecommerce.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findByEmail(String email);

    User findUserByEmail(String email);
    
    @Query("select DISTINCT u from User u where u.role=:role")
    List<User> findByRole(@Param("role") Role role);
}
