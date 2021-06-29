package com.Gangof5.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.UserProfile;
import com.Gangof5.ecommerce.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired private UserProfileRepository userRepo;
	

	public void addProfile(UserProfile userProfile) {
		userRepo.save(userProfile);
	}
	
	public List<UserProfile> listProfiles(){
		return userRepo.findAll();		
	}
	
}
