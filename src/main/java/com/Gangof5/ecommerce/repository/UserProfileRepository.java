package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gangof5.ecommerce.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
