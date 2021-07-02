package com.Gangof5.ecommerce.dto.claim;

import java.time.LocalDateTime;
import com.Gangof5.ecommerce.enums.ClaimState;
import com.Gangof5.ecommerce.enums.SubjectClaim;

public class RequestClaimDto {

	private LocalDateTime createdDate;
	private LocalDateTime resolvedDate;
	private SubjectClaim Subject;
	private String body;
	private ClaimState claim_state;

	
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public SubjectClaim getSubject() {
		return Subject;
	}

	public void setSubject(SubjectClaim subject) {
		Subject = subject;
	}

	public ClaimState getClaim_state() {
		return claim_state;
	}

	public void setClaim_state(ClaimState claim_state) {
		this.claim_state = claim_state;
	}


}
