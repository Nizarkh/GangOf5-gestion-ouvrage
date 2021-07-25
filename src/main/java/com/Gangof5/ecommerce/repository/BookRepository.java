package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
