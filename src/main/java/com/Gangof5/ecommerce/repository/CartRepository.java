package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Cart;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.model.WishList;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);

}

