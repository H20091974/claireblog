package com.claire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claire.domain.Baby;
import com.claire.domain.User;
import com.claire.mapping.BabyMapper;
import com.claire.mapping.UserMapper;
import com.claire.service.BabyService;
import com.claire.service.UserService;

@Service
public class BabyServiceImpl implements BabyService{
	@Autowired
	private BabyMapper babyMapper ;

	@Override
	public List<Baby> getLuckyBabies() {
		return babyMapper.getLuckyBabies();
	}

	@Override
	public int getBabyNum() {
		// TODO Auto-generated method stub
		return babyMapper.getBabyNum();
	}
	

}
