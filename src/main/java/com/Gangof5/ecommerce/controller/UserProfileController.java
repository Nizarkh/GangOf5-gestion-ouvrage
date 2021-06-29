package com.Gangof5.ecommerce.controller;

import java.util.List;

import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.model.UserProfile;
import com.Gangof5.ecommerce.service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired private UserProfileService userProfileService;

	@GetMapping("/")
	public ResponseEntity<List<UserProfile>> getUsers() {
		List<UserProfile> dtos = userProfileService.listProfiles();
		return new ResponseEntity<List<UserProfile>>(dtos, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody UserProfile profile) {
		userProfileService.addProfile(profile);
		return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
	}	
}
