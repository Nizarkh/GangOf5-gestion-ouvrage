package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Category;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}
