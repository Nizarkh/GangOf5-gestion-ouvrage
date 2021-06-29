package com.Gangof5.ecommerce.dto.cart;

import com.Gangof5.ecommerce.model.Cart;
import com.Gangof5.ecommerce.model.Book;



public class CartItemDto {
    private Integer id;
    private  Integer userId;
    private  Integer quantity;
    private  Book book;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setUserId(cart.getUser().getId());
        this.setQuantity(cart.getQuantity());
        this.setBook(cart.getBook());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", productName=" + book.getFileName() +
                '}';
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
