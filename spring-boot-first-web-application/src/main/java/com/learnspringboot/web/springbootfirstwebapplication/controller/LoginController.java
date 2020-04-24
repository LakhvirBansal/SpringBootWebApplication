package com.learnspringboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnspringboot.web.springbootfirstwebapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	// DispatcherServelet is the front controller whatever request it comes to the Dispatcherservlet.
	//Model is used to pass data from controller to view (jsp)
	// spring-boot autoconfiguration
	
	@Autowired
	LoginService service;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String handleLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		 
		 if(!service.validUser(name, password)) {
			 model.put("errorMessage", "invalidCredentials");
			 return "login";
		 }
	        model.put("name", name);
	        model.put("password", password);
	        return "welcome";
	    }

}
