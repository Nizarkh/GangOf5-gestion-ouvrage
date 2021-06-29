package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gangof5.ecommerce.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

}
