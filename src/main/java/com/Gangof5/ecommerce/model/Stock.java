package com.Gangof5.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Stock  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String label;
	private float price;
	private int priority;
	
	@ManyToOne
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Stock(int id, String label, float price, int priority, Book book) {
		super();
		this.id = id;
		this.label = label;
		this.price = price;
		this.priority = priority;
		this.book = book;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	
	
	
}
