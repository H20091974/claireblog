package com.claire.service;

import org.apache.ibatis.annotations.Param;

import com.claire.domain.User;

public interface UserService {

	public String getUserProfile(int uid);
	
	public boolean verifyUser(String username, String password);
	
	public boolean saveUser(String username, String password);
	
	public boolean updateUserProfile(String firstname, String lastname, String gender, 
			String profile, String description, 
			String email, String region, String street, 
			String city, String country);
	
}
