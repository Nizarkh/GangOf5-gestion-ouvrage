package com.Gangof5.ecommerce.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_name")
	private  String categoryName;

	private  String description;

	private  String imageUrl;

	// add imageURL here

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Book> books;

	public Category() {
	}

	public Category(String categoryName, String description) {
		this.categoryName = categoryName;
		this.description = description;
	}

	public Category( String categoryName,  String description, String imageUrl) {
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
