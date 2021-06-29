package com.Gangof5.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String text;
	private String picture;
	private Date creationDate;
	private Boolean deleted;
	@ManyToOne
	private User user;

	@OneToMany(mappedBy="post")
    @JsonIgnore
	private List<Comment> comments;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public Post(int id, String text, String picture, Date creationDate, Boolean deleted, User user,
				List<Comment> comments) {
		super();
		this.id = id;
		this.text = text;
		this.picture = picture;
		this.creationDate = creationDate;
		this.deleted = deleted;
		this.user = user;
		this.comments = comments;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}



}
	


