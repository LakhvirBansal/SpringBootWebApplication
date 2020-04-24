package com.learnspringboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validUser(String user, String password) {
		 return user.equalsIgnoreCase("lucky") && password.equals("Lucky@10088");
	}
}
