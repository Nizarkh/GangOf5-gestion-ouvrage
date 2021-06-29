package com.Gangof5.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gangof5.ecommerce.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
