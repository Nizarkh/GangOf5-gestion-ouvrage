package com.Gangof5.ecommerce.service;

import static com.Gangof5.ecommerce.config.MessageStrings.CLAIM_RESOLVED;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Gangof5.ecommerce.config.MessageResponse;
import com.Gangof5.ecommerce.config.MessageStrings;
import com.Gangof5.ecommerce.dto.claim.RequestClaimDto;
import com.Gangof5.ecommerce.enums.ClaimState;
import com.Gangof5.ecommerce.enums.Role;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.exceptions.CustomException;
import com.Gangof5.ecommerce.model.Claim;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.repository.ClaimRepository;
import com.Gangof5.ecommerce.utils.Helper;

@Service
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepo;
	@Autowired
	AuthenticationService authenticationService;

	Logger logger = LoggerFactory.getLogger(ClaimService.class);
	LocalDateTime now = LocalDateTime.now();
	
	
	/*
	 * to manage the autorisation to your crud use token
	 * 
	 *  first   :  add both functions "boolean canCrudUser" in your service 
	 * second   :  use the following blocks to set autorisation only fo admin or manager like code bellow
	 */
	
	/*
	 * public List<Claim> listClaims(String token) throws CustomException, AuthenticationFailException {
			User managerUser = authenticationService.getUser(token);
			if (!canCrudUser(managerUser.getRole())) {
				// user can't create new user
				throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
			}
			
			// .............
			
	 */
	
	
	boolean canCrudUser(Role role) {
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		return false;
	}

	boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
		Role role = userUpdating.getRole();
		// admin and manager can crud any user
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		// user can update his own record, but not his role
		if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
			return true;
		}
		return false;
	}
	
	
	
	

	public void addClaim(Claim claim) {
		
		claimRepo.save(claim);
	}

	public List<Claim> listClaims(String token) throws CustomException, AuthenticationFailException {
			User managerUser = authenticationService.getUser(token);
			if (!canCrudUser(managerUser.getRole())) {
				// user can't create new user
				throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
			}
		return (List<Claim>) claimRepo.findAll();
	}
	
	public Optional<Claim> getClaim(String token, Integer id) throws CustomException, AuthenticationFailException {
		User managerUser = authenticationService.getUser(token);
		if (!canCrudUser(managerUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
	return  claimRepo.findById(id);
}

	
	public List<Claim> getClaimsByUserId(String token, Integer id) throws CustomException, AuthenticationFailException {
		User managerUser = authenticationService.getUser(token);
		if (!canCrudUser(managerUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
	return (List<Claim>) claimRepo.getClaimsByUserIdJPQL(id);
	
	
}
	public List<Claim> ListClaimsByState(String token, ClaimState state) throws CustomException, AuthenticationFailException {
		User managerUser = authenticationService.getUser(token);
		if (!canCrudUser(managerUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
	return (List<Claim>) claimRepo.ListClaimsByState(state);
}
	
	
	public Claim createClaim(String token, RequestClaimDto requestClaim) throws AuthenticationFailException {
		
		User LoggedUser = authenticationService.getUser(token);
		if (!Helper.notNull(token)) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_PRESENT);
		}
		if (!Helper.notNull(authenticationService.getUser(token))) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_VALID);
		}
		Claim claim = new Claim(now ,requestClaim.getSubject(), requestClaim.getBody(), ClaimState.UNRESOLVED);
		claim.setUserclaim(LoggedUser);
		return claimRepo.save(claim);
	}
	
	
	public MessageResponse SetClaimAsResolved(String token, Integer idClaim) throws CustomException, AuthenticationFailException {
		User managerUser = authenticationService.getUser(token);
		logger.info(token);
		if (!canCrudUser(managerUser.getRole())) {
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		if (!Helper.notNull(idClaim)) {
			// token not present
			throw new CustomException("claim not present");
		}
		Claim claim = claimRepo.findById(idClaim).get();
		logger.info("ID Claim = "+claim.getId());
		claim.setClaim_state(ClaimState.RESOLVED);
		logger.info("Claim_state Before = "+claim.getClaim_state());
		logger.info("getResolvedDate Before = "+claim.getResolvedDate());
		claim.setResolvedDate(now);
		logger.info("getResolvedDate after set = "+claim.getResolvedDate());
		
	Duration duration = Duration.between(now,claim.getCreatedDate() );
	
	long diff = Math.abs(duration.toMinutes());
	
	logger.info("Duration Time to set claim resolved = "+duration);
	logger.info("Duration Time to set claim resolved = "+diff);
	claimRepo.save(claim);
	 return new MessageResponse("Good Job : Claim was resolved in " + duration + " exactly in "+diff+ " minute");
}
	
	
	public Claim SetClaimInProgress(String token, Integer idClaim) throws CustomException, AuthenticationFailException {
		User managerUser = authenticationService.getUser(token);
		logger.info(token);
		if (!canCrudUser(managerUser.getRole())) {
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		if (!Helper.notNull(idClaim)) {
			// token not present
			throw new CustomException("claim not present");
		}
		Claim claim = claimRepo.findById(idClaim).get();
		claim.setClaim_state(ClaimState.IN_PROGRESS);
		//claim.setResolvedDate(now);
	//Duration duration = Duration.between(now,claim.getCreatedDate() );
	//long diff = Math.abs(duration.toMinutes());
	claimRepo.save(claim);
	 //return new MessageResponse("Good Job : Claim was resolved in " + duration + " exactly in "+diff+ " minute");
	return claim;
}
	
	
	
	

}
