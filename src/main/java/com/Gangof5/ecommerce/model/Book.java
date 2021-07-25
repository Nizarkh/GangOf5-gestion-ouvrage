package com.Gangof5.ecommerce.model;

import com.Gangof5.ecommerce.dto.book.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

	public Book() {
		super();}
		// TODO Auto-generated constructor stub
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fileName;
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Book(int id, String fileName, Date createAt, String fileType,  String isbn, String languages,
			String copyright, String subject, int page_count, String author, List<Review> reviews, int price,
			 User userPrem) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.createAt = createAt;
		this.fileType = fileType;
		
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
		this.reviews = reviews;
		this.price = price;
		this.userPrem = userPrem;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Book(int id, String fileName, String fileType, String isbn, String languages, String copyright,
			String subject, int page_count, String author, List<Review> reviews, int price, 
			User userPrem) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
		this.reviews = reviews;
		this.price = price;
	
		this.userPrem = userPrem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String fileType;



	private String isbn;

	private String languages;
	private String copyright;



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPage_count() {
		return page_count;
	}

	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	private String subject;
	private int page_count;

	private String author;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Review> reviews;

	private int price;

	

	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}

	


	public User getUserPrem() {
		return userPrem;
	}

	public void setUserPrem(User userPrem) {
		this.userPrem = userPrem;
	}

	@OneToOne
	private User userPrem;
}
