package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Cart;
import com.Gangof5.ecommerce.model.Order;
import com.Gangof5.ecommerce.model.User;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}
