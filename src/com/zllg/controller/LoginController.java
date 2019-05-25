package com.zllg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zllg.dao.user.UserMapper;
import com.zllg.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	LoginService loginService;
@ResponseBody
@RequestMapping("/login.html")
	public String login(){
	
		return String.valueOf(loginService.count("123"));
	}



}

