package com.zllg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zllg.dao.user.UserMapper;
import com.zllg.service.LoginService;

@Service
public class LoginServiceimpl implements LoginService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int count(String str) {
		// TODO Auto-generated method stub
		return userMapper.count();
	}

}
