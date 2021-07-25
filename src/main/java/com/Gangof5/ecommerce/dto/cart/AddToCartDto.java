package com.Gangof5.ecommerce.dto.cart;

import com.Gangof5.ecommerce.model.Cart;



public class AddToCartDto {
    private Integer id;
    private  int bookId;
    private  Integer quantity;

    public AddToCartDto() {
    }



    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ",";
    }

    public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


   

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
