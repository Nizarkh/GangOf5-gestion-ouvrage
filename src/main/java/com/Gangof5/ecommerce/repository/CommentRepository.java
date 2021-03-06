package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
