package com.Gangof5.ecommerce.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;





@Entity(name = "BookUser")
@Table(name = "BookUser")
public class BookUser {
	
	@EmbeddedId
	private BookUserId id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("bookId")
	    private Book book;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("userId")
	    private User user;
	 
	 private String LastIndexWatched;

	public BookUserId getId() {
		return id;
	}

	public void setId(BookUserId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLastIndexWatched() {
		return LastIndexWatched;
	}

	public void setLastIndexWatched(String lastIndexWatched) {
		LastIndexWatched = lastIndexWatched;
	}
	  public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass())
	            return false;
	 
	        BookUser that = (BookUser) o;
	        return Objects.equals(book, that.book) &&
	               Objects.equals(user, that.user);
	    }
	  
	  public int hashCode() {
	        return Objects.hash(book, user);
	    }


}
