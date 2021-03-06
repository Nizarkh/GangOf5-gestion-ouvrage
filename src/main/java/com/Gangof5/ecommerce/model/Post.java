package com.Gangof5.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String subject;
	private String text;
	private String picture;
	private Date creationDate;
	private Boolean deleted;
	@ManyToOne
	private User user;

	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	@OneToMany(mappedBy="post")
	private List<React> reacts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public List<React> getReacts() {
		return reacts;
	}
	public void setReacts(List<React> reacts) {
		this.reacts = reacts;
	}
	public Post(int id,String subject, String text, String picture, Date creationDate, Boolean deleted, User user,
			List<Comment> comments, List<React> reacts) {
		super();
		this.id = id;
		this.subject = subject;
		this.text = text;
		this.picture = picture;
		this.creationDate = creationDate;
		this.deleted = deleted;
		this.user = user;
		this.comments = comments;
		this.reacts = reacts;
	}
	public Post() {
		super();
	}



}
	


