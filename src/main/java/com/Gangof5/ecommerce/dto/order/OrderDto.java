package com.Gangof5.ecommerce.dto.order;

import com.Gangof5.ecommerce.model.Order;


public class OrderDto {
    private Integer id;
    private  Integer userId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        //this.setUserId(order.getUserId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
