package com.Gangof5.ecommerce.dto.book;

import com.Gangof5.ecommerce.model.Book;

public class BookDto {

	private String id;
	private String name;

	private int price;
	private String description;
	private String subject;
	private int page_count;
	private String author;
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage_count() {
		return page_count;
	}

	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private Integer categoryId;

	public BookDto(Book book) {
		// this.setId(product.getId());
		// this.setName(product.getName());
		// this.setImageURL(product.getImageURL());
		// this.setDescription(product.getDescription());
		// this.setPrice(product.getPrice());
		// this.setCategoryId(product.getCategory().getId());
		this.setId(book.getId());
		this.setName(book.getFileName());
		this.setPrice(book.getPrice());
		this.setSubject(book.getSubject());
		this.setPage_count(book.getPage_count());
		this.setAuthor(book.getAuthor());
		this.setIsbn(book.getIsbn());
	}

	public BookDto(String name, int price, String description, Integer categoryId) {
		this.name = name;

		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}

	public BookDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
