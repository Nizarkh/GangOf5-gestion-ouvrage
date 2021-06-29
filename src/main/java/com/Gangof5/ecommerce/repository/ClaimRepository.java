package com.Gangof5.ecommerce.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.enums.ClaimState;
import com.Gangof5.ecommerce.model.Claim;


@Repository
public interface ClaimRepository  extends CrudRepository<Claim, Integer> {

	  @Query("select c from Claim c join c.userclaim i where i.id=:userId")
			public List<Claim> getClaimsByUserIdJPQL(@Param("userId") int userId);
	  
	  
	  @Query("select c from Claim c where c.claim_state=:state")
			public List<Claim> ListClaimsByState(@Param("state") ClaimState state);
}


