package com.Gangof5.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String content;
	private int rating;
	
	@ManyToOne()
	private Book book;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		 if(rating < 0 || rating > 5) {
	            throw new IllegalArgumentException("Rating must be between 0 and 5, but was: " + rating);
	        }
	        this.rating = rating;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Review(String content, int rating, Book book) {
		super();
		this.content = content;
		this.rating = rating;
		this.book = book;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
