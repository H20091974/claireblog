package com.claire.service;

import com.claire.domain.User;

public interface UserService {

	public String getUserProfile(int uid);
	
	public boolean verifyUser(String username, String password);
	
}
