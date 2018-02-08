package com.claire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claire.domain.User;
import com.claire.mapping.UserMapper;
import com.claire.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String getUserProfile(int uid) {	
		return userMapper.findUserProfileById(uid);
	}

	@Override
	public boolean verifyUser(String username, String password) {
		int count = userMapper.verifyUser(username, password);
		if(count > 0 && count < 2)	return true;
		else	return false;
	}

}
