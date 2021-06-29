package com.Gangof5.ecommerce.model;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Gangof5.ecommerce.enums.ClaimState;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "claim")
public class Claim {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userclaim;
	
	@Column(name = "created_date")
    private LocalDateTime createdDate;
	private LocalDateTime resolvedDate;
	private String Subject;
	private String body;
	private ClaimState claim_state;
	
	



	public LocalDateTime getResolvedDate() {
		return resolvedDate;
	}


	public Claim(LocalDateTime createdDate, String subject, String body, ClaimState claim_state) {
		super();
		this.createdDate = createdDate;
		Subject = subject;
		this.body = body;
		this.claim_state = claim_state;
	}
	

	public Claim(LocalDateTime createdDate, LocalDateTime resolvedDate, String subject, String body, ClaimState claim_state) {
		super();
		this.createdDate = createdDate;
		this.resolvedDate = resolvedDate;
		Subject = subject;
		this.body = body;
		this.claim_state = claim_state;
	}


	public Claim() {
		

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	



	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public void setResolvedDate(LocalDateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}


	public User getUserclaim() {
		return userclaim;
	}

	public void setUserclaim(User userclaim) {
		this.userclaim = userclaim;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public ClaimState getClaim_state() {
		return claim_state;
	}

	public void setClaim_state(ClaimState claim_state) {
		this.claim_state = claim_state;
	}
	
	
}
