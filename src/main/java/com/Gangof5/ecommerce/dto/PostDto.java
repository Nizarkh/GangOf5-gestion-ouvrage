package com.Gangof5.ecommerce.dto;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PostDto {
	private int id;
	private String subject;
	private String text;
	private String picture;
	private Date creationDate;
	private Boolean deleted;
	private String byUser;
	private int nbComments;
	private int likes;
	private int dislikes;
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
	public String getByUser() {
		return byUser;
	}
	public void setByUser(String byUser) {
		this.byUser = byUser;
	}

	public int getNbComments() {
		return nbComments;
	}
	public void setNbComments(int nbComments) {
		this.nbComments = nbComments;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public PostDto(int id,String subject, String text, String picture, Date creationDate, Boolean deleted, String byUser, int nbComments,
			int likes, int dislikes) {
		super();
		this.id = id;
		this.subject = subject;
		this.text = text;
		this.picture = picture;
		this.creationDate = creationDate;
		this.deleted = deleted;
		this.byUser = byUser;
		this.nbComments = nbComments;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    public static Comparator<PostDto> PostRate = new Comparator<PostDto>() {
    	public int compare(PostDto post1,PostDto post2)
        {
            return post2.getLikes() -post1.getLikes();
        }
    };

	
}
