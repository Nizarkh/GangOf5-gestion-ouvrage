package com.Gangof5.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.AuthenticationToken;
import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.model.User;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	   List<Post> findByUser(User user);
}