package com.Gangof5.ecommerce.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.enums.ClaimState;
import com.Gangof5.ecommerce.enums.Country;
import com.Gangof5.ecommerce.enums.SubjectClaim;
import com.Gangof5.ecommerce.model.Claim;


@Repository
public interface ClaimRepository  extends CrudRepository<Claim, Integer> {

	  @Query("select c from Claim c join c.userclaim i where i.id=:userId")
			public List<Claim> getClaimsByUserIdJPQL(@Param("userId") int userId);
	  
	  
	  @Query("select c from Claim c where c.claim_state=:state")
			public List<Claim> ListClaimsByState(@Param("state") ClaimState state);
	  
	  @Query("select c from Claim c where c.Subject=:subject")
		public List<Claim> ListClaimsBySubject(@Param("subject") SubjectClaim subject);
	  
	@Query("select c from Claim c LEFT JOIN User u on c.userclaim = u.id where u.country=:country")
			
	public List<Claim> ListClaimsByCountry(@Param("country") String country);
	
	@Query("SELECT count(*) FROM Claim c where c.Subject=:subjectclaim")
	public long CountClaimBySubject(@Param("subjectclaim")SubjectClaim subjectclaim);
	
	@Query("SELECT count(*) FROM Claim c where c.claim_state=:state")
	public long CountClaimByState(@Param("state") ClaimState state);
}


