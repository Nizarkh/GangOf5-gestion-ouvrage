package com.Gangof5.ecommerce.model;

import com.Gangof5.ecommerce.dto.book.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "Book")
@Table(name = "book")
public class Book {
	public Book(String fileName, String fileType, byte[] data){
		
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		
	}

	public Book(String fileName, String fileType, byte[] data, String isbn, String languages, String copyright,
			String subject, int page_count, String author) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
	}
	
public Book(String isbn,String languages,String copyright,String subject,int page_count,String author){
	super();
	
	this.isbn = isbn;
	this.languages = languages;
	this.copyright = copyright;
	this.subject = subject;
	this.page_count = page_count;
	this.author = author;

}
 


	public Book(String id, String fileName, String fileType, byte[] data, String isbn, String languages,
			String copyright, String subject, int page_count, String author, List<Review> reviews) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
		this.reviews = reviews;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String fileName;

	private String fileType;

	@Lob
	private byte[] data;

	private String isbn;

	private String languages;
	private String copyright;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
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
	public Book(String id, String fileName, String fileType, byte[] data, String isbn, String languages,
			String copyright, String subject, int page_count, String author, List<Review> reviews, int price) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
		this.reviews = reviews;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public Book(String id, String fileName, String fileType, byte[] data, String isbn, String languages,
			String copyright, String subject, int page_count, String author, List<Review> reviews, int price,
			Category category) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.isbn = isbn;
		this.languages = languages;
		this.copyright = copyright;
		this.subject = subject;
		this.page_count = page_count;
		this.author = author;
		this.reviews = reviews;
		this.price = price;
		this.category = category;
		
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	Category category;
	
	  @OneToMany(
		        mappedBy = "book",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
		    private List<BookUser> users = new ArrayList<>();
	public List<BookUser> getUsers() {
		return users;
	}

	public User getUserPrem() {
		return userPrem;
	}

	public void setUserPrem(User userPrem) {
		this.userPrem = userPrem;
	}

	public void setUsers(List<BookUser> users) {
		this.users = users;
	}
	@OneToOne
	private User userPrem;
}
