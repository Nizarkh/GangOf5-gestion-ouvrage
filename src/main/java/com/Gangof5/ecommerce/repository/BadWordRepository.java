package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Gangof5.ecommerce.model.BadWord;

@Repository
public interface BadWordRepository extends CrudRepository<BadWord, Integer> {
}
