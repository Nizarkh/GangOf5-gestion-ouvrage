//package com.Gangof5.ecommerce.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class BookUserId implements Serializable{
//	
//	private String bookId;
//	private Integer userId;
//	public String getBookId() {
//		return bookId;
//	}
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//	public BookUserId(String bookId, Integer userId) {
//		super();
//		this.bookId = bookId;
//		this.userId = userId;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
//		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BookUserId other = (BookUserId) obj;
//		if (bookId == null) {
//			if (other.bookId != null)
//				return false;
//		} else if (!bookId.equals(other.bookId))
//			return false;
//		if (userId == null) {
//			if (other.userId != null)
//				return false;
//		} else if (!userId.equals(other.userId))
//			return false;
//		return true;
//	}
//	public BookUserId() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//}
