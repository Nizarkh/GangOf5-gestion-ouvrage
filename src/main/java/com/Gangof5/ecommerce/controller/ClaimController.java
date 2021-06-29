package com.Gangof5.ecommerce.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.config.MessageResponse;
import com.Gangof5.ecommerce.dto.claim.RequestClaimDto;
import com.Gangof5.ecommerce.enums.ClaimState;
import com.Gangof5.ecommerce.model.Claim;
import com.Gangof5.ecommerce.service.ClaimService;

import hirondelle.date4j.DateTime;


@RestController
@RequestMapping("/Claim")
public class ClaimController {
	 
	@Autowired private ClaimService claimservice;
	 
	
	@GetMapping("/all")
	public ResponseEntity<List<Claim>> getClaims(@RequestParam("token") String token) {
		List<Claim> dtos = claimservice.listClaims(token);
		return new ResponseEntity<List<Claim>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/getClaimsByUserId")
	public ResponseEntity<List<Claim>> getClaimsByUserId(@RequestParam("token") String token, 
														@RequestParam("idUser") Integer idUser) {
		List<Claim> claims = claimservice.getClaimsByUserId(token, idUser);
		return new ResponseEntity<List<Claim>>(claims, HttpStatus.OK);
	}
	
	@GetMapping("/getClaimsByState")
	public ResponseEntity<List<Claim>> getClaimsByState(@RequestParam("token") String token, 
														@RequestParam("state") ClaimState state) {
		List<Claim> claims = claimservice.ListClaimsByState(token, state);
		return new ResponseEntity<List<Claim>>(claims, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/getClaim")
	public Optional<Claim> getClaim(@RequestParam("token") String token, @RequestParam("idclaim") Integer idclaim ) {
	
		return claimservice.getClaim(token, idclaim);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody Claim claim) {
		claimservice.addClaim(claim);
		return new ResponseEntity<>(new ApiResponse(true, "Claim has been created."), HttpStatus.CREATED);
	}
	
	@PostMapping("/addClaim")
    public Claim addClaim(@RequestParam("token") String token, @RequestBody RequestClaimDto requestClaim) {
        return claimservice.createClaim(token, requestClaim);
    }
	
	@PostMapping("/SetClaimInProgress")
	public Claim SetClaimInProgress(@RequestParam("token") String token, @RequestParam("idclaim") Integer idclaim ) {
	
		 return claimservice.SetClaimInProgress(token, idclaim);
	}
	
	@PostMapping("/SetClaimAsResolved")
	public MessageResponse SetClaimAsResolved(@RequestParam("token") String token, @RequestParam("idclaim") Integer idclaim ) {
	
		 return claimservice.SetClaimAsResolved(token, idclaim);
	}
	
	
	@GetMapping("/date")
	public Long date (){
		DateTime now = DateTime.now(TimeZone.getDefault());
	    DateTime sixDaysBehind = now.minusDays(6);
	 
	    long diff = Math.abs(now.numDaysFrom(sixDaysBehind));
		return diff;
	}
	
	
		@GetMapping("/date2")
		public Long date2 (){
			LocalDateTime now = LocalDateTime.now();
		    LocalDateTime sixMinutesBehind = now.minusMinutes(60);

		    Duration duration = Duration.between(now, sixMinutesBehind);
		    long diff = Math.abs(duration.toMinutes());
			return diff;
	}
	
	
	
	
	
	
	
}
